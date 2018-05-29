package com.pattern.tutor.syntax.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

public class VisibleColumnNameMap {
	
	// (oldColumnName, newColumnName)
	private static final Map<String, String> visibleColumnMap;
	static {
		visibleColumnMap = new HashMap<>();
		visibleColumnMap.put("loc_char", "locChar");
		visibleColumnMap.put("order_type_descr", "orderTypeDescr");
		visibleColumnMap.put("notes", "notes");
		
		visibleColumnMap.put("cust_no", "custNo");
		visibleColumnMap.put("cust_name", "custName");
		visibleColumnMap.put("sales_terr", "salesTerr");
		
		visibleColumnMap.put("total_order", "totalOrder");
		visibleColumnMap.put("ship_to", "shipTo");
		visibleColumnMap.put("full_ship_to", "fullShipTo");
		visibleColumnMap.put("part_list", "partList");
		visibleColumnMap.put("ship_method", "shipMethod");
		visibleColumnMap.put("credit_card_desc", "creditCardDesc");

		visibleColumnMap.put("entry_datetime", "entryDateTime");
		visibleColumnMap.put("entry_name", "entryName");
		visibleColumnMap.put("sales_rel_date", "salesRelDate");
		
		visibleColumnMap.put("sales_que_comment", "salesQueComment");
		visibleColumnMap.put("credit_rel_date", "creditRelDate");
		visibleColumnMap.put("pick_date", "pickDate");
		
		visibleColumnMap.put("qc_date", "qcDate");
		visibleColumnMap.put("wh_cut_off", "whCutOff");
		visibleColumnMap.put("ship_date", "shipDate");
		
		visibleColumnMap.put("customer_po_no", "customerPoNo");
		visibleColumnMap.put("eu_po_no", "euPoNo");
		visibleColumnMap.put("synnex_po", "synnexPo");

		visibleColumnMap.put("upc_code", "upcList");
		visibleColumnMap.put("required_ship_date", "requiredShipDate");
		visibleColumnMap.put("Release", "Release");
		
		visibleColumnMap.put("frt_cust_no", "frtCustNo");
		visibleColumnMap.put("service_days", "serviceDays");
	}
	
	/**
	 * Convert oldColumnName to newColumnName
	 */
	public static String name(String oldColumnName) throws Exception {
		return Optional.ofNullable(visibleColumnMap.get(oldColumnName)).orElse(oldColumnName);
	}
	
	/**
	 * Convert newColumnName to oldColumnName
	 */
	public static String oldName(String newColumnName) throws Exception {
		if (StringUtils.isEmpty(newColumnName)) {
			return null;
		}
		if (!visibleColumnMap.containsValue(newColumnName)) {
			return newColumnName;
		}
		return visibleColumnMap.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), newColumnName)).findFirst().get().getKey();
	}
}

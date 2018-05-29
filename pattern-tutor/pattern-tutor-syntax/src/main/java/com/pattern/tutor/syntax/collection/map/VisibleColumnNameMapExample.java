package com.pattern.tutor.syntax.collection.map;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.pattern.common.utils.PrintlnUtils;

public class VisibleColumnNameMapExample {
	
	public static void main(String[] args) throws Exception {
		final String OOS_DEFAULT_VISIBLE_COLUMN = "orderNo,loc_char,cust_no,cust_name,sales_terr,total_order,ship_to,ship_method,sales_rel_date,sales_que_comment,credit_rel_date,pick_date,ship_date,customer_po_no";
		String[] columns = OOS_DEFAULT_VISIBLE_COLUMN.split(",");
		List<String> newColumns = Arrays.stream(columns).map(oldColumnName -> {
			try {
				return VisibleColumnNameMap.name(oldColumnName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}).filter(Objects::nonNull).collect(Collectors.toList());
		
		PrintlnUtils.println("newColumns={}", newColumns);
		PrintlnUtils.println("size={}", newColumns.size());
	}
}

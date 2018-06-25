package com.pattern.designpattern.apply.allocate.bo;

import java.util.List;
import java.util.Map;

import com.pattern.designpattern.apply.allocate.allocator.Allocator;
import com.pattern.designpattern.apply.allocate.autofillpolicy.vo.AutoFillPolicy;
import com.pattern.designpattern.apply.allocate.autofillpolicy.vo.CustomPolicy;
import com.pattern.designpattern.apply.allocate.inventory.vo.Part;
import com.pattern.designpattern.apply.allocate.validator.AllocateValidator;
import com.pattern.designpattern.apply.allocate.warehouse.vo.WarehouseInfo;

public abstract class AbstractAllocatorEngine implements AllocatorEngine {
	protected String state; // make a class for this
	protected String country;
	protected String zipcode;
	protected String source; // make a class for this
	protected String fromRefType;
	protected int[] skus;
	protected Map<Integer, String> rioRefs;
	protected Map<Integer, String> bhRefs;
	protected String shipMethod;
	protected Map<Integer, Part> inventoryInfo;

	// warehouse related properties
	protected List<WarehouseInfo> primaryWarehouses;
	protected List<WarehouseInfo> usableWarehouses;
	protected List<WarehouseInfo> specificWarehouses;
	protected List<WarehouseInfo> selectedWarehouse;
	protected int custNo;

	// allocate related properties
	protected AutoFillPolicy autofillPolicy;
	protected CustomPolicy customPolicy;
	/*protected LoginInfo loginInfo;*/
	protected Allocator allocator;

	// validate related properties
	protected AllocateValidator allocateValidator;

	// factory properties
/*	ValidateService validateService = ValidateServiceDefaultImpl.getInstance();
	InventoryService inventoryService = InventoryServiceDefaultImpl
			.getInstance();
	WarehouseService warehouseService;*/

}

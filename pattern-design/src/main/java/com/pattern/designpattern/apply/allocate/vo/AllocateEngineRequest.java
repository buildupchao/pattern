package com.pattern.designpattern.apply.allocate.vo;

import java.util.List;
import java.util.Map;

import com.pattern.designpattern.apply.allocate.autofillpolicy.vo.AutoFillPolicy;
import com.pattern.designpattern.apply.allocate.autofillpolicy.vo.CustomPolicy;
import com.pattern.designpattern.apply.allocate.inventory.vo.Part;
import com.pattern.designpattern.apply.allocate.warehouse.vo.WarehouseInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllocateEngineRequest {
	
	AllocateRequest allocateRequest;
	List<WarehouseInfo> warehouses;
	Map<Integer, Part> inventoryInfo;
	String shipMethod;
	AutoFillPolicy autoFillPolicy;
	CustomPolicy customPolicy;
	int salesTerr = 0;
}

package com.pattern.designpattern.apply.allocate.inventory.vo;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Part {
	private int skuNo;
	private Map<Integer, PartInventory> inventoryAvailMap = new HashMap<Integer, PartInventory>();
	private int totalAvailQty;
	
	public void addInventoryInfo(PartInventory inventoryInfo) {
		if (inventoryInfo == null)
			return;
		inventoryAvailMap.put(inventoryInfo.getInvLocNo(), inventoryInfo);
	}
}

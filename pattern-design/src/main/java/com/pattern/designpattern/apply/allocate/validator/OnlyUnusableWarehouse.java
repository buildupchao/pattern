package com.pattern.designpattern.apply.allocate.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;

import com.pattern.designpattern.apply.allocate.inventory.vo.Part;
import com.pattern.designpattern.apply.allocate.inventory.vo.PartInventory;
import com.pattern.designpattern.apply.allocate.vo.AllocateLineRequest;
import com.pattern.designpattern.apply.allocate.vo.AllocateRequest;
import com.pattern.designpattern.apply.allocate.warehouse.vo.WarehouseInfo;

public class OnlyUnusableWarehouse extends AbstractAllocateValidator {

	public OnlyUnusableWarehouse(Map<Integer, Part> inventoryInfo, List<WarehouseInfo> warehouses) {
		super(inventoryInfo, warehouses);
	}

	@Override
	boolean validateImpl(AllocateRequest allocateRequest) {
		List hasStockUnusableWHs = new ArrayList();
		List hasStockUableWHs = new ArrayList();
		for (Iterator<AllocateLineRequest> lineIter = allocateRequest.getLines().values().iterator();
				lineIter.hasNext();) {
			AllocateLineRequest line = lineIter.next();
			Part part = inventoryInfo.get(line.getSkuNo());
			if (part != null) {
				Map<Integer, PartInventory> inventoryAvailMap = part.getInventoryAvailMap();
				if (MapUtils.isNotEmpty(inventoryAvailMap)) {
					for (Iterator<Integer> locNoIterator = inventoryAvailMap.keySet().iterator();
							locNoIterator.hasNext();) {
						Integer locNo = locNoIterator.next();
						if (warehouses.contains(locNo)) {
							if (line.getQty() < inventoryAvailMap.get(locNo).getAvailQty()) {
								hasStockUnusableWHs.add(locNo);
							}
						} else {
							if (line.getQty() < inventoryAvailMap.get(locNo).getAvailQty()) {
								hasStockUnusableWHs.add(locNo);
							}
						}
					}
				}
			}
		}
		if (hasStockUableWHs.size() == 0 && hasStockUnusableWHs.size() > 0) {
			return true;
		}
		return false;
	}

}

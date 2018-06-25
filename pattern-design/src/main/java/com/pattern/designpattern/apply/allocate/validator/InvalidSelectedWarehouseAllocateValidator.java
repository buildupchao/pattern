package com.pattern.designpattern.apply.allocate.validator;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.pattern.designpattern.apply.allocate.inventory.vo.Part;
import com.pattern.designpattern.apply.allocate.vo.AllocateLineRequest;
import com.pattern.designpattern.apply.allocate.vo.AllocateRequest;
import com.pattern.designpattern.apply.allocate.warehouse.vo.WarehouseInfo;

public class InvalidSelectedWarehouseAllocateValidator extends AbstractAllocateValidator {

	public InvalidSelectedWarehouseAllocateValidator(Map<Integer, Part> inventoryInfo, List<WarehouseInfo> warehouses) {
		super(inventoryInfo, warehouses);
	}

	@Override
	boolean validateImpl(AllocateRequest allocateRequest) {
		if (allocateRequest.getLines() == null
				|| allocateRequest.getLines().size() == 0) {
			return true;
		}
		
		int hasSelectWHLine = 0;
		Iterator<AllocateLineRequest> iterator = allocateRequest.getLines().values().iterator();
		
		while (iterator.hasNext()) {
			AllocateLineRequest line = iterator.next();
			if (line.getSelectedWarehouse() > 0) {
				hasSelectWHLine++;
			}
		}
		
		if (hasSelectWHLine != allocateRequest.getLines().size()) {
			return false;
		}
		return false;
	}

}

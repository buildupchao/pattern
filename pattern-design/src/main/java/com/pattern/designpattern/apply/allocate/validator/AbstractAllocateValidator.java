package com.pattern.designpattern.apply.allocate.validator;

import java.util.List;
import java.util.Map;

import com.pattern.designpattern.apply.allocate.inventory.vo.Part;
import com.pattern.designpattern.apply.allocate.vo.AllocateRequest;
import com.pattern.designpattern.apply.allocate.warehouse.vo.WarehouseInfo;

public abstract class AbstractAllocateValidator implements AllocateValidator {
	protected Map<Integer, Part> inventoryInfo;
	protected List<WarehouseInfo> warehouses;
	protected AllocateValidator nextAllocateValidator;

	public AbstractAllocateValidator(Map<Integer, Part> inventoryInfo, List<WarehouseInfo> warehouses) {
		super();
		this.inventoryInfo = inventoryInfo;
		this.warehouses = warehouses;
	}

	public AllocateValidator getNextAllocateValidator() {
		return nextAllocateValidator;
	}

	public void setNextAllocateValidator(AllocateValidator nextAllocateValidator) {
		this.nextAllocateValidator = nextAllocateValidator;
	}

	public void setNextValidator(AllocateValidator allocateValidator) {
		this.setNextAllocateValidator(allocateValidator);
	}
	
	public boolean validate(AllocateRequest allocateRequest) {
		if (validateImpl(allocateRequest)) {
			if (this.getNextAllocateValidator() != null) {
				return this.getNextAllocateValidator().validate(allocateRequest);
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	abstract boolean validateImpl(AllocateRequest allocateRequest);
}

package com.pattern.designpattern.apply.allocate.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllocateLineRequest {

	int skuNo = -1;
	int lineNo = 0;
	int qty = 0;
	int invType = 0;
	int selectedWarehouse = 0;

	public AllocateLineRequest(int skuNo, int lineNo, int qty, int invType, int selectedWarehouse) {
		super();
		this.skuNo = skuNo;
		this.lineNo = lineNo;
		this.qty = qty;
		this.invType = invType;
		this.selectedWarehouse = selectedWarehouse;
	}

}

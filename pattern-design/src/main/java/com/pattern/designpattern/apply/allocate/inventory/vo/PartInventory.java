package com.pattern.designpattern.apply.allocate.inventory.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartInventory {
	public static final int MULTI_LOC_NO = -9999;
	private int skuNo = -1;
	private int invLocNo = -1;
	private int invType = -1;
	private int availQty = 0;
	private int onOrderQty = 0;
	private int onHandQty = 0;
	private int allocQty = 0;
	private int boQty = 0;
	private int bhQty = 0;
	private int rioQty = 0;
	private int dsQty = 0;
	private int intranOut = 0;
	private int intranIn = 0;
	private int wipQty = 0;

	private boolean boAllowed = true;
	private boolean lipDateOverdued = false;
}

package com.pattern.designpattern.apply.allocate.vo;

public class AllocateLineResult {
	public static int ALLOCATED_FAIL = -1;
	public static int ALLOCATED_UNALLOCATED = 0;
	public static int ALLOCATED_SUCCESS = 1;
	public static int ALLOCATED_OVERNIGHT = 2;

	private int poID;
	private int whNo = -1;
	private int lineSeq;
	private int poReserved = 0;
	private int invType = -1;
	private int status = ALLOCATED_UNALLOCATED;

	private int soQty = 0;
	private int boQty = 0;
	float netPrice = 0.0f;
	float unitCost = 0.0f;
	private String refNo;

	@Override
	public String toString() {
		String info = "PO_ID=" + poID + ", Line#=" + lineSeq + ",\n" + "WH#=" + whNo
				+ ", Alloc=" + getPOAllocated() + "(SO=" + getSOQty() + ", BO=" + getBOQty() + ")" 
				+ ", invType=" + invType + ", refNo=" + refNo;
		return info;
	}
	
	public int getPOAllocated() {
		return getPOStockAllocated() + getPOReserved();
	}
	
	public int getPOStockAllocated() {
		return this.soQty + this.boQty;
	}
	
	public int getPOID() {
		return poID;
	}

	public void setPOID(int poID) {
		this.poID = poID;
	}

	public int getWarehouse() {
		return whNo;
	}

	public void setWarehouse(int whNo) {
		this.whNo = whNo;
	}

	public int getLineSeq() {
		return lineSeq;
	}

	public void setLineSeq(int lineSeq) {
		this.lineSeq = lineSeq;
	}

	public int getPOReserved() {
		return poReserved;
	}

	public void setPOReserved(int poReserved) {
		this.poReserved = poReserved;
	}

	public int getInvType() {
		return invType;
	}

	public void setInvType(int invType) {
		this.invType = invType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSOQty() {
		return soQty;
	}

	public void setSOQty(int soQty) {
		this.soQty = soQty;
	}

	public int getBOQty() {
		return boQty;
	}

	public void setBOQty(int boQty) {
		this.boQty = boQty;
	}

	public float getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(float netPrice) {
		this.netPrice = netPrice;
	}

	public float getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(float unitCost) {
		this.unitCost = unitCost;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
}

package com.pattern.designpattern.apply.allocate.autofillpolicy.vo;

public class CustomPolicy {
	public static int UNDEFINED = 0;
	public static int NOT_ALLOWED = -1;
	public static int ALLOWED = 1;
	private boolean autoBOEntire = false;
	private boolean autoBOLine = false;
	private boolean BOAllowed = false;
	private Integer splitAllowed = UNDEFINED;
	
	public boolean isAutoBOEntire() {
		return autoBOEntire;
	}
	
	public void setAutoBOEntire(boolean autoBOEntire) {
		this.autoBOEntire = autoBOEntire;
	}
	
	public boolean isAutoBOLine() {
		return autoBOLine;
	}
	
	public void setAutoBOLine(boolean autoBOLine) {
		this.autoBOLine = autoBOLine;
	}
	
	public boolean isBOAllowed() {
		return BOAllowed;
	}
	
	public void setBOAllowed(boolean bOAllowed) {
		BOAllowed = bOAllowed;
	}
	
	public Integer getSplitAllowed() {
		return splitAllowed;
	}
	
	public void setSplitAllowed(Integer splitAllowed) {
		this.splitAllowed = splitAllowed;
	}
}

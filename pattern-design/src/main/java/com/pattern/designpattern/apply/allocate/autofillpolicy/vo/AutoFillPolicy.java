package com.pattern.designpattern.apply.allocate.autofillpolicy.vo;

import java.util.Hashtable;

public class AutoFillPolicy {
	Hashtable policy = new Hashtable();
	float poAmount;

	public Hashtable getPolicy() {
		return policy;
	}

	public void setPolicy(Hashtable policy) {
		this.policy = policy;
	}

	public float getPoAmount() {
		return poAmount;
	}

	public void setPoAmount(float poAmount) {
		this.poAmount = poAmount;
	}

	public boolean acpopSplitCapability() {
		String value = (String) policy.get("ACPOPSPLIT");
		if (value == null) {
			return false;
		} else if (value.equalsIgnoreCase("Y")) {
			return true;
		}
		return false;
	}
	
	public boolean acpopAutoBOCapability() {
		String value = (String) policy.get("ACPOPBO");
		if (value == null) {
			return false;
		} else if (value.equalsIgnoreCase("Y")) {
			return true;
		}
		return false;
	}
	
	public boolean acpopAutoBOWholePO() {
		String value = (String) policy.get("ACPOPBO1");
		if (value == null) {
			return false;
		} else if (value.equalsIgnoreCase("Y")) {
			return true;
		}
		return false;
	}
	
	public boolean acpopAutoBOLines() {
		String value = (String) policy.get("ACPOPBO2");
		if (value == null) {
			return false;
		} else if (value.equalsIgnoreCase("Y")) {
			return true;
		}
		return false;
	}
	
	public boolean acpopPriceKillCapability() {
		String value = (String) policy.get("PRICEKILL1");
		if (value == null) {
			return false;
		} else if (value.equalsIgnoreCase("Y")) {
			return true;
		}
		return false;
	}
	
	public boolean acpopSkuKillCapability() {
		String value = (String) policy.get("SKUKILL1");
		if (value == null) {
			return false;
		} else if (value.equalsIgnoreCase("Y")) {
			return true;
		}
		return false;
	}
	
	public boolean acpopFillKillCapability() {
		String value = (String) policy.get("FILLKILL1");
		if (value == null) {
			return false;
		} else if (value.equalsIgnoreCase("Y")) {
			return true;
		}
		return false;
	}
	
	public boolean acpopPriceKill2Capability() {
		String value = (String) policy.get("PRICEKILL2");
		if (value == null) {
			return false;
		} else if (value.equalsIgnoreCase("Y")) {
			return true;
		}
		return false;
	}
	
	public boolean acpopSkuKill2Capability() {
		String value = (String) policy.get("SKUKILL2");
		if (value == null) {
			return false;
		} else if (value.equalsIgnoreCase("Y")) {
			return true;
		}
		return false;
	}
	
	public boolean acpopFillKill2Capability() {
		String value = (String) policy.get("FILLKILL2");
		if (value == null) {
			return false;
		} else if (value.equalsIgnoreCase("Y")) {
			return true;
		}
		return false;
	}
	
	public boolean acpopAllWarehouseCapability() {
		String value = (String) policy.get("ALLWHSE");
		if (value == null) {
			return false;
		} else if (value.equalsIgnoreCase("Y")) {
			return true;
		}
		return false;
	}
	
	public boolean acpopSelectedWHOnlyCapability() {
		String value = (String) policy.get("SELECTWHSE");
		if (value == null) {
			return false;
		} else if (value.equalsIgnoreCase("Y")) {
			return true;
		}
		return false;
	}
	
	public boolean acpopRejectCapability() {
		String value = (String) policy.get("ACPOPREJECT");
		if (value == null) {
			return false;
		} else if (value.equalsIgnoreCase("Y")) {
			return true;
		}
		return false;
	}
	
	public boolean acpopShipCutOff() {
		String value = (String) policy.get("SHIPCUTOFF");
		if (value == null) {
			return false;
		} else if (value.equalsIgnoreCase("Y")) {
			return true;
		}
		return false;
	}
	
	public int acpopCapability() {
		if (policy != null) {
			String acpop = (String) policy.get("ACPOP");
			if (acpop == null)
				acpop = "Y";
			String poAmountStr = (String) policy.get("ACPOPMAXPO");
			float amount = 0;
			if (poAmountStr != null)
				amount = new Float(poAmountStr).floatValue();
			if (acpop.equalsIgnoreCase("Y") == true) {
				if (amount == 0 || (amount > 0 && poAmount <= amount))
					return 0; // can be acpop
				else
					return 1; // Cannot be acpop
			} else if (acpop.equalsIgnoreCase("N")) {
				return 2;
			} else {
				return 0;
			}
		}
		return 0;
	}
}

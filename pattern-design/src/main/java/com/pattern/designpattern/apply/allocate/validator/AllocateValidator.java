package com.pattern.designpattern.apply.allocate.validator;

import com.pattern.designpattern.apply.allocate.vo.AllocateRequest;

public interface AllocateValidator {
	boolean validate(AllocateRequest allocateRequest);
	
	void setNextValidator(AllocateValidator allocateValidator);
}

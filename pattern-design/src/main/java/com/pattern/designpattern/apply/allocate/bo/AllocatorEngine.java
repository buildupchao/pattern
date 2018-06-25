package com.pattern.designpattern.apply.allocate.bo;

import com.pattern.designpattern.apply.allocate.vo.AllocateRequest;
import com.pattern.designpattern.apply.allocate.vo.AllocateResult;

public interface AllocatorEngine {
	AllocateResult allocate(AllocateRequest allocateRequest);
}

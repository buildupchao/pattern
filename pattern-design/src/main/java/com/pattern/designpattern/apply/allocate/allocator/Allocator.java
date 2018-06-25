package com.pattern.designpattern.apply.allocate.allocator;

import com.pattern.designpattern.apply.allocate.vo.AllocateRequest;
import com.pattern.designpattern.apply.allocate.vo.AllocateResult;

public interface Allocator {
	
	AllocateResult allocate(AllocateRequest allocateRequest);
	
	Allocator setNextAllocator(Allocator nextAllocator);
}

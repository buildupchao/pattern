package com.pattern.designpattern.apply.allocate.allocator;

import com.pattern.designpattern.apply.allocate.vo.AllocateRequest;
import com.pattern.designpattern.apply.allocate.vo.AllocateResult;

public abstract class AbstractAllocator implements Allocator {

	@Override
	public AllocateResult allocate(AllocateRequest allocateRequest) {
		return null;
	}

	@Override
	public Allocator setNextAllocator(Allocator nextAllocator) {
		return null;
	}
}
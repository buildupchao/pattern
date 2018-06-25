package com.pattern.designpattern.apply.allocate.allocator;

import java.util.HashSet;
import java.util.Set;

import com.pattern.designpattern.apply.allocate.vo.AllocateRequest;

public class AutoBOLinesAllocatorImpl extends MultipleWarehouseAllocatorImpl {
	private AllocateRequest allocateRequest;
	private Set<Integer> failedLines = new HashSet<Integer>();
}

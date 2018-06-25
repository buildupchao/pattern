package com.pattern.designpattern.apply.allocate.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AllocateResult {
	public static int UNALLOCATED = -2;
	public static int SUCCESS = 0;
	public static int FAIL = -1;
	public static int OVERNIGHT = 1;
	
	private List<Integer> allocatedWarehouses = new ArrayList<>();
	private Map<Integer, List<AllocateLineResult>> lines = new HashMap<>();
	private int allocatedResult = UNALLOCATED;
	
	public AllocateResult(AllocateRequest allocateRequest) {
		for (Iterator<AllocateLineRequest> lineIter = 
				allocateRequest.getLines().values().iterator();
				lineIter.hasNext();) {
			AllocateLineRequest line = lineIter.next();
			AllocateLineResult allocateLineResult = new AllocateLineResult();
			allocateLineResult.setStatus(AllocateLineResult.ALLOCATED_UNALLOCATED);
			List<AllocateLineResult> allocateLineResults = new ArrayList<>();
			allocateLineResults.add(allocateLineResult);
			this.setLineAllocateResult(line.getLineNo(), allocateLineResults);
		}
	}
	
	public void setLineAllocateResult(Integer lineNo, List<AllocateLineResult> results) {
		lines.put(lineNo, results);
	}
	
	public int getAllocateResult() {
		return allocatedResult;
	}
	
	public void setAllocatedResult(int allocatedResult) {
		this.allocatedResult = allocatedResult;
	}
	
	public void addAllocatedWarehouses(Integer warehouse) {
		this.allocatedWarehouses.add(warehouse);
	}
	
	public List<Integer> getAllocatedWarehouses() {
		return allocatedWarehouses;
	}
	
	public Map<Integer, List<AllocateLineResult>> getLines() {
		return lines;
	}
}

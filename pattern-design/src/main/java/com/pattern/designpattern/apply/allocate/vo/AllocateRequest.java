package com.pattern.designpattern.apply.allocate.vo;

import java.util.HashMap;
import java.util.Map;

public class AllocateRequest {
	
	private Map<Integer, AllocateLineRequest> lines = new HashMap<>();
	
	public void addLine(AllocateLineRequest line) {
		this.lines.put(line.getSkuNo(), line);
	}
	
	public Map<Integer, AllocateLineRequest> getLines() {
		return this.lines;
	}
}

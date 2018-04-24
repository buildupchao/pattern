package com.pattern.designpattern.prototype;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
public class Attachment {
	
	private String name;
	
	public void download() {
		log.info("Download attachment done.");
	}
}

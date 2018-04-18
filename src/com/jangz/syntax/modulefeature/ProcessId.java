package com.jangz.syntax.modulefeature;

import java.io.IOException;
import java.io.InputStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProcessId {
	
	public static String getLinuxPID() throws IOException, InterruptedException {
		Process process = Runtime.getRuntime().exec(new String[] {"/bin/sh", "-c", "echo $PPID"});
		if (process.waitFor() == 0) {
			InputStream inputStream = process.getInputStream();
			int available = inputStream.available();
			byte[] outputBytes = new byte[available];
			inputStream.read(outputBytes);
			String pid = new String(outputBytes);
			log.info("Your pid is {}.", pid);
			return pid;
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		getLinuxPID();
	}
}

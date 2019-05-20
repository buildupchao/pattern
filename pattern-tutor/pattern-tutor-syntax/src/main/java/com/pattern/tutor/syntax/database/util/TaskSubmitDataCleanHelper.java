package com.pattern.tutor.syntax.database.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class TaskSubmitDataCleanHelper {
	
	public static void main(String[] args) throws IOException {
		String base = "D:/zhangyachao/work/KingSoft/2019/KS任务提交记录数据清洗";
		String fileOutputPath = base;
		String sourceFile = "task_submit.log";
		String targetFile = "data_clean_result.log";
		BufferedReader sourceReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileOutputPath + "/" + sourceFile)));
		FileOutputStream targetDataWriter = new FileOutputStream(fileOutputPath + "/" + targetFile, true);
		
		String sourceLine = null;
		while ((sourceLine = sourceReader.readLine()) != null) {
			if (StringUtils.isBlank(sourceLine) || sourceLine.contains("Submit task=[redisKey=TASK-")) {
				continue;
			}
			String time = sourceLine.substring(0, 19);
			String hs2 = sourceLine.split(",")[1]; // url=[jdbc:hive2://172.31.130.30:10040/default]]
			String[] segments = hs2.split(":"); // using 2, 3
			String host = segments[2].substring(2, segments[2].length());
			int port = Integer.parseInt(segments[3].substring(0, segments[3].indexOf("/")));
			String insertData = String.format("insert into hive_task_submit_monitor(submit_time, host, port) values ('%s', '%s', %d); ", time, host, port);
			targetDataWriter.write((insertData + "\n").getBytes());
		}
		
		if (sourceReader != null) {
			sourceReader.close();
		}
		if (targetDataWriter != null) {
			targetDataWriter.flush();
			targetDataWriter.close();
		}
		System.out.println("DONE");
	}
	
	@Test
	public void test() {
		String str = "2019-05-13 00:30:23"; // 19
		System.out.println(str.length());
	}
}

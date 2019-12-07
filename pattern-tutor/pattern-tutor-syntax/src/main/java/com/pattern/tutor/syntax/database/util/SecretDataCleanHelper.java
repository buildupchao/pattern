package com.pattern.tutor.syntax.database.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class SecretDataCleanHelper {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		String workspace = System.getProperty("user.dir");
		String base = "src/main/resources/database";
		String fileOutputPath = workspace + "/" + base;
		String dataFile = "finalSource.data";
		String resultFile = "finalSourceResult.result";
		BufferedReader dataReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileOutputPath + "/" + dataFile)));
		FileOutputStream targetDataWriter = new FileOutputStream(fileOutputPath + "/" + resultFile, true);
		
		List<Wrapper> wrappers = Lists.newArrayList();
		String line = null;
		while ((line = dataReader.readLine()) != null) {
			wrappers.add(Wrapper.parse(line));
		}

		List<Wrapper> resultWrappers = handleData(wrappers);
		
		for (int i = 0; i < resultWrappers.size(); i++) {
			targetDataWriter.write(resultWrappers.get(i).toString().getBytes());
		}
		
		if (targetDataWriter != null) {
			targetDataWriter.flush();
			targetDataWriter.close();
		}
		if (dataReader != null) {
			dataReader.close();
		}
		System.out.println("DONE");
	}
	
	private static List<Wrapper> handleData(List<Wrapper> wrappers) {
		List<Wrapper> resultWrappers = Lists.newArrayList();
		wrappers.stream()
			.collect(Collectors.groupingBy(Wrapper::getSource, Collectors.groupingBy(Wrapper::getConfigName)))
			.forEach((source, configWrapperMap) -> {
				configWrapperMap.forEach((configName, configWrappers) -> {
					String configGroup = configWrappers.stream().map(Wrapper::getConfigGroup).distinct().collect(Collectors.joining(","));
					
					configWrappers.stream()
						.collect(Collectors.groupingBy(Wrapper::getFormName))
						.forEach((formName, formWrappers) -> {
							String formGroup = formWrappers.stream().map(Wrapper::getFormGroup).distinct().collect(Collectors.joining(","));
								resultWrappers.add(
									Wrapper.builder()
										.source(source)
										.formName(formName)
										.formStatus(formWrappers.get(0).getFormStatus())
										.formGroup(formGroup)
										.configName(configName)
										.configGroup(configGroup)
										.build()
								);
						});
				});
			});
		return resultWrappers;
	}

	@Getter
	@Setter
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	static class Wrapper {
		private String source;
		private String formName;
		private String formStatus;
		private String formGroup;
		private String configName;
		private String configGroup;
		
		public static Wrapper parse(String info) {
			String[] infos = info.split(",");
			return Wrapper.builder()
					.source(infos[0])
					.configName(infos[1])
					.configGroup(infos[2])
					.formName(infos[3])
					.formStatus(infos[4])
					.formGroup(infos[5])
					.build();
		}
		
		@Override
		public String toString() {
			return String.format("%s\t%s\t%s\t%s\t%s\t%s\n", source, configName, configGroup, formName, formStatus, formGroup);
		}
		
		
	}
}

package com.pattern.tutor.syntax.database.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataCleanHelper {
	
	private String sqlWrapper;
	private String separator;
	private String removeStartLabel;

	private volatile LinkedHashSet<String> data = new LinkedHashSet<>();
	private static final String OUTPUT = System.getProperty("user.dir") + "/src/main/java/com/pattern/tutor/syntax/database/_DataCleanResult";
	
	public void loadData(String pathname) {
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(pathname)))) {
			String oneLine = null;
			while ((oneLine = reader.readLine()) != null) {
				if (StringUtils.isNoneBlank(oneLine)) {
					LinkedHashSet<String> oneSet = Arrays.stream(oneLine.split(separator))
						.map(String::trim).filter(StringUtils::isNotEmpty)
						.map(nameWithEmail -> {
							int index = nameWithEmail.indexOf(removeStartLabel);
							if (index == -1) {
								return nameWithEmail;
							}
							return nameWithEmail.subSequence(0, index);
						})
						.map(CharSequence::toString)
						.collect(Collectors.toCollection(LinkedHashSet::new));
					this.data.addAll(oneSet);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String launch() {
		return data.stream().distinct()
				.map(userName -> {
					String[] userNames = userName.trim().split(" ");
					String firstname = "";
					if (userNames.length > 2) {
						for (int i = 0; i < userNames.length - 1; i++) {
							firstname += userNames[i];
						}
					} else {
						firstname = userName;
					}
					return String.format(sqlWrapper, firstname, userNames[userNames.length - 1]);
				})
				.collect(Collectors.joining("\n"));
	}

	public void fire() {
		String result = data.stream().distinct()
				.map(userName -> {
					String[] userNames = userName.trim().split(" ");
					String firstname = "";
					for (int i = 0; i < userNames.length - 1; i++) {
						firstname += userNames[i];
					}
					return String.format(sqlWrapper, firstname, userNames[userNames.length - 1]);
				})
				.collect(Collectors.joining("\n"));

		log.info("result size is {}.", result.split("\n").length);
		try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(OUTPUT)))) {
			outputStream.write(result.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getSqlWrapper() {
		return sqlWrapper;
	}

	public void setSqlWrapper(String sqlWrapper) {
		this.sqlWrapper = sqlWrapper;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public String getRemoveStartLabel() {
		return removeStartLabel;
	}

	public void setRemoveStartLabel(String removeStartLabel) {
		this.removeStartLabel = removeStartLabel;
	}
}

package com.pattern.tutor.syntax.database.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubSqlHelper {

	private String prefix;
	private String suffix;
	private String separator;

	private volatile LinkedHashSet<String> data = new LinkedHashSet<>();
	private static final String OUTPUT = "src/main/resources/database/_result";
	private static final String GROUP_OUTPUT = "src/main/resources/database/_groupby";
	
	public void loadData(String pathname) {
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(pathname)))) {
			this.data = reader.lines().map(String::trim).filter(StringUtils::isNotEmpty)
					.map(str -> {
						return str.split(",")[0];
					})
					.collect(Collectors.toCollection(LinkedHashSet::new));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String launch() {
		final String pre = Optional.ofNullable(prefix).orElse("");
		final String suf = Optional.ofNullable(suffix).orElse("");
		return data.stream().distinct().map(loginid -> pre + loginid + suf).collect(Collectors.joining(","));
	}

	public void fire() {
		final String pre = Optional.ofNullable(prefix).orElse("");
		final String suf = Optional.ofNullable(suffix).orElse("");
		String result = data.stream().distinct().map(loginid -> pre + loginid + suf).collect(Collectors.joining(","));

		log.info("result size is {}.", result.split(",").length);
		try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(OUTPUT)))) {
			outputStream.write(result.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void groupBy() {
		ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
		for (Iterator<String> iter = this.data.iterator(); iter.hasNext();) {
			String key = iter.next();
			map.putIfAbsent(key, map.getOrDefault(key, 1L) + 1L);
		}
		log.info("groupby size is {}.", map.size());
		
		try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(GROUP_OUTPUT)))) {
			map.entrySet().stream().filter(entry -> entry.getValue() > 1)
					.map(entry -> entry.getKey() + "," + entry.getValue()).forEach(res -> {
						try {
							outputStream.write((res + "\n").getBytes());
						} catch (Exception e) {
							e.printStackTrace();
						}
					});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}
}

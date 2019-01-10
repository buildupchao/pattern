package com.pattern.common.utils;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class SqlSpliterUtil {
	
    public static final int MAX_SQL_LENGTH = 4800;

    public static final int SUPPLEMENT = 200;
	
	public static SqlSpliterUtil caller() {
		return new SqlSpliterUtil();
	}
	
	public List<String> splitSql(String sql) {
		/**
		 * If the length of sql equals 5000, directly return.
		 */
		if (sql.length() <= MAX_SQL_LENGTH + SUPPLEMENT) {
			return Lists.newArrayList(sql);
		}
		
		int numberOfSubSql = sql.length() % MAX_SQL_LENGTH != 0 ? (sql.length() / MAX_SQL_LENGTH + 1)
				: sql.length() / MAX_SQL_LENGTH;
		Map<Integer, String> subSqlMap = Maps.newLinkedHashMapWithExpectedSize(numberOfSubSql);
		/**
		 * split sql
		 */
		for (int i = 0; i < numberOfSubSql; i++) {
			int finalIndex = (i + 1) * MAX_SQL_LENGTH <= sql.length() ? (i + 1) * MAX_SQL_LENGTH : sql.length();
			subSqlMap.put(i, sql.substring(i * MAX_SQL_LENGTH, finalIndex));
		}
		for (int i = 0, j = 1; i < subSqlMap.size() && j < subSqlMap.size(); i++, j++) {
			String currentSql = subSqlMap.get(i);
			/**
			 * While the tail of currentSql or the head of nextSubSql is white space, need to append some character
			 * into currentSql from nextSubSql.
			 */
			if (isWhitespaceForLastCharacter(currentSql)
					|| isWhitespaceForLastCharacter(String.valueOf(subSqlMap.get(j).charAt(0)))) {
				String[] middleOutSubSqls = middleOutByMultiLetterWord(subSqlMap.get(j));
				if (StringUtils.isNotEmpty(middleOutSubSqls[0]) && StringUtils.isNotEmpty(middleOutSubSqls[1])) {
					currentSql = currentSql.concat(middleOutSubSqls[0]);
					subSqlMap.put(i, currentSql);
					subSqlMap.put(j, middleOutSubSqls[1]);
				}
			}
		}
		return Lists.newArrayList(subSqlMap.values());
	}

	private boolean isWhitespaceForLastCharacter(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		char lastCharacter = str.charAt(str.length() - 1);
		if (lastCharacter == ' ' || lastCharacter == '\t' || lastCharacter == '\n' || lastCharacter == '\r') {
			return true;
		}
		return false;
	}
	
	private String[] middleOutByMultiLetterWord(String nextSubSql) {
		String[] middleOutSubSqls = new String[2];
		int i = 0;
		while (isWhitespaceForLastCharacter(String.valueOf(nextSubSql.charAt(i))) 
				|| isWhitespaceForLastCharacter(String.valueOf(nextSubSql.charAt(i + 1)))) {
			i++;
		}
		if (i >= 0 && i < nextSubSql.length()) {
			middleOutSubSqls[0] = nextSubSql.substring(0, i + 1);
			middleOutSubSqls[1] = nextSubSql.substring(i + 1);
		}
		return middleOutSubSqls;
	}
}

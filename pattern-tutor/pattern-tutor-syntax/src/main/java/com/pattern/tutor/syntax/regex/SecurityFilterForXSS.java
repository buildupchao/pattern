package com.pattern.tutor.syntax.regex;

public class SecurityFilterForXSS {

	public static void main(String[] args) {
		String value = "2018-06-15";
		String result = securityFilterForXSS(value, true, false, false);
		System.out.printf("result is %s.\n", result);
		
		value = "<89>76%',4\"0/, 656&&213213";
		result = securityFilterForXSS(value, false, true, false);
		System.out.printf("result is %s.\n", result);
		
		value = "My name is jangz.";
		result = securityFilterForXSS(value, false, false, true);
		System.out.printf("result is %s.\n", result);
	}
	
	public static String securityFilterForXSS(String value, boolean isIntType, boolean isCharType, boolean isTextType) {
		if (value == null) {
			return value;
		}
		
		String result = null;
		if (isIntType) {
			result = value.replaceAll("[^0-9]", "");
		} else if (isCharType) {
			result = value.replaceAll("<|>|/|%\\'|\"|&", "");
		} else if (isTextType) {
			result = "non";
		}
		return result;
	}
}

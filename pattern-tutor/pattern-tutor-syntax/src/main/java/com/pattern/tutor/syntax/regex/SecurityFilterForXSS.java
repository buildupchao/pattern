package com.pattern.tutor.syntax.regex;

import java.util.Optional;
import java.util.StringTokenizer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SecurityFilterForXSS {

	public static void main(String[] args) {
		String value = "2018-06-15";
		String result = securityFilterForXSS(value, true, false, false);
		System.out.printf("result is %s.\n", result);
		
		value = "<89>76%',4\"0/, 656&&213213";
		result = securityFilterForXSS(value, false, true, false);
		System.out.printf("result is %s.\n", result);
		
		value = "My name is jangz.%%%%%%%%/\4\"";
		result = securityFilterForXSS(value, false, false, true);
		System.out.printf("result is %s.\n", result);
		
		usingSecurityFilterForXSS();
	}
	
	public static void usingSecurityFilterForXSS() {
		String setting = "method=setting4Sales&amt_level=A&division=Y&vend_no=Y&reason_code=Y&cust_type=Y&vpc_code=Y&next_signer=Y&sales_terr=Y&sku_no=Y&SUBMIT=SUBMIT";
		String result = securityFilterForXSS(setting);
		if (result != null) {//remove non-used parameter!
			result = result.replaceAll("method=setting4Sales&", "");
			result = result.replaceAll("&SUBMIT=SUBMIT", "");
        }
		System.out.printf("new setting is %s.\n", result);
	}
	
	private static String securityFilterForXSS(String setting) {
    	if (setting == null || "".equals(setting)) {
    		return setting;
    	}
    	StringBuffer resultSetting = new StringBuffer("");
    	StringTokenizer tokenizer = new StringTokenizer(setting, "&");
    	while (tokenizer.hasMoreElements()) {
    		String labelValue = (String) tokenizer.nextElement();
    		String[] strs = labelValue.split("=");
    		if (strs != null && strs.length == 1) {
    			resultSetting.append(strs[0]).append("=");
    		} else if (strs != null && strs.length == 2) {
    			resultSetting.append(strs[0]).append("=").append(securityFilterForXSS(strs[1], false, true, false));
    		}
    		resultSetting.append("&");
    	}
    	return resultSetting.subSequence(0, resultSetting.lastIndexOf("&")).toString();
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
			result = encode4Html(value);
		}
		return result;
	}
	
	public static String encode4Html(String value) {
		log.info("the input is " + value);
		value = Optional.ofNullable(value).orElse("");
		if (value.equals(""))
			return "";
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < value.length(); i++) {
			char ch = value.charAt(i);
			if (ch == '<')
				result.append("&lt;");
			else if (ch == '>')
				result.append("&gt;");
			else if (ch == '&')
				result.append("&amp;");
			else if (ch == '"')
				result.append("&quot;");
			else if (ch == '\r')
				result.append("<BR>");
			else if (ch == '\n') {
				if (value.charAt(i - 1) == '\r') {
				} else
					result.append("<BR>");
			} else if (ch == '\t')
				result.append("&nbsp;&nbsp;&nbsp;&nbsp");
			else if (ch == ' ')
				result.append("&nbsp;");
			else
				result.append(ch);
		}
		return result.toString();
	}
}

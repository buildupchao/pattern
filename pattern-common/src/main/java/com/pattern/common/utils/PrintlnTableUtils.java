package com.pattern.common.utils;

import com.blinkfox.minitable.MiniTable;

/**
 * @author buildupchao
 * @date 2019/06/28 15:02
 * @since JDK 1.8
 */
public class PrintlnTableUtils {

	private MiniTable table = null;
	
	public static PrintlnTableUtils newTable() {
		PrintlnTableUtils tableUtils = new PrintlnTableUtils();
		tableUtils.table = new MiniTable();
		return tableUtils;
	}
	
	public PrintlnTableUtils tableHeaders(Object... headers) {
		this.table.addHeaders(headers);
		return this;
	}
	
	public PrintlnTableUtils addDatas(Object... datas) {
		this.table.addDatas(datas);
		return this;
	}
	
	private String render() {
		return this.table.render();
	}
	
	public void println() {
		System.out.println(render());
	}
}

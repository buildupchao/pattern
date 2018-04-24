package com.jangz.syntax.lsp;

public class Sub extends Super {
	@Override
	Integer method(Number n) { // 注意返回值类型
		return 1;
	}
}

class Super {
	Number method(Number n) {
		return n;
	};
}
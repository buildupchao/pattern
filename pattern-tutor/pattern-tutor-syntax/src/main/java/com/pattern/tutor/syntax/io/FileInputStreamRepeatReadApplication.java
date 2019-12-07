package com.pattern.tutor.syntax.io;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * <p>
 * 		FileInputStream中有一个方法时open方法调用的本地的打开文件的方法，
 * FileInputStream就是通过这个方法来打开文件的，所以如果要重写读取这个文件，
 * 不重新创建对象，那么只要调用这个方法就可以了。
 * </p>
 * @author buildupchao
 * @date 2019/09/04 10:29
 * @since JDK 1.8
 */
public class FileInputStreamRepeatReadApplication {

	public static void main(String[] args) throws Exception {
		new FileInputStreamRepeatReadApplication().repeatReadFileInputStream();
	}
	
	public void repeatReadFileInputStream() throws Exception {
		String fileName = "src/main/resources/io/test.txt";
		FileInputStream inputStream = new FileInputStream(fileName);
		byte[] bytes = new byte[1024];
		StringBuilder info = new StringBuilder();
		while ((inputStream.read(bytes)) != -1) {
			info.append(new String(bytes));
		}
		System.out.println(info.toString());
		
		if (inputStream.read() == -1) {
			Class<? extends FileInputStream> cls = inputStream.getClass();
			Method open0 = cls.getDeclaredMethod("open0", String.class);
			open0.setAccessible(true);
			open0.invoke(inputStream, fileName);
		}
		
		info.delete(0,  info.length());
		while ((inputStream.read(bytes)) != -1) {
			info.append(new String(bytes));
		}
		System.out.println(info.toString());
		inputStream.close();
	}
}

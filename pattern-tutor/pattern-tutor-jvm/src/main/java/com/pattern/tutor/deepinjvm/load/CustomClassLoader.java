package com.pattern.tutor.deepinjvm.load;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * The core is that load byte codes file. 
 *
 * @author jangz
 * @since
 */
public class CustomClassLoader extends ClassLoader {

	private String root;
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = loadClassData(name);
		if (classData == null) {
			throw new ClassNotFoundException();
		} else {
			return defineClass(name, classData, 0, classData.length);
		}
	}
	
	private byte[] loadClassData(String className) {
		String fileName = root + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
		try (InputStream in = new FileInputStream(fileName)) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];
			int length = 0;
			while ((length = in.read(buffer)) != -1) {
				baos.write(buffer, 0, length);
			}
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}
}

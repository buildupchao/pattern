package com.pattern.tutor.syntax.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedFileGc {
	
	public static void main(String[] args) throws IOException {
		File tempFile = File.createTempFile("Temp", null);
		tempFile.deleteOnExit();
		
		RandomAccessFile randomAccessFile = new RandomAccessFile(tempFile, "rw");
		FileChannel channel = randomAccessFile.getChannel();
		MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 512);
		
		channel.close();
		randomAccessFile.close();
		mappedByteBuffer = null;
		
		// 如果你注释掉这行，则不能删除tempFile
		// MappedByteBuffer依赖于操作系统，垃圾收集器不能立即回收。但是当我们调用System.gc()垃圾收集器释放句柄，我们可以删除该文件。
		// 推荐一下，“在使用MappedByteBuffer的同时，如果我们正在使用内存敏感程序，那么最好调用System.gc()”。请注意，此行依赖于JVM。
		//System.gc();
		
		if (tempFile.delete()) {
			System.out.println("Successfully deleted: " + tempFile);
		} else {
			System.out.println("Unable to delete: " + tempFile);
		}
	}
}

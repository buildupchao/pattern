package com.jangz.distribution.net.nio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

import com.jangz.utils.PrintlnUtils;

public class FilesExample {

	public static void tryFiles() {
		String currentWorkspace = System.getProperty("user.dir") + File.separator + "src/com/jangz/net/nio2";
		try {
			DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(currentWorkspace));
			Iterator<Path> iterator = directoryStream.iterator();
			while (iterator.hasNext())
				PrintlnUtils.println(iterator.next());
			
			Path path = Files.createDirectories(Paths.get(currentWorkspace + "/logs"));
			PrintlnUtils.println(path.getFileName());
			
			Path file = Files.createFile(Paths.get(currentWorkspace + "/logs/logs.log"));
			Charset charset = Charset.forName("UTF-8");
			String text = "U are so smart that I like you very much!";
			BufferedWriter writer = Files.newBufferedWriter(file, charset, StandardOpenOption.APPEND);
			writer.write(text);
			writer.close();
			
			BufferedReader reader = Files.newBufferedReader(file, charset);
			String line = null;
			while ((line = reader.readLine()) != null)
				PrintlnUtils.println(line);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		tryFiles();
	}
}

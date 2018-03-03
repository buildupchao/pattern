package com.jangz.distribution.net.nio2;

import java.io.File;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PathsExample {

	public static void tryPaths() {
		String currentWorkspace = System.getProperty("user.dir") + File.separator + "src/com/jangz/net/nio2";
		Path path = Paths.get(currentWorkspace + "/BNP.txt");
		log.info("first path={}", path);
		
		path = Paths.get("D:", "work", "learn", "git", "projects", "pattern", "src", "com", "jangz", "net", "nio2", "test.txt");
		log.info("second path={}", path);
		
		path = Paths.get("/work/learn/git/projects/pattern/src/com/jangz/net/nio2/test.txt");
		log.info("third path={}", path);
		
		path = Paths.get(URI.create("file:///work/learn/git/projects/pattern/src/com/jangz/net/nio2/test.txt"));
		log.info("forth path={}", path);
		
		path = FileSystems.getDefault().getPath("/work/learn/git/projects/pattern/src/com/jangz/net/nio2/", "test.txt");
		log.info("fifth path={}", path);
		
		File file = path.toFile();
		log.info("Path to file name={}", file.getName());
		
		URI uri = path.toUri();
		log.info("Path to uri={}", uri);
		
		Path absolutePath = path.toAbsolutePath();
		log.info("Path to absolute path={}", absolutePath);
	}
	
	public static void main(String[] args) {
		tryPaths();
	}
}

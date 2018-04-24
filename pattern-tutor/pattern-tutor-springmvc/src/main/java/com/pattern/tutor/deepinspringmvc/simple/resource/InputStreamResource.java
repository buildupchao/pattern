package com.pattern.tutor.deepinspringmvc.simple.resource;

import java.io.IOException;
import java.io.InputStream;

public interface InputStreamResource {
	InputStream getInputStream() throws IOException;
}

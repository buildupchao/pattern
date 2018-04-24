#### JDK 1.5之后为什么要给Integer设置-128到127的静态缓存？

If a new Integer instance is not required, this method should generally be used in preference tothe constructor Integer(int), as this method is likely to yield significantly better space and time performance by caching frequently requested values.

public static Integer valueOf(int i) {    
	final int offset = 128;    
	if (i >= -128 && i <= 127) { 
		// must cache        
		return IntegerCache.cache[i + offset];    
	}        
	return new Integer(i);
}

valueOf会将常用的值（-128 to 127）cache起来。当i值在这个范围时，会比用构造方法Integer(int)效率和空间上更好。Long也是
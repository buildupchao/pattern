package com.pattern.tutor.syntax.thread;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author buildupchao
 * @date 2019/01/18 14:51
 * @since JDK 1.8
 */
public class TracefullyExitExample {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Enter main function at " + LocalDateTime.now());
		Runtime.getRuntime().addShutdownHook(new Thread(() ->{ 
			System.out.println("ShutdownHook execute start at " + LocalDateTime.now());
			System.out.println("Netty NioEventLoopGroup shutdownGracefully at " + LocalDateTime.now());
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			System.out.println("ShutdownHook execute end at " + LocalDateTime.now());
		}, ""));
		TimeUnit.SECONDS.sleep(7);
		System.exit(0);
	}
}

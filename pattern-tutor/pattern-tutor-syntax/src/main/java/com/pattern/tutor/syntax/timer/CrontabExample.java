package com.pattern.tutor.syntax.timer;

import java.util.Date;

import cn.hutool.cron.CronUtil;

/**
 * <p>
 * 	 通过指定cron方式执行任务<br/>
 * 	资料链接<a href="https://www.bookstack.cn/read/hutool/0f082d6e35363da6.md">https://www.bookstack.cn/read/hutool/0f082d6e35363da6.md</a>
 * </p>
 * 
 * @author buildupchao
 * @date 2020/3/13
 */
public class CrontabExample {

	public static void main(String[] args) throws InterruptedException {
		CronUtil.schedule("18 17 * * *", new Runnable() {
			
			@Override
			public void run() {
				System.out.println("test cron task, it's real! time is " + new Date());
			}
		});
		CronUtil.start();
		while (true) {
			Thread.sleep(1000);
			System.out.println("wait print..." + new Date());
		}
	}
	
}

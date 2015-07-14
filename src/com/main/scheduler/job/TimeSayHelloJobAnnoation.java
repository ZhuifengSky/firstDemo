package com.main.scheduler.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimeSayHelloJobAnnoation {

	@Scheduled(cron = "0/5 * *  * * ? ")
	// 每5秒执行一次
	public void myTest() {
		System.out.println("注解方式定时器进入测试");
	}
}

package com.main.scheduler.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimeSayHelloJobAnnoation {

	@Scheduled(cron = "0/5 * *  * * ? ")
	// ÿ5��ִ��һ��
	public void myTest() {
		System.out.println("ע�ⷽʽ��ʱ���������");
	}
}

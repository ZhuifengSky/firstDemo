package com.main.scheduler.job;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimeSayHelloJobAnnoation {
	// ÿ5��ִ��һ��
	@Scheduled(cron = "0 0/2 * * * ? ")
	public void myTest() {
		System.out.println("ע�ⷽʽ��ʱ���������"+new Date().toString());
	}
}

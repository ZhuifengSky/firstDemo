package com.main.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 订单号生成工具通过单号前缀区分不同订单
 * @author 
 *
 */
public class OrderCodeGeneUtil {
	
	public static String getCourseOrderSn() {
		StringBuffer sn = new StringBuffer();
		sn.append("C");
		sn.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		sn.append(RandomStringGenerator.getRandomNumByLength(5));
		return sn.toString();
	}
	
	public static String getPackageOrderSn() {
		StringBuffer sn = new StringBuffer();
		sn.append("P");
		sn.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		sn.append(RandomStringGenerator.getRandomNumByLength(5));
		return sn.toString();
	}
	
	public static String getMemberOrderSn() {
		StringBuffer sn = new StringBuffer();
		sn.append("M");
		sn.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		sn.append(RandomStringGenerator.getRandomNumByLength(5));
		return sn.toString();
	}
	
}

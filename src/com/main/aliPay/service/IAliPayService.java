package com.main.aliPay.service;
/**
 * Alipay ֧��Service
 * @author pc-zw
 *
 */
public interface IAliPayService {

	
	/**
	 * ֧�����ֻ���ҳ֧��
	 * @param outTradeNo
	 * @param subject
	 * @param totalAmount
	 * @param body
	 * @param timeoutExpress
	 * @return
	 */
	public String aliWapPay(String outTradeNo,String subject,String totalAmount,String body,String timeoutExpress);
	
	
	
	
	
}

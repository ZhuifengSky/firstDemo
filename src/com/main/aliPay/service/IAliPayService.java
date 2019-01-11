package com.main.aliPay.service;
/**
 * Alipay 支付Service
 * @author pc-zw
 *
 */
public interface IAliPayService {

	
	/**
	 * 支付宝手机网页支付
	 * @param outTradeNo
	 * @param subject
	 * @param totalAmount
	 * @param body
	 * @param timeoutExpress
	 * @return
	 */
	public String aliWapPay(String outTradeNo,String subject,String totalAmount,String body,String timeoutExpress);
	
	
	
	
	
}

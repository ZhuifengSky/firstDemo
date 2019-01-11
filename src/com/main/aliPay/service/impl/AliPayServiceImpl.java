package com.main.aliPay.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.main.aliPay.config.AlipayConfig;
import com.main.aliPay.controller.AliPayController;
import com.main.aliPay.service.IAliPayService;
import com.main.common.util.LogFile;
/**
 * aliPay 支付service实现
 * @author pc
 *
 */
@Service
public class AliPayServiceImpl implements IAliPayService{

	//SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签     
    //调用RSA签名方式
	private static final AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
	private Logger log = Logger.getLogger(AliPayController.class);	
	@Override
	public String aliWapPay(String outTradeNo, String subject,
			String totalAmount, String body, String timeoutExpress) {
		String product_code="QUICK_WAP_PAY";
		if (timeoutExpress==null || timeoutExpress.equals("")) {
			timeoutExpress="2m";
		}		 
	    //手机端支付请求
	    AlipayTradeWapPayRequest alipay_request=new AlipayTradeWapPayRequest();	    
	    // 封装请求支付信息
	    AlipayTradeWapPayModel model=new AlipayTradeWapPayModel();
	    model.setOutTradeNo(outTradeNo);
	    model.setSubject(subject);
	    model.setTotalAmount(totalAmount);
	    model.setBody(body);
	    model.setTimeoutExpress(timeoutExpress);
	    model.setProductCode(product_code);
	    alipay_request.setBizModel(model);
	    // 设置异步通知地址
	    alipay_request.setNotifyUrl(AlipayConfig.notify_url);
	    // 设置同步地址
	    alipay_request.setReturnUrl(AlipayConfig.return_url);   
	    String form = "";
	    try {
			// 调用SDK生成表单
			form = client.pageExecute(alipay_request).getBody();		
		} catch (AlipayApiException e) {
			log.error("调用aliPay SDK发生异常，异常："+e.getMessage());
			e.printStackTrace();
		}
	    return form; 
	}

}

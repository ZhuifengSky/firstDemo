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
 * aliPay ֧��serviceʵ��
 * @author pc
 *
 */
@Service
public class AliPayServiceImpl implements IAliPayService{

	//SDK ���������࣬������������������Լ���װ��ǩ������ǩ�������������עǩ������ǩ     
    //����RSAǩ����ʽ
	private static final AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
	private Logger log = Logger.getLogger(AliPayController.class);	
	@Override
	public String aliWapPay(String outTradeNo, String subject,
			String totalAmount, String body, String timeoutExpress) {
		String product_code="QUICK_WAP_PAY";
		if (timeoutExpress==null || timeoutExpress.equals("")) {
			timeoutExpress="2m";
		}		 
	    //�ֻ���֧������
	    AlipayTradeWapPayRequest alipay_request=new AlipayTradeWapPayRequest();	    
	    // ��װ����֧����Ϣ
	    AlipayTradeWapPayModel model=new AlipayTradeWapPayModel();
	    model.setOutTradeNo(outTradeNo);
	    model.setSubject(subject);
	    model.setTotalAmount(totalAmount);
	    model.setBody(body);
	    model.setTimeoutExpress(timeoutExpress);
	    model.setProductCode(product_code);
	    alipay_request.setBizModel(model);
	    // �����첽֪ͨ��ַ
	    alipay_request.setNotifyUrl(AlipayConfig.notify_url);
	    // ����ͬ����ַ
	    alipay_request.setReturnUrl(AlipayConfig.return_url);   
	    String form = "";
	    try {
			// ����SDK���ɱ�
			form = client.pageExecute(alipay_request).getBody();		
		} catch (AlipayApiException e) {
			log.error("����aliPay SDK�����쳣���쳣��"+e.getMessage());
			e.printStackTrace();
		}
	    return form; 
	}

}

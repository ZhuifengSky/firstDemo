package com.main.aliPay.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.aliPay.config.AlipayConfig;
import com.main.aliPay.service.IAliPayService;

/**
 * aliPay֧��������
 * @author pc
 *
 */
@Scope("session")
@Controller
@RequestMapping("/aliPay")
public class AliPayController {

	private Logger log = Logger.getLogger(AliPayController.class);
	@Autowired
	private IAliPayService aliPayService;
	
	/**
	 * ֧�����ֻ���ҳ֧��
	 * @param outTradeNo
	 * @param subject
	 * @param totalAmount
	 * @param body
	 * @param timeoutExpress
	 */
	@RequestMapping("/aliWapPay.do")
	public void aliPay(HttpServletRequest request, HttpServletResponse response, String outTradeNo,String subject,String totalAmount,String body,String timeoutExpress){
		String form = aliPayService.aliWapPay(outTradeNo, subject, totalAmount, body, timeoutExpress);
		response.setContentType("text/html;charset=" + AlipayConfig.CHARSET); 
	    try {
			response.getWriter().write(form);
			//ֱ�ӽ������ı�html�����ҳ�� 
		    response.getWriter().flush(); 
		    response.getWriter().close();
		} catch (IOException e) {
			log.error("��֧����ɺ�ı������ҳ�淢��IO�쳣���쳣"+e.getMessage());
			e.printStackTrace();
		}
	}
	
}

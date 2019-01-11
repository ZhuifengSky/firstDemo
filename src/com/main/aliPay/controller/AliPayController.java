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
 * aliPay支付控制类
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
	 * 支付宝手机网页支付
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
			//直接将完整的表单html输出到页面 
		    response.getWriter().flush(); 
		    response.getWriter().close();
		} catch (IOException e) {
			log.error("将支付完成后的表单输出至页面发生IO异常！异常"+e.getMessage());
			e.printStackTrace();
		}
	}
	
}

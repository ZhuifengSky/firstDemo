package com.main.wx.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.main.common.util.GeneralStrUtil;
import com.main.wx.bean.WxConfig;
import com.main.wx.service.IWechatSupportService;

/**
 * ΢�ſ�����
 *
 */
@Controller
@Scope("session")
@RequestMapping("/weChatLogin")
public class WechatLoginController {

	private Logger log = Logger.getLogger(WechatLoginController.class);
	private WxMpInMemoryConfigStorage config;
	private static final String baseScope = WxConfig.base_scope;
	private static final String userInfoScope = WxConfig.userInfo_scope;
	@Autowired
	private IWechatSupportService wechatService;
	
	private String stateStr;
	
	
	@PostConstruct
	public void init() {
		config = new WxMpInMemoryConfigStorage();
		config.setAppId(WxConfig.appID); // ����΢�Ź��ںŵ�appid
		config.setSecret(WxConfig.secret); // ����΢�Ź��ںŵ�app corpSecret		
		wechatService.setWxMpConfigStorage(config);
	}
 
	
	/**
	 * ������Ȩurl
	 * @param request
	 * @param response
	 */
	@RequestMapping("/authorizationUrl.do")
	public void getAuthorizationUrl(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
    	HttpSession session = request.getSession();
    	String gotohere = request.getParameter("gotohere");
    	stateStr=session.getId()+GeneralStrUtil.getNum(1000, 9999);
    	session.setAttribute("state", stateStr);
    	if (null!=gotohere && !gotohere.equals("")) {
    		try {
    			String result =  wechatService.oauth2buildAuthorizationUrl(gotohere, userInfoScope, stateStr);
    			System.out.println(result);
    			response.sendRedirect(result);
    		} catch (IOException e) {
    			e.printStackTrace();
    			log.error("��ȡ�û��Ǿ�Ĭ��Ȩurl����!");
    		} 		
	    }else{
	    	try {
    			String result =  wechatService.oauth2buildAuthorizationUrl(baseScope, stateStr);
    			System.out.println(result);
    			response.sendRedirect(result);
    		} catch (IOException e) {
    			e.printStackTrace();
    			log.error("��ȡ�û���Ĭ��Ȩurl����!");
    		}
	    }		   					
	}
	
	
	
	@RequestMapping("/callback.do")
	public void callback(HttpServletRequest request, HttpServletResponse response,String state,String code){
		response.setContentType("text/html;charset=utf-8");
    	HttpSession session = request.getSession();
    	Object checkState = session.getAttribute("state");
    	if (null!=checkState && checkState.equals(state)) {    		
			try {
				WxMpOAuth2AccessToken accessToken = wechatService.oauth2getAccessToken(code);			
	    		if (accessToken!=null) {
	    			WxMpUser wxMpUser = wechatService.oauth2getUserInfo(accessToken, null);
	    			Gson gson = new Gson();
	    			String s = gson.toJson(wxMpUser);
	    			System.out.println(s);
				}else{
					try {
						response.sendRedirect(WxConfig.illegal_request);
					} catch (IOException e) {
						e.printStackTrace();
						log.error("accessToken��ȡΪ��!");
					}
				}
			} catch (WxErrorException e1) {
				e1.printStackTrace();
				log.error("��Ȩ��ص��쳣!");
				try {
					response.sendRedirect(WxConfig.server_exception);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else{
			try {
				response.sendRedirect(WxConfig.illegal_request);
			} catch (IOException e) {
				e.printStackTrace();
				log.error("����Ƿ���ת����!");
			}
		}		
	}
}

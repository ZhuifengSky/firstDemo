package com.main.wx.service;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * 微信业务支持service
 *
 */
public interface IWechatSupportService {

	
	/**
	 * 注入微信的相关配置信息
	 * @param config
	 */
	public void setWxMpConfigStorage(WxMpInMemoryConfigStorage config);
	
	/**
	 * 构造静默授权授权url
	 * @param scope
	 * @param state
	 * @return
	 */
	public String oauth2buildAuthorizationUrl(String cope,String state);

	/**
	 * 构造非静默授权授权的url
	 * @param redirectURI
	 * @param scope
	 * @param state
	 * @return
	 */
	public String oauth2buildAuthorizationUrl(String redirectUrl,String cope, String state);
	  
	  
	/**
	 * 使用code换取Accesstoken 
	 * @param code
	 * @return
	 * @throws WxErrorException
	 */
	public WxMpOAuth2AccessToken oauth2getAccessToken(String code) throws WxErrorException;

	
	/**
	 * 使用Accesstoken获取用户信息
	 * @param oAuth2AccessToken
	 * @param lang
	 * @return
	 * @throws WxErrorException
	 */
	public WxMpUser oauth2getUserInfo(WxMpOAuth2AccessToken oAuth2AccessToken, String lang) throws WxErrorException;

	
}

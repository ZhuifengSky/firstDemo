package com.main.wx.service;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * ΢��ҵ��֧��service
 *
 */
public interface IWechatSupportService {

	
	/**
	 * ע��΢�ŵ����������Ϣ
	 * @param config
	 */
	public void setWxMpConfigStorage(WxMpInMemoryConfigStorage config);
	
	/**
	 * ���쾲Ĭ��Ȩ��Ȩurl
	 * @param scope
	 * @param state
	 * @return
	 */
	public String oauth2buildAuthorizationUrl(String cope,String state);

	/**
	 * ����Ǿ�Ĭ��Ȩ��Ȩ��url
	 * @param redirectURI
	 * @param scope
	 * @param state
	 * @return
	 */
	public String oauth2buildAuthorizationUrl(String redirectUrl,String cope, String state);
	  
	  
	/**
	 * ʹ��code��ȡAccesstoken 
	 * @param code
	 * @return
	 * @throws WxErrorException
	 */
	public WxMpOAuth2AccessToken oauth2getAccessToken(String code) throws WxErrorException;

	
	/**
	 * ʹ��Accesstoken��ȡ�û���Ϣ
	 * @param oAuth2AccessToken
	 * @param lang
	 * @return
	 * @throws WxErrorException
	 */
	public WxMpUser oauth2getUserInfo(WxMpOAuth2AccessToken oAuth2AccessToken, String lang) throws WxErrorException;

	
}

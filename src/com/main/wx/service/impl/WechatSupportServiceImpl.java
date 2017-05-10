package com.main.wx.service.impl;



import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.util.http.RequestExecutor;
import me.chanjar.weixin.common.util.http.SimpleGetRequestExecutor;
import me.chanjar.weixin.common.util.http.URIUtil;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import com.main.wx.bean.WxConfig;
import com.main.wx.service.IWechatSupportService;

@Service
public class WechatSupportServiceImpl implements IWechatSupportService{

	
	protected WxMpConfigStorage wxMpConfigStorage;
	
	protected CloseableHttpClient httpClient;
	
	protected HttpHost httpProxy;
	
	private static final String baseRedirectUrl = WxConfig.redirectUrl;
	

	@Override
	public String oauth2buildAuthorizationUrl(String cope,String state) {
		return oauth2buildAuthorizationUrl(baseRedirectUrl,cope, state);
	}

	@Override
	public String oauth2buildAuthorizationUrl(String redirectUrl,String scope, String state) {
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?";
		url += "appid=" + wxMpConfigStorage.getAppId();
		url += "&redirect_uri=" + URIUtil.encodeURIComponent(redirectUrl);
		url += "&response_type=code";
		url += "&scope=" + scope;
		if (state != null) {
			url += "&state=" + state;
		}
		url += "#wechat_redirect";
		return url;
	}
	@Override
	public WxMpOAuth2AccessToken oauth2getAccessToken(String code)
			throws WxErrorException {
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?";
		url += "appid=" + wxMpConfigStorage.getAppId();
		url += "&secret=" + wxMpConfigStorage.getSecret();
		url += "&code=" + code;
		url += "&grant_type=authorization_code";

		try {
			RequestExecutor<String, String> executor = new SimpleGetRequestExecutor();
			String responseText = executor.execute(getHttpclient(), httpProxy, url, null);
			return WxMpOAuth2AccessToken.fromJson(responseText);
		} catch (ClientProtocolException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	

	@Override
	public WxMpUser oauth2getUserInfo(WxMpOAuth2AccessToken oAuth2AccessToken,
			String lang) throws WxErrorException {
		String url = "https://api.weixin.qq.com/sns/userinfo?";
		url += "access_token=" + oAuth2AccessToken.getAccessToken();
		url += "&openid=" + oAuth2AccessToken.getOpenId();
		if (lang == null) {
			url += "&lang=zh_CN";
		} else {
			url += "&lang=" + lang;
		}

		try {
			RequestExecutor<String, String> executor = new SimpleGetRequestExecutor();
			String responseText = executor.execute(getHttpclient(), httpProxy, url, null);
			return WxMpUser.fromJson(responseText);
		} catch (ClientProtocolException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected CloseableHttpClient getHttpclient() {
		return httpClient;
	}

	@Override
	public void setWxMpConfigStorage(WxMpInMemoryConfigStorage config) {
		this.wxMpConfigStorage = config;
		httpClient = HttpClients.createDefault();
		System.out.println(121232);
		System.out.println(23432343);
		/**
		String http_proxy_host = wxMpConfigStorage.getHttp_proxy_host();
		int http_proxy_port = wxMpConfigStorage.getHttp_proxy_port();
		String http_proxy_username = wxMpConfigStorage.getHttp_proxy_username();
		String http_proxy_password = wxMpConfigStorage.getHttp_proxy_password();

		final HttpClientBuilder builder = HttpClients.custom();
		if (StringUtils.isNotBlank(http_proxy_host)) {
			// 使用代理服务器
			if (StringUtils.isNotBlank(http_proxy_username)) {
				// 需要用户认证的代理服务器
				CredentialsProvider credsProvider = new BasicCredentialsProvider();
				credsProvider.setCredentials(new AuthScope(http_proxy_host, http_proxy_port), new UsernamePasswordCredentials(http_proxy_username, http_proxy_password));
				builder.setDefaultCredentialsProvider(credsProvider);
			} else {
				// 无需用户认证的代理服务器
			}
			httpProxy = new HttpHost(http_proxy_host, http_proxy_port);
		}
		if (config.getSSLContext() != null) {
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(config.getSSLContext(), new String[] { "TLSv1" }, null,
			SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			builder.setSSLSocketFactory(sslsf);
		}
		httpClient = builder.build();*/
	}

	
}

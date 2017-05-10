package com.main.wx.bean;


/**
 * 
 * 微信相关配置信息
 */
public class WxConfig {

	/**
	 *  微信分配的公众号ID（开通公众号之后可以获取到）
	 */
	public static String appID = "xxxxxx";
	/**
	 *  设置微信公众号的app corpSecret
	 */
	public static String secret = "xxxxxx";	
	/**
	 *  回调地址
	 */
	public static String redirectUrl = "http://xxx.xx.com/sky.jsp";
	
    //授权作用域（scope参数）
	/**
	 * 静默授权
	 */
	public static String base_scope = "snsapi_base";
	/**
	 * 非静默授权
	 */
	public static String userInfo_scope = "snsapi_userinfo";
	
	/**
	 * 非法请求页面
	 */
	public static String illegal_request = "localhost:8880/springMvcTest/illegal_request.jsp";
	/**
	 * token获取为空
	 */
	public static String accessToken_null = "localhost:8880/springMvcTest/accessToken_null.jsp";
	/**
	 * 系统异常
	 */
	public static String server_exception = "localhost:8880/springMvcTest/500.jsp";

}

package com.main.wx.bean;


/**
 * 
 * ΢�����������Ϣ
 */
public class WxConfig {

	/**
	 *  ΢�ŷ���Ĺ��ں�ID����ͨ���ں�֮����Ի�ȡ����
	 */
	public static String appID = "xxxxxx";
	/**
	 *  ����΢�Ź��ںŵ�app corpSecret
	 */
	public static String secret = "xxxxxx";	
	/**
	 *  �ص���ַ
	 */
	public static String redirectUrl = "http://xxx.xx.com/sky.jsp";
	
    //��Ȩ������scope������
	/**
	 * ��Ĭ��Ȩ
	 */
	public static String base_scope = "snsapi_base";
	/**
	 * �Ǿ�Ĭ��Ȩ
	 */
	public static String userInfo_scope = "snsapi_userinfo";
	
	/**
	 * �Ƿ�����ҳ��
	 */
	public static String illegal_request = "localhost:8880/springMvcTest/illegal_request.jsp";
	/**
	 * token��ȡΪ��
	 */
	public static String accessToken_null = "localhost:8880/springMvcTest/accessToken_null.jsp";
	/**
	 * ϵͳ�쳣
	 */
	public static String server_exception = "localhost:8880/springMvcTest/500.jsp";

}

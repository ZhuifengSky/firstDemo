package com.main.aliPay.bean;

/**
 * ֧����֧�������������
 * @author pc
 *
 */
public class AliPayBaseParams {

	private static  String app_id;    //������Ӧ��ID
	private static  String method;    //�ӿ�����  ʾ�� alipay.trade.wap.pay �ֻ���վ֧��
	private final static  String format="JSON";  //�������ݸ�ʽ
	private static String return_url;  //ͬ���ص�֪ͨ��ַ http/https��ͷ�ַ���
	private static String charset;
	private static String sign_type;  //�̻�����ǩ���ַ�����ʹ�õ�ǩ���㷨���ͣ�Ŀǰ֧��RSA2��RSA���Ƽ�ʹ��RSA2
	private static String sign;       //ǩ��
	private static String timestamp;  //���������ʱ�䣬��ʽ"yyyy-MM-dd HH:mm:ss"
	private final static String version="1.0"; //�汾�̶���1.0
	private static String notify_url; //֧�����첽֪ͨ��ַ
	private static String biz_content ; //ҵ����������ļ��ϣ���󳤶Ȳ��ޣ�����������������������������������������д��ݣ�������ո���Ʒ���ٽ����ĵ�
	
	
	public static String getApp_id() {
		return app_id;
	}
	public static void setApp_id(String app_id) {
		AliPayBaseParams.app_id = app_id;
	}
	public static String getMethod() {
		return method;
	}
	public static void setMethod(String method) {
		AliPayBaseParams.method = method;
	}
	public static String getReturn_url() {
		return return_url;
	}
	public static void setReturn_url(String return_url) {
		AliPayBaseParams.return_url = return_url;
	}
	public static String getCharset() {
		return charset;
	}
	public static void setCharset(String charset) {
		AliPayBaseParams.charset = charset;
	}
	public static String getSign_type() {
		return sign_type;
	}
	public static void setSign_type(String sign_type) {
		AliPayBaseParams.sign_type = sign_type;
	}
	public static String getSign() {
		return sign;
	}
	public static void setSign(String sign) {
		AliPayBaseParams.sign = sign;
	}
	public static String getTimestamp() {
		return timestamp;
	}
	public static void setTimestamp(String timestamp) {
		AliPayBaseParams.timestamp = timestamp;
	}
	public static String getNotify_url() {
		return notify_url;
	}
	public static void setNotify_url(String notify_url) {
		AliPayBaseParams.notify_url = notify_url;
	}
	public static String getBiz_content() {
		return biz_content;
	}
	public static void setBiz_content(String biz_content) {
		AliPayBaseParams.biz_content = biz_content;
	}
	public static String getFormat() {
		return format;
	}
	public static String getVersion() {
		return version;
	}
	
	
	
}

package com.main.aliPay.bean;

/**
 * 支付宝支付公共请求参数
 * @author pc
 *
 */
public class AliPayBaseParams {

	private static  String app_id;    //开发者应用ID
	private static  String method;    //接口名称  示例 alipay.trade.wap.pay 手机网站支付
	private final static  String format="JSON";  //返回数据格式
	private static String return_url;  //同步回调通知地址 http/https开头字符串
	private static String charset;
	private static String sign_type;  //商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
	private static String sign;       //签名
	private static String timestamp;  //发送请求的时间，格式"yyyy-MM-dd HH:mm:ss"
	private final static String version="1.0"; //版本固定传1.0
	private static String notify_url; //支付宝异步通知地址
	private static String biz_content ; //业务请求参数的集合，最大长度不限，除公共参数外所有请求参数都必须放在这个参数中传递，具体参照各产品快速接入文档
	
	
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

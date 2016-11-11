package com.main.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.support.RequestContext;

public class Utility {

	private static Log logger = LogFactory.getLog(Utility.class);
	// ��������(HttpConnection)
	public static final Boolean PROXY = false;
	public static final String PROXY_HOSTNAME = "proxy.cmcc";
	public static final Integer PROXY_PORT = 8080;

	// ��Ϣ������
	// public static final String MSGS_URL = "http://123.57.163.126:8081/msgs";
	// public static final String MSGS_URL = "http://10.171.86.107:8081/msgs";
	public static final String MSGS_URL = Init.getProperty("MSGS_URL");
	public static final String MSGS_KEY = Init.getProperty("MSGS_KEY");

	/** ý���ļ�Զ�̷����ַ, ��ȡ˽����Ƶ,��Ƶ,PDF�ļ���Զ�̵�ַ */
	public static final String MEDIA_URL = Init.getProperty("MEDIA_URL");
	public static final String MEDIA_KEY = Init.getProperty("MEDIA_KEY");

	/** ��Դ������ */
	public static final String RESOURCE_URL_UPLOAD = "http://123.57.163.126:8080/refs";

	public static final String DATE_FROMAT_Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";
	// ���by Gaoqs
	public static final String DATE_FROMAT_Y_M_D = "yyyy-MM-dd";

	public final static SimpleDateFormat fmt1 = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
	public final static SimpleDateFormat fmt2 = new SimpleDateFormat("HH:mm");
	public final static SimpleDateFormat fmt3 = new SimpleDateFormat("MM��dd�� HH:mm");
	public final static SimpleDateFormat fmt4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public final static SimpleDateFormat fmt5 = new SimpleDateFormat("yyyy-MM-dd");
	public final static SimpleDateFormat fmt6 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public final static SimpleDateFormat fmt7 = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
	public final static SimpleDateFormat fmt8 = new SimpleDateFormat("yyyy��MM��");
	public final static SimpleDateFormat fmt9 = new SimpleDateFormat("yyyy��MM��dd��");

	// ΢�Ź��ں�
	public static final String appid = "wxaa1b0953262f808e";
	public static final String secret = "ecb7ee4c8cb55940fed84fb50c93c065";
	public static final String key = "Sinotsing20150525haoxuehaozhiEcc";
	public static final String mchID = "1240527102";
	public static final String ip = "123.56.110.135";

	// ע����Ϣ����
	public static final String MQ_ADDR = "101.200.80.193:9876";
	public static final String MQ_REGISTER_GROUP_QUEUE = "GROUPTEST";
	public static final String MQ_REGISTER_QUEUE = "TEST";
	public static final Integer MQ_REGISTER_THREAD = 32;

	public static final String REDIS_ADDRESS = Init.getProperty("REDIS_ADDRESS");
	public static final String REDIS_PASS = Init.getProperty("REDIS_PASSWORD");

	public static final Integer pageSize = Integer.valueOf(Init.getProperty("PAGE_SIZE"));

	// ��֤��γ��
	public static boolean verifyLatitudeLongitude(String latitude,
			String longitude,
			String utilitylatitude,
			String utilitylongitude) {
		double latitudebg = new BigDecimal(latitude).doubleValue();
		double longitudebg = new BigDecimal(longitude).doubleValue();
		BigDecimal utilitylatitudebg = new BigDecimal(utilitylatitude);
		BigDecimal utilitylongitudebg = new BigDecimal(utilitylongitude);

		BigDecimal delta = new BigDecimal(0.015);

		double maxutilitylatitude = utilitylatitudebg.add(delta).multiply(new BigDecimal(1000000)).doubleValue();
		double minutilitylatitude = utilitylatitudebg.subtract(delta).multiply(new BigDecimal(1000000)).doubleValue();
		double maxutilitylongitude = utilitylongitudebg.add(delta).multiply(new BigDecimal(1000000)).doubleValue();
		double minutilitylongitude = utilitylongitudebg.subtract(delta).multiply(new BigDecimal(1000000)).doubleValue();

		if (longitudebg < maxutilitylongitude && longitudebg > minutilitylongitude) {
			if (latitudebg < maxutilitylatitude && latitudebg > minutilitylatitude) {
				return true;
			}
		}
		return false;
	}

	/**
	 * ��ȡ��һ�˵���
	 * 
	 * @return
	 */
	public static String createSingleOrderNumber() {
		StringBuffer s = new StringBuffer();
		String format = new SimpleDateFormat("HHmmssSSS").format(new Date());
		Random rd = new Random();
		int a = rd.nextInt(9) + 1;
		s.append(a);
		s.append(format);
		return s.toString();
	}

	public static String createJson(List<Map<String, Object>> jsonList) {

		if (jsonList == null)
			return null;

		JSONArray json = new JSONArray();

		int i = 0;
		for (; i < jsonList.size(); i++)
			json.add(i, jsonList.get(i));
		String ret = json.toString();
		json.clear();
		json = null;
		return ret;
	}

	public static String createJsonByListObj(List<Object> jsonList) {

		if (jsonList == null)
			return null;

		JSONArray json = new JSONArray();

		int i = 0;
		for (; i < jsonList.size(); i++)
			json.add(i, jsonList.get(i));
		String ret = json.toString();
		json.clear();
		json = null;
		return ret;
	}

	public static String createJsonStr(Map<String, Object> jsonMap) {
		if (jsonMap == null) {
			return null;
		}
		JSONObject json = new JSONObject();
		json.putAll(jsonMap);
		String ret = json.toString();
		json.clear();
		json = null;
		return ret;
	}

	public static <T> String createJsonStrByList(List<T> objList) {
		if (objList == null)
			return null;

		JSONArray json = new JSONArray();
		for (T t : objList) {
			json.add(JSONObject.fromObject(t));
		}
		String ret = json.toString();
		json.clear();
		json = null;
		return ret;
	}

	public static <T> String createJsonStrByList(List<T> objList,
			String dateFormat) {
		if (objList == null)
			return null;

		JSONArray json = new JSONArray();
		for (T t : objList) {
			json.add(buildJson(t, dateFormat));
		}
		String ret = json.toString();
		json.clear();
		json = null;
		return ret;
	}

	/**
	 * @��������createJsonStr
	 * @����������json�ַ���
	 * @param jsonList
	 * @return
	 * @�����String
	 * @���ߣ�lixf
	 *
	 */
	public static String createJsonStr(List<String> jsonList) {

		if (jsonList == null)
			return null;

		JSONArray json = new JSONArray();

		int i = 0;
		for (; i < jsonList.size(); i++)
			json.add(i, jsonList.get(i));
		String ret = json.toString();
		json.clear();
		json = null;
		return ret;
	}

	/**
	 * 
	 * @��������parseJsonObj
	 * @��������json��ת����json����
	 * @param jsonStr
	 *            json��
	 * @�����JSONObject
	 * @���ߣ�lixf
	 *
	 */
	public static JSONObject parseJsonObj(String jsonStr) {
		if (jsonStr == null) {
			return null;
		}
		JSONObject json = new JSONObject();
		json = JSONObject.fromObject(jsonStr);
		return json;
	}

	/**
	 * 
	 * @��������parseJsonToObject
	 * @��������json��ת����ʵ�����
	 * @param jsonString
	 *            json�ַ���
	 * @param clzz
	 *            ���calss
	 * @return
	 * @�����Object
	 * @���ߣ�lixf
	 *
	 */
	public static Object parseJsonToObject(String jsonString,
			Class<?> clzz) {
		JsonConfig jsonConfig = new JsonConfig(); // JsonConfig��net.sf.json.JsonConfig�е������Ϊ�̶�д��
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		JSONObject json = JSONObject.fromObject(jsonString, jsonConfig);
		return JSONObject.toBean(json, clzz);
	}

	/**
	 * 
	 * @��������getEntityJson
	 * @��������ȡʵ��json��
	 * @param t
	 * @return
	 * @�����String
	 * @���ߣ�lixf
	 *
	 */
	public static String getEntityJson(Object t) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			Field[] fields = t.getClass().getDeclaredFields();

			for (Field field : fields) {
				String name = field.getName();

				if (field.getType() == Integer.class) {
					map.put(name, (Integer) field.get(t));
				}
				if (field.getType() == Long.class) {
					map.put(name, (Long) field.get(t));
				}
				if (field.getType() == Double.class) {
					map.put(name, (Double) field.get((t)));
				}
				if (field.getType() == Short.class) {
					map.put(name, (Short) field.get(t));
				}
				if (field.getType() == BigDecimal.class) {
					map.put(name, (BigDecimal) field.get(t));
				}
				if (field.getType() == String.class) {
					map.put(name, (String) field.get(t));
				}
				if (field.getType() == Date.class) {
					map.put(name, (Date) field.get(t));
				}
			}

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return Utility.createJsonStr(map);

	}

	/**
	 * 
	 * @��������isNumber
	 * @�������ж��Ƿ�Ϊ������
	 * @param str
	 *            �����ַ���
	 * @return
	 * @�����boolean
	 * @���ߣ�lixf
	 *
	 */
	public static boolean isNumber(String str) {
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("[0-9]*");
		java.util.regex.Matcher match = pattern.matcher(str);
		if (match.matches() == false) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 * @��������data2JsonResut
	 * @����������ת��json����
	 * @param obj
	 *            ��Ҫת���Ķ���
	 * @return json�ַ���
	 * @���ߣ�cjl
	 *
	 */
	public static String data2JsonResut(Boolean flag,
			Object obj) {
		JsonConfig jsonConfig = new JsonConfig(); // JsonConfig��net.sf.json.JsonConfig�е������Ϊ�̶�д��
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		JSONObject json = JSONObject.fromObject(obj, jsonConfig);
		// JSONObject json = new JSONObject();
		json.put("flag", flag);
		json.put("info", obj);
		return json.toString();
	}

	/**
	 * 
	 * @����������json����
	 * @param json
	 *            key json value
	 * @return JSONObject
	 * @���ߣ�cjl
	 *
	 */
	public static JSONObject buildJson(String key,
			Object obj) {
		JsonConfig jsonConfig = new JsonConfig(); // JsonConfig��net.sf.json.JsonConfig�е������Ϊ�̶�д��
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		JSONObject json = JSONObject.fromObject(obj, jsonConfig);
		JSONObject ret = new JSONObject();
		ret.put(key, json.toString());

		return ret;
	}

	/**
	 * @����������json����
	 * @param json
	 *            key json value
	 * @return JSONObject
	 * @���ߣ�cjl
	 *
	 */
	public static JSONObject buildJson(Object obj) {
		JsonConfig jsonConfig = new JsonConfig(); // JsonConfig��net.sf.json.JsonConfig�е������Ϊ�̶�д��
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		JSONObject json = JSONObject.fromObject(obj, jsonConfig);
		return json;
	}

	/**
	 * 
	 * @����������json���� ��ʽ��ʱ��
	 * @param json
	 *            key json value
	 * @return JSONObject
	 * @���ߣ�cjl
	 */
	public static JSONObject buildJson(Object obj,
			String dateFormat) {
		JsonConfig jsonConfig = new JsonConfig(); // JsonConfig��net.sf.json.JsonConfig�е������Ϊ�̶�д��
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor(dateFormat));
		JSONObject json = JSONObject.fromObject(obj, jsonConfig);
		return json;
	}

	/**
	 * ��ȡ��
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static String convertStreamToString(InputStream is) throws IOException {

		if (is != null) {

			StringBuilder sb = new StringBuilder();

			String line;

			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

				while ((line = reader.readLine()) != null) {

					sb.append(line).append("\n");
				}
			} catch (Exception e) {

			} finally {

				is.close();
			}
			return sb.toString();
		}

		return "";
	}

	/**
	 * 
	 * @��������createDate
	 * @������ �����ӳ�ʱ��
	 * @param date
	 *            ��ʼ����ʱ��
	 * @param addType
	 *            �������� - �� �� �� ʱ �� ��
	 * @param count
	 *            ��������
	 * @�����Date
	 * @���ߣ�lixf
	 *
	 */
	public static Date createDate(Date date,
			Integer addType,
			Integer count) {
		Calendar cdCalendar = new GregorianCalendar();
		cdCalendar.setTime(date);
		cdCalendar.add(addType, count);
		return cdCalendar.getTime();
	}

	static StringBuilder time = new StringBuilder();

	public static String secondToHours(int sec) {
		if (sec < 60) {
			return "00:00:"+addZero(sec);
		}else if (sec>=60 && sec<3600) {
			int lastSecond = sec % 60;
			int min;
			if (lastSecond!=0) {
				min = (sec-lastSecond)/60;
				
			}else{
				min = sec/60;
			}
			return "00:"+addZero(min)+":"+addZero(lastSecond);
		}else{
			int lastSecond = sec % 3600;
			int hour;
			int min;
			if (lastSecond!=0) {
				hour = (sec-lastSecond)/3600;
				int limitSecond = lastSecond % 60;
				if (limitSecond!=0) {
					min = (lastSecond-limitSecond)/60;					
				}else{
					min = lastSecond/60;
				}
				return addZero(hour)+":"+addZero(min)+":"+addZero(limitSecond);
				
			}else{
				hour = sec/3600;
				min=0;
			}
			return addZero(hour)+":"+addZero(min)+":"+addZero(lastSecond);
			
		}
	}

	/**
	 *
	 * @��������createPage
	 * @������������ҳ��Ϣ
	 * @param page
	 * @param rows
	 * @return
	 * @�����Integer
	 * @���ߣ�lixf
	 *
	 */
	public static Integer createPage(Integer page,
			Integer rows) {

		if (page == null) {
			page = 1;
		}

		if (rows == null) {
			rows = 15;
		}

		return (page - 1) * rows;
	}

	/**
	 * 
	 * @����������json����
	 * @param json
	 *            key json value
	 * @return JSONObject
	 * @���ߣ�cjl
	 *
	 */
	public static JSONObject buildJsonNotFormarDate(Object obj) {
		JSONObject json = JSONObject.fromObject(obj);
		return json;
	}

	/**
	 * 
	 * @�������� getRandomString
	 * @������ ��ȡ�������
	 * @param @param length �����������λ��
	 * @param @return
	 * @throws
	 * @�����String
	 * @���ߣ�Gaoqs
	 *
	 */
	public static String getRandomString(int length) {
		String base = "0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 
	 * @�������� getNextYearDateForInactive
	 * @������ ��ȡ��һ��ĵ���ʱ��
	 * @param @return
	 * @throws
	 * @�����Date
	 * @���ߣ�Gaoqs
	 *
	 */
	public static Date getNextYearDateForInactive() {
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.YEAR, curr.get(Calendar.YEAR) + 1);
		Date date = curr.getTime();
		return date;
	}

	/**
	 * 
	 * @��������getAccountNo
	 * @��������ȡ�˻�Ψһ����
	 * @return
	 * @throws Exception
	 * @�����String
	 * @���ߣ�lixf
	 *
	 */
	public static String getAccountNo() throws Exception {
		return getRandomString(3) + createTimeStamp();
	}

	/**
	 * 
	 * @��������getBullPositionCode
	 * @��������ȡ���Ψһ���
	 * @param provinceCode
	 *            ʡ��
	 * @throws Exception
	 * @�����String
	 * @���ߣ�lixf
	 *
	 */
	public static String getBullPositionCode(String provinceCode) throws Exception {
		return provinceCode + 2 + createTimeStamp();
	}

	/**
	 * 
	 * @��������getDistributorCode
	 * @��������ȡ������Ψһ���
	 * @param provinceCode
	 *            ʡ��
	 * @return
	 * @throws Exception
	 * @�����String
	 * @���ߣ�lixf
	 *
	 */
	public static String getDistributorCode(String provinceCode) throws Exception {
		return provinceCode + 0 + createTimeStamp();
	}

	/**
	 * 
	 * @��������getMerchantCode
	 * @��������ȡ�̻�Ψһ���
	 * @param provinceCode
	 *            ʡ��
	 * @throws Exception
	 * @�����String
	 * @���ߣ�lixf
	 *
	 */
	public static String getMerchantCode(String provinceCode) throws Exception {
		return provinceCode + 1 + createTimeStamp();
	}

	/**
	 * 
	 * @��������createTimeStamp
	 * @��������ȡʱ���
	 * @return
	 * @�����String ʱ��� ��ʽ:yyyyMMddHHmmss
	 * @���ߣ�lixf
	 *
	 */
	public static String createTimeStamp() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	/**
	 * Create object by class name
	 * 
	 * @param name
	 * @return
	 */
	@SuppressWarnings({ "finally", "rawtypes" })
	public static Object createInstance(String name) {
		Object object = null;
		try {
			Class clazz = Class.forName(name);
			object = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return object;
		}
	}

	/**
	 * ƴ��rest�ķ���JSON
	 * 
	 * @param flag
	 *            �ɹ�200,ʧ��500
	 * @param msg
	 *            ����
	 * @return JSON�ַ���
	 */
	public static String respJsonRest(boolean flag,
			String msg) {
		JSONObject json = new JSONObject();
		if (flag) {
			json.put("code", 200);
		} else {
			json.put("code", 500);
		}
		json.put("info", msg);
		if (logger.isDebugEnabled())
			logger.info(json.toString());
		return json.toString();
	}

	/**
	 * ����JSON����
	 * 
	 * @param flag
	 *            �ɹ�true,ʧ��false
	 * @param obj
	 *            ����
	 * @param dateFormat
	 *            ���ڸ�ʽ,nullĬ�ϸ�ʽ
	 * @return JSON�ַ���
	 */
	public static <T> String respJson(boolean flag,
			T obj,
			String dateFormat) {
		String jsonObj = JsonUtil.toJson(obj, dateFormat);
		JSONObject json = new JSONObject();
		json.put("flag", flag);
		json.put("info", jsonObj);
		if (logger.isDebugEnabled())
			logger.info(json.toString());
		return json.toString();
	}

	/**
	 * ����JSON����
	 * 
	 * @param flag
	 *            �ɹ�true,ʧ��false
	 * @param msg
	 *            String
	 * @return JSON�ַ���
	 */
	public static String respJson(boolean flag,
			String msg) {
		JSONObject json = new JSONObject();
		json.put("flag", flag);
		json.put("info", msg);
		if (logger.isDebugEnabled())
			logger.info(json.toString());
		return json.toString();
	}

	public static String toJson(String status,
			String msg) {
		JSONObject json = new JSONObject();
		json.put("status", status);
		json.put("info", msg);
		if (logger.isDebugEnabled())
			logger.info(json.toString());
		return json.toString();
	}

	/**
	 * ����JSON���ݣ����ʻ���
	 * 
	 * @param flag
	 *            �ɹ�true,ʧ��false
	 * @param msg
	 *            String
	 * @param request
	 * @return JSON�ַ���
	 */
	public static String respJsonI18N(boolean flag,
			String msg,
			HttpServletRequest request) {
		String msgStr = getInternatioNalization(request, msg);
		JSONObject json = new JSONObject();
		json.put("flag", flag);
		json.put("info", msgStr);
		if (logger.isDebugEnabled())
			logger.info(json.toString());
		return json.toString();
	}

	/**
	 * @��������getInternatioNalization
	 * @��������ȡ���ʻ������е�ֵ
	 * @param request
	 *            HttpServletRequest����
	 * @param key
	 *            ���ʻ������ļ��е�key
	 * @return ���ʻ�ֵ
	 * @���ߣ�lixf
	 */
	public static String getInternatioNalization(HttpServletRequest request,
			String key) {
		RequestContext requestContext = new RequestContext(request);
		String message = "";
		try {
			// String country = requestContext.getLocale().getCountry();
			message = requestContext.getMessage(key);
			message = new String(message.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return message;
	}

	/**
	 * ���� HttpServletRequest �� HttpServletResponse �������
	 * 
	 * @param request
	 * @param response
	 * @param characterEncoding
	 *            default UTF-8
	 * @param contentType
	 *            default text/html; charset=UTF-8
	 */
	public static void setCharacterEncoding(HttpServletRequest request,
			HttpServletResponse response,
			String characterEncoding,
			String contentType) {
		try {
			if (characterEncoding == null || characterEncoding.isEmpty()) {
				request.setCharacterEncoding("UTF-8");
			} else {
				request.setCharacterEncoding(characterEncoding);
			}

			if (contentType == null || contentType.isEmpty()) {
				response.setContentType("text/html; charset=UTF-8");
			} else {
				response.setContentType(contentType);
			}
		} catch (UnsupportedEncodingException e) {
		}
	}
	
	/**
	 * ��֤�ֻ��źϷ���
	 * @param matcherStr
	 * @return
	 */
	public static  boolean isMobileNumber(String matcherStr) {
		Pattern r = Pattern.compile("/^1\\d{10}$/");
	      // ���ڴ��� matcher ����
	    Matcher m = r.matcher(matcherStr);
	    if(m.find()){
	    	return true;
	    }
		return false;
	}
	/**
	 * ���ڸ�ʽ�ǣ�0000-00-00  ���� 00-00-00
	 * @param matcherStr
	 * @return
	 */
	public static  boolean isDate(String matcherStr) {
		Pattern r = Pattern.compile("/^(\\d{4}|\\d{2})-((0?([1-9]))|(1[0-2]))-((0?[1-9])|([12]([0-9]))|(3[0|1]))$/");
		// ���ڴ��� matcher ����
		Matcher m = r.matcher(matcherStr);
		if(m.find()){
			return true;
		}
		return false;
	}
	public static  boolean isQQ(String matcherStr) {
		Pattern r = Pattern.compile("/^[1-9]\\d{4,}$/");
		// ���ڴ��� matcher ����
		Matcher m = r.matcher(matcherStr);
		if(m.find()){
			return true;
		}
		return false;
	}

	/**
	 * ����Ĭ�ϵ�ҳ���ÿҳ����
	 * 
	 * @param pageNum
	 * @param pageSize
	 */
	public static Integer setDefaultVaule(Integer num,
			int defaultV) {
		if (num == null || (int) num == 0) {
			num = defaultV == 0 ? num :defaultV;
		}
		return num;
	}

	public static void setCharacterEncoding(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=UTF-8");
	}
 
	/**Wap����Viaͷ��Ϣ�����е�������Ϣ*/
    private static String mobileGateWayHeaders[]=new String[]{
    "ZXWAP",//�����ṩ��wap���ص�via��Ϣ�����磺Via=ZXWAP GateWayZTE Technologies��
    "chinamobile.com",//�й��ƶ���ŵ����wap���أ����磺Via=WTP/1.1 GDSZ-PB-GW003-WAP07.gd.chinamobile.com (Nokia WAP Gateway 4.1 CD1/ECD13_D/4.1.04)
    "monternet.com",//�ƶ����������أ����磺Via=WTP/1.1 BJBJ-PS-WAP1-GW08.bj1.monternet.com. (Nokia WAP Gateway 4.1 CD1/ECD13_E/4.1.05)
    "infoX",//��Ϊ�ṩ��wap���أ����磺Via=HTTP/1.1 GDGZ-PS-GW011-WAP2 (infoX-WISG Huawei Technologies)����Via=infoX WAP Gateway V300R001 Huawei Technologies
    "XMS 724Solutions HTG",//���������Ӫ�̵�wap���أ���֪������һ��
    "Bytemobile",//ò����һ�����ƶ��������ṩ������������������Ч�ʵģ����磺Via=1.1 Bytemobile OSN WebProxy/5.1
    };
    
    /**�����ϵ�IE��Firefox������ȵ�User-Agent�ؼ���*/
    private static String[] pcHeaders=new String[]{
    "Windows 98",
    "Windows ME",
    "Windows 2000",
    "Windows XP",
    "Windows NT",
    "Ubuntu"
    };
    
    /**�ֻ��������User-Agent��Ĺؼ���*/
    private static String[] mobileUserAgents=new String[]{
    "Nokia",//ŵ���ǣ���ɽկ��Ҳд����ģ��ܻ������ֻ���Mozilla/5.0 (Nokia5800 XpressMusic)UC AppleWebkit(like Gecko) Safari/530
    "SAMSUNG",//�����ֻ� SAMSUNG-GT-B7722/1.0+SHP/VPP/R5+Dolfin/1.5+Nextreaming+SMM-MMS/1.2.0+profile/MIDP-2.1+configuration/CLDC-1.1
    "MIDP-2",//j2me2.0��Mozilla/5.0 (SymbianOS/9.3; U; Series60/3.2 NokiaE75-1 /110.48.125 Profile/MIDP-2.1 Configuration/CLDC-1.1 ) AppleWebKit/413 (KHTML like Gecko) Safari/413
    "CLDC1.1",//M600/MIDP2.0/CLDC1.1/Screen-240X320
    "SymbianOS",//����ϵͳ�ģ�
    "MAUI",//MTKɽկ��Ĭ��ua
    "UNTRUSTED/1.0",//����ɽկ����ua����������ȷ�������ֻ�
    "Windows CE",//Windows CE��Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 7.11)
    "iPhone",//iPhone�Ƿ�Ҳתwap���������������ֳ�����˵��Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_1 like Mac OS X; zh-cn) AppleWebKit/532.9 (KHTML like Gecko) Mobile/8B117
    "iPad",//iPad��ua��Mozilla/5.0 (iPad; U; CPU OS 3_2 like Mac OS X; zh-cn) AppleWebKit/531.21.10 (KHTML like Gecko) Version/4.0.4 Mobile/7B367 Safari/531.21.10
    "Android",//Android�Ƿ�Ҳתwap��Mozilla/5.0 (Linux; U; Android 2.1-update1; zh-cn; XT800 Build/TITA_M2_16.22.7) AppleWebKit/530.17 (KHTML like Gecko) Version/4.0 Mobile Safari/530.17
    "BlackBerry",//BlackBerry8310/2.7.0.106-4.5.0.182
    "UCWEB",//ucweb�Ƿ�ֻ��wapҳ�棿 Nokia5800 XpressMusic/UCWEB7.5.0.66/50/999
    "ucweb",//Сд��ucwebò����uc�Ĵ��������Mozilla/6.0 (compatible; MSIE 6.0;) Opera ucweb-squid
    "BREW",//����ֵ�ua�����磺REW-Applet/0x20068888 (BREW/3.1.5.20; DeviceId: 40105; Lang: zhcn) ucweb-squid
    "J2ME",//����ֵ�ua��ֻ��J2ME�ĸ���ĸ
    "YULONG",//�����ֻ���YULONG-CoolpadN68/10.14 IPANEL/2.0 CTC/1.0
    "YuLong",//��������
    "COOLPAD",//��������YL-COOLPADS100/08.10.S100 POLARIS/2.9 CTC/1.0
    "TIANYU",//�����ֻ�TIANYU-KTOUCH/V209/MIDP2.0/CLDC1.1/Screen-240X320
    "TY-",//���TY-F6229/701116_6215_V0230 JUPITOR/2.2 CTC/1.0
    "K-Touch",//��������K-Touch_N2200_CMCC/TBG110022_1223_V0801 MTK/6223 Release/30.07.2008 Browser/WAP2.0
    "Haier",//�����ֻ���Haier-HG-M217_CMCC/3.0 Release/12.1.2007 Browser/WAP2.0
    "DOPOD",//���մ��ֻ�
    "Lenovo",// �����ֻ���Lenovo-P650WG/S100 LMP/LML Release/2010.02.22 Profile/MIDP2.0 Configuration/CLDC1.1
    "LENOVO",// �����ֻ������磺LENOVO-P780/176A
    "HUAQIN",//�����ֻ�
    "AIGO-",//�����߾�ȻҲ�����ֻ���AIGO-800C/2.04 TMSS-BROWSER/1.0.0 CTC/1.0
    "CTC/1.0",//���岻��
    "CTC/2.0",//���岻��
    "CMCC",//�ƶ������ֻ���K-Touch_N2200_CMCC/TBG110022_1223_V0801 MTK/6223 Release/30.07.2008 Browser/WAP2.0
    "DAXIAN",//�����ֻ�DAXIAN X180 UP.Browser/6.2.3.2(GUI) MMP/2.0
    "MOT-",//Ħ��������MOT-MOTOROKRE6/1.0 LinuxOS/2.4.20 Release/8.4.2006 Browser/Opera8.00 Profile/MIDP2.0 Configuration/CLDC1.1 Software/R533_G_11.10.54R
    "SonyEricsson",// �����ֻ���SonyEricssonP990i/R100 Mozilla/4.0 (compatible; MSIE 6.0; Symbian OS; 405) Opera 8.65 [zh-CN]
    "GIONEE",//�����ֻ�
    "HTC",//HTC�ֻ�
    "ZTE",//�����ֻ���ZTE-A211/P109A2V1.0.0/WAP2.0 Profile
    "HUAWEI",//��Ϊ�ֻ���
    "webOS",//palm�ֻ���Mozilla/5.0 (webOS/1.4.5; U; zh-CN) AppleWebKit/532.2 (KHTML like Gecko) Version/1.0 Safari/532.2 Pre/1.0
    "GoBrowser",//3g GoBrowser.User-Agent=Nokia5230/GoBrowser/2.0.290 Safari
    "IEMobile",//Windows CE�ֻ��Դ��������
    "WAP2.0"//֧��wap 2.0��
    };
    
    /**
    * ���ݵ�ǰ������������жϸ������Ƿ������ֻ��նˣ���Ҫ��������ͷ��Ϣ���Լ�user-Agent���header
    * @param request http����
    * @return ��������ֻ����������򷵻ض�Ӧ�������ַ���
    */
    public static boolean isMobileDevice(HttpServletRequest request){
        boolean b = false;
        boolean pcFlag = false;
        boolean mobileFlag = false;
        String via = request.getHeader("Via");
        String userAgent = request.getHeader("user-agent");
        if(via != null && !via.trim().equals("")){
        	for (int i = 0; i < mobileGateWayHeaders.length; i++) {
        		if(via.contains(mobileGateWayHeaders[i])){
        			mobileFlag = true;
        			break;
        		}
        	}
        }
        if(userAgent != null && !userAgent.trim().equals("")){
        	for (int i = 0; !mobileFlag && i < mobileUserAgents.length; i++) {
        		if(userAgent.contains(mobileUserAgents[i])){
        			mobileFlag = true;
        			break;
        		}
        	}
        	
        	for (int i = 0; i < pcHeaders.length; i++) {
        		if(userAgent.contains(pcHeaders[i])){
        			pcFlag = true;
        			break;
        		}
        	}
        }
        if(mobileFlag == true && pcFlag == false){
            b=true;
        }
        return b;//false pc  true shouji
    
    }
    
    public static String addZero(int data){
    	if (data<10) {
			return "0"+data+"";
		}else{
			return data+"";
		}
    }
    
}

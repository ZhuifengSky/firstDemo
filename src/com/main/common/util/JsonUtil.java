package com.main.common.util;

import java.lang.reflect.Type;
import java.util.List;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * JSON转换工具�?
 * @author maodl
 */
public class JsonUtil {
	private static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * Object或List标准JSON解析(解析出标准JSON不用于HTML展示)
	 * @param obj Object或�?List
	 * @param dateFormat 日期格式null默认格式
	 * @return String 例如:{"name":null,"age":22,"date":"2010-05-05 12:40:40"}
	 */
	private static String toJsonBase(Object obj, String dateFormat){
		if(null==dateFormat||"".equals(dateFormat)){
			dateFormat = DATE_FORMAT;
		}
		Gson gson = new GsonBuilder().serializeNulls().disableHtmlEscaping()
				.setDateFormat(dateFormat).create();
		return gson.toJson(obj);
	}
	
	/**
	 * Object或List标准JSON解析(不序列化�?
	 * @param obj Object或�?List
	 * @param dateFormat 日期格式null默认格式
	 * @return String 例如:{"name":null,"age":22,"date":"2010-05-05 12:40:40"}
	 */
	public static String toJsonNotSerializeNulls(Object obj, String dateFormat){
		if(null==dateFormat||"".equals(dateFormat)){
			dateFormat = DATE_FORMAT;
		}
		Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat(dateFormat).create();
		return gson.toJson(obj);
	}
	
	/**
	 * Object解析JSON(用于HTML数据,序列化空null字段为空字符�?
	 * @param obj Object
	 * @param dateFormat 日期格式null默认格式
	 * @return String 例如:{"name":"","age":22,"date":"2010-05-05 12:40:40"}
	 */
	public static String toJson(Object obj, String dateFormat){
		String str = toJsonBase(obj, dateFormat);
		str = str.replaceAll(":null", ":\"\"");
		return str;
	}
	
	/**
	 * List解析JSON(用于HTML数据,加入rows和total标签)
	 * @param obj List
	 * @param total 总记录数
	 * @param dateFormat 日期格式null默认格式
	 * @return String 例如:{"name":null,"age":22,"date":"2010-05-05 12:40:40"}
	 */
	public static String toJsonList(List<?> list, Integer total, String dateFormat){
		String str = toJson(list, dateFormat);
		if(null==total){
			return "{\"rows\":" + str + ",\"total\":\"\"}";
		}
		str = "{\"rows\":" + str + ",\"total\":" + total + "}";
		return str;
	}
	
	/**
	 * JSON对象字符串转换OBJ(没有"[]"是对�?
	 * @param jsonStr  JSON字符�?
	 * @param clzz 目标类的class
	 * @param dateFormat 日期格式null默认格式
	 * @return Object
	 */
	public static Object fromObj(String jsonStr, Class<?> clzz, String dateFormat){
		if(null==dateFormat||"".equals(dateFormat)){
			dateFormat = DATE_FORMAT;
		}
		jsonStr = jsonStr.replaceAll(":\"\"", ":null");
		Gson gson = new GsonBuilder().serializeNulls().disableHtmlEscaping()
				.setDateFormat(dateFormat).create();
		return gson.fromJson(jsonStr, clzz);
	}
	
	/**
	 * JSON数组字符串转换List(�?[]"的数�?
	 * @param jsonStr  JSON字符�?
	 * @param type | new TypeToken<List<Admin>>(){}.getType()
	 * @param dateFormat 日期格式null默认格式
	 * @return List
	 */
	public static List<?> fromList(String jsonStr,Type type, String dateFormat){
		if(null==dateFormat||"".equals(dateFormat)){
			dateFormat = DATE_FORMAT;
		}
		jsonStr = jsonStr.replaceAll(":\"\"", ":null");
		Gson gson = new GsonBuilder().serializeNulls().disableHtmlEscaping()
				.setDateFormat(dateFormat).create();
		return (List<?>) gson.fromJson(jsonStr, type);
	}
	
	/**
	 * JSON对象字符串转换OBJ(没有"[]"是对�?
	 * @param jsonStr  JSON字符�?
	 * @param clzz 目标类的class
	 * @param dateFormat 日期格式null默认格式
	 * @return Object
	 */
	@Deprecated
	public static Object parseObj(String jsonStr, Class<?> clzz, String dateFormat){
		if(null==dateFormat||"".equals(dateFormat)){
			dateFormat = DATE_FORMAT;
		}
		jsonStr = jsonStr.replaceAll(":\"\"", ":null");
		jsonStr = jsonStr.replaceAll("\r", "\\\\r").replaceAll("\n", "\\\\n");
		
		String[] dateFormats = new String[] {dateFormat};
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
		JSONObject json = JSONObject.fromObject(jsonStr);
		return JSONObject.toBean(json, clzz);
	}
	
	/**
	 * JSON数组字符串转换List(�?[]"的数�?
	 * @param jsonStr  JSON字符�?
	 * @param clzz 目标类的class
	 * @param dateFormat 日期格式null默认格式
	 * @return List
	 */
	@Deprecated
	public static List<?> parseList(String jsonStr, Class<?> clzz, String dateFormat){
		if(null==dateFormat||"".equals(dateFormat)){
			dateFormat = DATE_FORMAT;
		}
		jsonStr = jsonStr.replaceAll(":\"\"", ":null");
		jsonStr = jsonStr.replaceAll("\r", "\\\\r").replaceAll("\n", "\\\\n");
		
		String[] dateFormats = new String[] {dateFormat};
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
		JSONArray jsonArr = JSONArray.fromObject(jsonStr);
		return (List<?>) JSONArray.toCollection(jsonArr, clzz);
	}
	
	/**
	 * JSON对象字符串转换JSONObject(没有"[]"是对�?
	 * @param jsonStr  JSON字符�?
	 * @return JSONObject  例如: json.get("name");或json.getString("name");
	 */
	public static JSONObject parseJSONObject(String jsonStr){
		jsonStr = jsonStr.replaceAll("\r", "\\\\r").replaceAll("\n", "\\\\n");
		JsonConfig jsonConfig = new JsonConfig();   
		JSONObject json = JSONObject.fromObject(jsonStr, jsonConfig);
		return json;
	}
	
	/**
	 * JSON数组字符串转换JSONArray(�?[]"的数�?
	 * @param jsonStr JSON字符�?
	 * @return JSONArray 例如: ((JSONObject) jsonArr.get(1)).get("name");
	 */
	public static JSONArray parseJSONArray(String jsonStr){
		jsonStr = jsonStr.replaceAll("\r", "\\\\r").replaceAll("\n", "\\\\n");
		JsonConfig jsonConfig = new JsonConfig();   
		JSONArray jsonArr = JSONArray.fromObject(jsonStr, jsonConfig);
		return jsonArr;
	}
	

	public static String toJsonFormat(String code ,Object obj){
		JSONObject josn = new JSONObject();
		josn.put("code", code);
		josn.put("info", obj);
		return josn.toString();
	}
	
}

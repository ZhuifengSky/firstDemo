package com.main.common.util;

import net.sf.json.JSONObject;

/**
 * @author fanxd
 *
 */
public class PrintUtil {

	public static String printJson(String code, Object info) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("info", info);
		return json.toString();
	}
	
	public static String printJson(String code, String total,Object info) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("total", total);
		json.put("info", info);
		return json.toString();
	}
	
	public static String printJson(String code, String total,String pageNum,String pages,Object info) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("total", total);
		json.put("pageNum", pageNum);
		json.put("pages", pages);
		json.put("info", info);
		return json.toString();
	}
}

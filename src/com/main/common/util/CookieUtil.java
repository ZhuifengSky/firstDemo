package com.main.common.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

	/**
	 * 清除cookie
	 * 
	 * @param response
	 * @param site
	 * @param ticket
	 * @param userId
	 */
	public static void clearCookie(HttpServletResponse response, String site, String ticket, String userId) {
		Cookie cookie = new Cookie("ticket", ticket);
		cookie.setDomain(site);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		Cookie cookie2 = new Cookie("userId", userId);
		cookie2.setDomain(site);
		cookie2.setPath("/");
		cookie2.setMaxAge(0);
		response.addCookie(cookie2);
	}

	/**
	 * 设置cookie
	 * 
	 * @param response
	 * @param site
	 * @param ticket
	 * @param userId
	 */
	public static void setCookie(HttpServletResponse response, String site, String ticket, String userId) {
		Cookie cookie = new Cookie("ticket", ticket);
		cookie.setDomain(site);
		cookie.setPath("/");
//		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		Cookie cookie2 = new Cookie("userId", userId);
		cookie2.setDomain(site);
		cookie2.setPath("/");
//		cookie2.setHttpOnly(true);
		response.addCookie(cookie2);
	}

	/**
	 * 从request请求获取cookie�?	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, String> getCookie(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			Map<String, String> map = new HashMap<String, String>();
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equalsIgnoreCase("ticket")) {
					map.put("ticket", cookie.getValue());
				} else if (cookie.getName().equalsIgnoreCase("userId")) {
					map.put("userId", cookie.getValue());
				}
			}
			return map;
		}else{
			return null;
		}
		
	}

	public static String getCookie(HttpServletRequest request, String key) {
		String value = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equalsIgnoreCase(key)) {
					value = cookie.getValue();
				}
			}
		}
		return value;
	}

}

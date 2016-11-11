/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.main.common.util;

import java.util.Map;

import com.google.common.collect.Maps;


/**
 * ȫ��������
 * @author ThinkGem
 * @version 2014-06-25
 */
public class Global {

	/**
	 * ��ǰ����ʵ��
	 */
	private static Global global = new Global();
	
	/**
	 * ����ȫ������ֵ
	 */
	private static Map<String, String> map = Maps.newHashMap();
	
	/**
	 * �����ļ����ض���
	 */
	private static PropertiesLoader propertiesLoader = new PropertiesLoader("config.properties");
	
	/**
	 * ��ȡ��ǰ����ʵ��
	 */
	public static Global getInstance() {
		return global;
	}
	
	/**
	 * ��ȡ����
	 * @see ${fns:getConfig('adminPath')}
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null){
			value = propertiesLoader.getProperty(key);
			map.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}
	
	/////////////////////////////////////////////////////////
	
	/**
	 * ��ȡ����˸�·��
	 */
	public static String getAdminPath() {
		return getConfig("adminPath");
	}
	
	/**
	 * ��ȡǰ�˸�·��
	 */
	public static String getFrontPath() {
		return getConfig("frontPath");
	}
	
	/**
	 * ��ȡURL��׺
	 */
	public static String getUrlSuffix() {
		return getConfig("urlSuffix");
	}
	
	/**
	 * �Ƿ�����ʾģʽ����ʾģʽ�²����޸��û�����ɫ�����롢�˵�����Ȩ
	 */
	public static Boolean isDemoMode() {
		String dm = getConfig("demoMode");
		return "true".equals(dm) || "1".equals(dm);
	}
	
	/**
	 * ���޸�ϵͳ�û��ͽ�ɫʱ�Ƿ�ͬ����Activiti
	 */
	public static Boolean isSynActivitiIndetity() {
		String dm = getConfig("activiti.isSynActivitiIndetity");
		return "true".equals(dm) || "1".equals(dm);
	}
	
	/////////////////////////////////////////////////////////
	
	// ��ʾ/����
	public static final String SHOW = "1";
	public static final String HIDE = "0";

	// ��/��
	public static final String YES = "1";
	public static final String NO = "0";
	
	// ��/��
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	
	public static final String USERFILES_BASE_URL = "/userfiles/";

	/**
	 * ҳ���ȡ����
	 * @see ${fns:getConst('YES')}
	 */
	public static Object getConst(String field) {
		try {
			return Global.class.getField(field).get(null);
		} catch (Exception e) {
			// �쳣���������ã�����ʲôҲ����
		}
		return null;
	}

	/**
	 * ��ȡ�ϴ��ļ��ĸ�Ŀ¼
	 * @return
	 *//*
	public static String getUserfilesBaseDir() {
		String dir = getConfig("userfiles.basedir");
		if (StringUtils.isBlank(dir)){
			try {
				dir = ServletContextFactory.getServletContext().getRealPath("/");
			} catch (Exception e) {
				return "";
			}
		}
		if(!dir.endsWith("/")) {
			dir += "/";
		}
//		System.out.println("userfiles.basedir: " + dir);
		return dir;
	}*/
	
}

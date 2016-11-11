package com.main.common.util;
/**
 * 
 * Title:   GeneralStrUtil.java
 * Description:生成工具  
 * Company:   www.edu24ol.com
 * @author   pc-zw
 * @date     2016�?1�?日上�?:21:41
 * @version  1.0
 */
public class GeneralStrUtil {
	
	public static String base = "abcdefghijklmnopqrstuvwxyz0123456789";
	private static final String[] email_suffix="@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn".split(",");  
	/** 
     * 返回手机号码 
     */  
    private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");  
    public static String getTel() {  
        int index=getNum(0,telFirst.length-1);  
        String first=telFirst[index];  
        String second=String.valueOf(getNum(1,888)+10000).substring(1);  
        String thrid=String.valueOf(getNum(1,9100)+10000).substring(1);  
        return first+second+thrid;  
    }  
    
    public static int getNum(int start,int end) {  
        return (int)(Math.random()*(end-start+1)+start);  
    }
    
    /** 
     * 返回Email 
     * @param lMin �?��长度 
     * @param lMax �?��长度 
     * @return 
     */  
    public static String getEmail(int lMin,int lMax) { 
        int length=getNum(lMin,lMax);  
        StringBuffer sb = new StringBuffer();       
        for (int i = 0; i < length; i++) {       
            int number = (int)(Math.random()*base.length());  
            sb.append(base.charAt(number));       
        }  
        sb.append(email_suffix[(int)(Math.random()*email_suffix.length)]);  
        return sb.toString();     
    } 
    
    public static void main(String[] args) {
		System.out.println(getTel());
	}
}

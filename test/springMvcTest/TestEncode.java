package springMvcTest;

import com.main.common.util.MD5Util;

public class TestEncode {

	public static void main(String[] args) {
		
		String s  =MD5Util.GetMD5Code("all"+"2cab9f785ff44cc");
		System.out.println(s);
	}
}

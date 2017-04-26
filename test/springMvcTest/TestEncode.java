package springMvcTest;

import java.util.ArrayList;
import java.util.List;

import com.main.common.util.MD5Util;

public class TestEncode {

	public static void main(String[] args) {
		
		/*String s  =MD5Util.GetMD5Code("all"+"2cab9f785ff44cc");
		System.out.println(s);*/
		 List<Integer> ids = new ArrayList<Integer>();
		    ids.add(23);
		    ids.add(45);
		    ids.add(67);
		    List<Integer> ids34 = null;
		    ids.addAll(ids34);
		    for (Integer integer : ids) {
				System.out.println(integer);
			}
	}
}

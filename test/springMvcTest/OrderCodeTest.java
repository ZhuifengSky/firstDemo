package springMvcTest;

import com.main.common.util.OrderCodeGeneUtil;

public class OrderCodeTest {

	public static void main(String[] args) {
		String s = OrderCodeGeneUtil.getCourseOrderSn();
		System.out.println(s);
	}
}

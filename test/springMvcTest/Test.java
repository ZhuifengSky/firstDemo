package springMvcTest;

import java.math.BigDecimal;


public class Test {

	
	
	
	public static void main(String[] args) {
		BigDecimal rate =new BigDecimal(0.003);
		BigDecimal price = new BigDecimal(663);
		
		System.out.println("�������"+rate.setScale(4,BigDecimal.ROUND_HALF_UP));
		System.out.println("������"+price.multiply(rate.setScale(4,BigDecimal.ROUND_HALF_UP)).setScale(2,BigDecimal.ROUND_HALF_UP));
		//netbank.getAmount().multiply(rate.getFeeRate()).setScale(4,BigDecimal.ROUND_HALF_UP));
	   
	}
}

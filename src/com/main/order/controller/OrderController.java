package com.main.order.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.main.common.util.DateUtil;
import com.main.common.util.OrderCodeGeneUtil;
import com.main.order.bean.Order;

/**
 * 订单控制类
 * @author pc
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	/**
	 * 用户下单页面
	 * @param request
	 * @param response
	 * @param amount
	 * @param goodsId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value ="/buyOrder.do")
	public ModelAndView geneOrder(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true, value = "amount") String amount,
			@RequestParam(required = true, value = "goodsId") String goodsId,
			@RequestParam(required = true, value = "userId") String userId){
	    String orderCode = OrderCodeGeneUtil.getCourseOrderSn();
	    String userName ="测试人员";
	    String goodsName = "商品一";
	    Order order = new Order(orderCode, amount, goodsId, goodsName, userId, userName);
	    String nowTime = DateUtil.format(new Date(), DateUtil.BOTH);
	    order.setTradeTime(nowTime);
	    ModelAndView model = new ModelAndView("/jsp/order/orderConfirm");
	    model.addObject("order", order);
		return model;		
	}
}

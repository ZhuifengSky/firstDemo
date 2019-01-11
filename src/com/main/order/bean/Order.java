package com.main.order.bean;

import java.math.BigDecimal;

/**
 * ∂©µ•∂‘œÛ
 * @author pc
 *
 */
public class Order {

	private String orderCode;
	private String amount;
	private String goodsId;
	private String goodsName;
	private String userId;
	private String userName;
	private String tradeTime;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	public Order(String orderCode, String amount, String goodsId,
			String goodsName, String userId, String userName) {
		super();
		this.orderCode = orderCode;
		this.amount = amount;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.userId = userId;
		this.userName = userName;
	}


	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}
	
	
}

package com.reagan.wxpt.pojo.business;

// Generated 2014-3-14 10:25:00 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;


/**
 * BusinessOrderDetail generated by hbm2java
 */

public class BusinessOrderDetail implements java.io.Serializable {

	private int ordid;
	private BusinessCompany businessCompany;
	private BusinessOrder businessOrder;
	private BusinessShop businessShop;
	private BusinessGoods businessGoods;
	private BigDecimal goodsPrice;
	private BigDecimal disPrice;
	private int discount;
	private int goodsQuantity;

	public BusinessOrderDetail() {
	}

	public BusinessOrderDetail(BusinessCompany businessCompany,
			BusinessOrder businessOrder, BusinessShop businessShop,
			BusinessGoods businessGoods, BigDecimal goodsPrice,
			BigDecimal disPrice, int discount, int goodsQuantity) {
		this.businessCompany = businessCompany;
		this.businessOrder = businessOrder;
		this.businessShop = businessShop;
		this.businessGoods = businessGoods;
		this.goodsPrice = goodsPrice;
		this.disPrice = disPrice;
		this.discount = discount;
		this.goodsQuantity = goodsQuantity;
	}


	public int getOrdid() {
		return this.ordid;
	}

	public void setOrdid(int ordid) {
		this.ordid = ordid;
	}


	public BusinessCompany getBusinessCompany() {
		return this.businessCompany;
	}

	public void setBusinessCompany(BusinessCompany businessCompany) {
		this.businessCompany = businessCompany;
	}


	public BusinessOrder getBusinessOrder() {
		return this.businessOrder;
	}

	public void setBusinessOrder(BusinessOrder businessOrder) {
		this.businessOrder = businessOrder;
	}


	public BusinessShop getBusinessShop() {
		return this.businessShop;
	}

	public void setBusinessShop(BusinessShop businessShop) {
		this.businessShop = businessShop;
	}


	public BusinessGoods getBusinessGoods() {
		return this.businessGoods;
	}

	public void setBusinessGoods(BusinessGoods businessGoods) {
		this.businessGoods = businessGoods;
	}


	public BigDecimal getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}


	public BigDecimal getDisPrice() {
		return this.disPrice;
	}

	public void setDisPrice(BigDecimal disPrice) {
		this.disPrice = disPrice;
	}


	public int getDiscount() {
		return this.discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}


	public int getGoodsQuantity() {
		return this.goodsQuantity;
	}

	public void setGoodsQuantity(int goodsQuantity) {
		this.goodsQuantity = goodsQuantity;
	}

}
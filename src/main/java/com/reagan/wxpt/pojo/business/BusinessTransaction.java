package com.reagan.wxpt.pojo.business;

// Generated 2014-3-14 10:25:00 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;



/**
 * BusinessTransaction generated by hbm2java
 */

public class BusinessTransaction implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5935866805686815972L;
	private Integer traid;
	private int tranNumber;
	private String ordeNumber;
	private String payNumber;
	private Date startDate;
	private Date endDate;
	private BigDecimal goodsAmount;
	private BigDecimal discountAmount;
	private BigDecimal payAmount;
	private BigDecimal transportAmount;
	private int status;
	private int payMode;
	private String paychannel;
	private Date payDate;
	
	public Integer getTraid() {
		return this.traid;
	}

	public void setTraid(Integer traid) {
		this.traid = traid;
	}


	public int getTranNumber() {
		return this.tranNumber;
	}

	public void setTranNumber(int tranNumber) {
		this.tranNumber = tranNumber;
	}


	public String getOrdeNumber() {
		return this.ordeNumber;
	}

	public void setOrdeNumber(String ordeNumber) {
		this.ordeNumber = ordeNumber;
	}


	public String getPayNumber() {
		return this.payNumber;
	}

	public void setPayNumber(String payNumber) {
		this.payNumber = payNumber;
	}


	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public BigDecimal getGoodsAmount() {
		return this.goodsAmount;
	}

	public void setGoodsAmount(BigDecimal goodsAmount) {
		this.goodsAmount = goodsAmount;
	}


	public BigDecimal getDiscountAmount() {
		return this.discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}


	public BigDecimal getPayAmount() {
		return this.payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}


	public BigDecimal getTransportAmount() {
		return this.transportAmount;
	}

	public void setTransportAmount(BigDecimal transportAmount) {
		this.transportAmount = transportAmount;
	}


	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	public int getPayMode() {
		return this.payMode;
	}

	public void setPayMode(int payMode) {
		this.payMode = payMode;
	}


	public String getPaychannel() {
		return this.paychannel;
	}

	public void setPaychannel(String paychannel) {
		this.paychannel = paychannel;
	}


	public Date getPayDate() {
		return this.payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

}

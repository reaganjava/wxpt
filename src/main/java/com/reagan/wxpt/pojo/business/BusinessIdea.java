package com.reagan.wxpt.pojo.business;

import java.io.Serializable;
import java.util.Date;

public class BusinessIdea implements Serializable {

	private static final long serialVersionUID = -2987419949377416381L;

	private Integer deaId;
	
	private Integer goodsId;
	
	private Integer shopId;
	
	private Integer adminId;
	
	private String username;
	
	private Date date;
	
	private Integer status;

	public Integer getDeaId() {
		return deaId;
	}

	public void setDeaId(Integer deaId) {
		this.deaId = deaId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}

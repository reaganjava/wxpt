package com.reagan.wxpt.pojo.business;

import java.io.Serializable;
import java.util.Date;

public class BusinessQuestion implements Serializable {

	private static final long serialVersionUID = -2987419949377416381L;

	private Integer quid;
	
	private Integer goodsId;
	
	private Integer shopId;
	
	private Integer uid;
	
	private String nickname;
	
	private String content;
	
	private Date date;
	
	private Integer status;

	public Integer getQuid() {
		return quid;
	}

	public void setQuid(Integer quid) {
		this.quid = quid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

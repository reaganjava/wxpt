package com.reagan.wxpt.pojo.business;

import java.io.Serializable;
import java.util.Date;

public class BusinessAnswer implements Serializable {

	private static final long serialVersionUID = -86510878602314879L;
	
	private Integer anid;
	
	private Integer ideaId;
	
	private Integer adminId;
	
	private String username;
	
	private Date date;
	
	private Integer isGood;
	
	private String content;

	public Integer getAnid() {
		return anid;
	}

	public void setAnid(Integer anid) {
		this.anid = anid;
	}

	public Integer getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(Integer ideaId) {
		this.ideaId = ideaId;
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

	public Integer getIsGood() {
		return isGood;
	}

	public void setIsGood(Integer isGood) {
		this.isGood = isGood;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}

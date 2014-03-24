package com.reagan.wxpt.pojo.common;

import java.io.Serializable;
import java.util.Date;

import com.reagan.core.annotation.Mapper;

@Mapper(tableName="COMMON_ADMIN_ACTION")
public class CommonAdminAction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3321290251965129809L;
	
	@Mapper(column="AAID", insert=false)
	private Long aaid;
	
	@Mapper(column="ADMINID")
	private Integer adminId;
	
	@Mapper(column="CONTENT")
	private String content;
	
	@Mapper(column="DATE")
	private Date date;
	
	@Mapper(column="USERNAME")
	private String username;
	
	@Mapper(column="TYPE")
	private Integer type;

	public Long getAaid() {
		return aaid;
	}

	public void setAaid(Long aaid) {
		this.aaid = aaid;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}

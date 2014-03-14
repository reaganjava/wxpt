package com.reagan.wxpt.pojo.common;

// Generated 2014-3-14 10:25:00 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import com.reagan.wxpt.pojo.business.BusinessCompany;


/**
 * CommonAdmin generated by hbm2java
 */

public class CommonAdmin implements java.io.Serializable {
	
	private Integer admid;
	private BusinessCompany businessCompany;
	private int companyId;
	private int groupId;
	private String username;
	private String password;
	private String realname;
	private Date createdate;
	private String createname;
	private int status;

	public CommonAdmin() {
	}

	public CommonAdmin(BusinessCompany businessCompany, int groupId,
			String username, String password, String realname, Date createdate,
			String createname) {
		this.businessCompany = businessCompany;
		this.groupId = groupId;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.createdate = createdate;
		this.createname = createname;
	}


	public Integer getAdmid() {
		return this.admid;
	}

	public void setAdmid(Integer admid) {
		this.admid = admid;
	}


	public BusinessCompany getBusinessCompany() {
		return this.businessCompany;
	}

	public void setBusinessCompany(BusinessCompany businessCompany) {
		this.businessCompany = businessCompany;
	}


	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}


	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}


	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	
	public String getCreatename() {
		return this.createname;
	}

	public void setCreatename(String createname) {
		this.createname = createname;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

}
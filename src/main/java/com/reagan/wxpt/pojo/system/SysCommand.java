package com.reagan.wxpt.pojo.system;

// Generated 2014-3-14 10:25:00 by Hibernate Tools 3.4.0.CR1

import java.util.Date;



/**
 * SysCommand generated by hbm2java
 */

public class SysCommand implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9122925774269533006L;
	private Integer comid;
	private int companyId;
	private String keyvalue;
	private String eventUrl;
	private int eventType;
	private String createName;
	private Date createDate;
	
	public Integer getComid() {
		return this.comid;
	}

	public void setComid(Integer comid) {
		this.comid = comid;
	}


	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}


	public String getKeyvalue() {
		return this.keyvalue;
	}

	public void setKeyvalue(String keyvalue) {
		this.keyvalue = keyvalue;
	}


	public String getEventUrl() {
		return this.eventUrl;
	}

	public void setEventUrl(String eventUrl) {
		this.eventUrl = eventUrl;
	}


	public int getEventType() {
		return this.eventType;
	}

	public void setEventType(int eventType) {
		this.eventType = eventType;
	}


	public String getCreateName() {
		return this.createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}


	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}

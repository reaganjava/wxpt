package com.reagan.wxpt.pojo.business;

// Generated 2014-3-14 10:25:00 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import com.reagan.core.annotation.Mapper;


/**
 * BusinessCompany generated by hbm2java
 */
@Mapper(tableName="BUSINESS_COMPANY")
public class BusinessCompany implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5107593585161440601L;
	@Mapper(column="COID", insert=false, updateWhere=true)
	private Integer coid;
	
	@Mapper(column="CATEGORY_ID", update=true)
	private Integer categoryId;
	
	@Mapper(column="NAME", update=true, like=true)
	private String name;

	/**
	 * 结算方式
	 */
	@Mapper(column="SETTLE_TYPE", update=true)
	private Integer settleType;
	
	@Mapper(column="ADDRESS", update=true)
	private String address;
	
	/**
	 * 服务类型
	 */
	@Mapper(column="SERVICE_TYPE", update=true)
	private Integer serviceType;
	
	@Mapper(column="SCALE", update=true)
	private Integer scale;
	
	@Mapper(column="SALES_NAME", update=true, like=true)
	private String salesName;
	
	@Mapper(column="CREATE_DATE")
	private Date createDate;
	
	@Mapper(column="CREATE_NAME")
	private String createName;
	
	@Mapper(column="CONTACT", update=true)
	private String contact;
	
	@Mapper(column="TEL", update=true)
	private String tel;
	
	@Mapper(column="FAX", update=true)
	private String fax;
	
	@Mapper(column="STATUS", update=true)
	private Integer status;
	
	public Integer getCoid() {
		return this.coid;
	}

	public void setCoid(Integer coid) {
		this.coid = coid;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Integer getSettleType() {
		return this.settleType;
	}

	public void setSettleType(Integer settleType) {
		this.settleType = settleType;
	}

	
	public Integer getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	
	public Integer getScale() {
		return this.scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

	
	public String getSalesName() {
		return this.salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

}

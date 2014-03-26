package com.reagan.wxpt.pojo.common;

import java.io.Serializable;
import java.util.Date;

import com.reagan.core.annotation.Mapper;

@Mapper(tableName="COMMON_GROUP")
public class CommonGroup implements Serializable {

	private static final long serialVersionUID = -6271886408075717279L;

	@Mapper(column="GROUPID", insert=false, updateWhere=true)
	private Integer groupId;
	
	@Mapper(column="COMPANY_ID", update=true)
	private Integer companyId;
	
	@Mapper(column="NAME", update=true)
	private String name;
	
	@Mapper(column="CREATENAME")
	private String createName;
	
	@Mapper(column="CREATEDATE")
	private Date createDate;

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}

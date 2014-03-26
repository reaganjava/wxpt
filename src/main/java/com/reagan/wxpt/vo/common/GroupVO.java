package com.reagan.wxpt.vo.common;

import java.util.ArrayList;
import java.util.List;

import com.reagan.wxpt.pojo.business.BusinessCompany;
import com.reagan.wxpt.pojo.common.CommonGroup;
import com.reagan.wxpt.pojo.common.CommonAdmin;
import com.reagan.wxpt.vo.BaseVO;

public class GroupVO extends BaseVO {

	private CommonGroup group;
	
	private List<CommonGroup> groupList;
	
	private BusinessCompany company;
	
	private List<CommonAdmin> adminList;
	
	public GroupVO() {
		this.group = new CommonGroup();
		this.company = new BusinessCompany();
		this.adminList = new ArrayList<CommonAdmin>();
	}

	public CommonGroup getGroup() {
		return group;
	}

	public void setGroup(CommonGroup group) {
		this.group = group;
	}

	public BusinessCompany getCompany() {
		return company;
	}

	public void setCompany(BusinessCompany company) {
		this.company = company;
	}
	
	public List<CommonGroup> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<CommonGroup> groupList) {
		this.groupList = groupList;
	}

	public List<CommonAdmin> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<CommonAdmin> adminList) {
		this.adminList = adminList;
	}
	
}

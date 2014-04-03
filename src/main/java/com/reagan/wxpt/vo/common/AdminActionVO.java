package com.reagan.wxpt.vo.common;

import java.util.List;

import com.reagan.wxpt.pojo.common.CommonAdminAction;
import com.reagan.wxpt.vo.BaseVO;

public class AdminActionVO extends BaseVO {

	private CommonAdminAction adminAction;
	
	private List<CommonAdminAction> adminActionList;

	public CommonAdminAction getAdminAction() {
		return adminAction;
	}

	public void setAdminAction(CommonAdminAction adminAction) {
		this.adminAction = adminAction;
	}

	public List<CommonAdminAction> getAdminActionList() {
		return adminActionList;
	}

	public void setAdminActionList(List<CommonAdminAction> adminActionList) {
		this.adminActionList = adminActionList;
	}
	
}

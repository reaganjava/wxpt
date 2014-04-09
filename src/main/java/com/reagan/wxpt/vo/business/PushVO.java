package com.reagan.wxpt.vo.business;

import java.util.List;

import com.reagan.wxpt.pojo.business.BusinessPush;
import com.reagan.wxpt.vo.BaseVO;

public class PushVO extends BaseVO {

	private BusinessPush push;
	
	private List<BusinessPush> pushList;

	public BusinessPush getPush() {
		return push;
	}

	public void setPush(BusinessPush push) {
		this.push = push;
	}

	public List<BusinessPush> getPushList() {
		return pushList;
	}

	public void setPushList(List<BusinessPush> pushList) {
		this.pushList = pushList;
	}
	
} 

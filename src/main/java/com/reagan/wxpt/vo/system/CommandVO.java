package com.reagan.wxpt.vo.system;

import com.reagan.wxpt.pojo.business.BusinessCompany;
import com.reagan.wxpt.pojo.system.SysCommand;
import com.reagan.wxpt.vo.BaseVO;

public class CommandVO extends BaseVO {

	private SysCommand command;
	
	private BusinessCompany compnay;

	public SysCommand getCommand() {
		return command;
	}

	public void setCommand(SysCommand command) {
		this.command = command;
	}

	public BusinessCompany getCompnay() {
		return compnay;
	}

	public void setCompnay(BusinessCompany compnay) {
		this.compnay = compnay;
	}
	
}

package com.reagan.wxpt.vo.system;

import java.util.List;

import com.reagan.wxpt.pojo.system.SysConfig;
import com.reagan.wxpt.vo.BaseVO;

public class ConfigVO extends BaseVO {

	private SysConfig config;
	
	private List<SysConfig> configList;

	public SysConfig getConfig() {
		return config;
	}

	public void setConfig(SysConfig config) {
		this.config = config;
	}

	public List<SysConfig> getConfigList() {
		return configList;
	}

	public void setConfigList(List<SysConfig> configList) {
		this.configList = configList;
	}
	
}

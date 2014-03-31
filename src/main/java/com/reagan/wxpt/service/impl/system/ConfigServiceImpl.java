package com.reagan.wxpt.service.impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.reagan.wxpt.dao.system.IConfigDao;
import com.reagan.wxpt.pojo.system.SysConfig;
import com.reagan.wxpt.service.system.IConfigService;
import com.reagan.wxpt.vo.system.ConfigVO;

public class ConfigServiceImpl implements IConfigService {

	@Autowired
	private IConfigDao configDao;
	
	public void addConfig(ConfigVO configVO) throws Exception {
		configDao.save(configVO.getConfig());
	}
	
	public boolean removeConfig(ConfigVO configVO) {
		int rows = configDao.delete(configVO.getConfig());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public boolean modifiConfig(ConfigVO configVO) {
		int rows = configDao.update(configVO.getConfig());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public ConfigVO viewConfigDetail(ConfigVO configVO) {
		List<SysConfig> configList = configDao.queryForList(configVO.getConfig());
		configVO.setConfigList(configList);
		return configVO;
	}
}

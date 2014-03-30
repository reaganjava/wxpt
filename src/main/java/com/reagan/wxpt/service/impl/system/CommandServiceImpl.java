package com.reagan.wxpt.service.impl.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reagan.wxpt.dao.system.ICommandDao;
import com.reagan.wxpt.pojo.system.SysCommand;
import com.reagan.wxpt.service.system.ICommandService;
import com.reagan.wxpt.vo.system.CommandVO;

@Service("commandService")
public class CommandServiceImpl implements ICommandService {

	@Autowired
	private ICommandDao commandDao;
	
	public void addCommand(CommandVO commandVO) throws Exception {
		commandDao.save(commandVO.getCommand());
	}
	
	public boolean removeCommand(CommandVO commandVO) {
		int rows = commandDao.delete(commandVO.getCommand());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public boolean modifiCommand(CommandVO commandVO) {
		int rows = commandDao.update(commandVO.getCommand());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public CommandVO viewCommandDetail(CommandVO commandVO) {
		SysCommand command = commandDao.query(commandVO.getCommand());
	}
	
}

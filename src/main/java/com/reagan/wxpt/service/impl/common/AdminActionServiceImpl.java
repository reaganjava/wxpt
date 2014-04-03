package com.reagan.wxpt.service.impl.common;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.common.IAdminActionDao;
import com.reagan.wxpt.pojo.common.CommonAdminAction;
import com.reagan.wxpt.service.common.IAdminActionService;
import com.reagan.wxpt.vo.common.AdminActionVO;

public class AdminActionServiceImpl implements IAdminActionService {

	private IAdminActionDao adminActionDao;
	
	public void addAdminAction(AdminActionVO adminActionVO) throws Exception {
		adminActionDao.save(adminActionVO.getAdminAction());
	}
	
	public AdminActionVO viewAdminActionDetail(AdminActionVO adminActionVO) {
		CommonAdminAction adminAction = adminActionDao.query(adminActionVO.getAdminAction());
		adminActionVO.setAdminAction(adminAction);
		return adminActionVO;
	}
	
	public PageBean<CommonAdminAction> queryAdminActionList(AdminActionVO adminActionVO) {
		return adminActionDao.queryForPage(adminActionVO.getAdminAction(), adminActionVO.getPageNO(), adminActionVO.getPageCount());
	}
}

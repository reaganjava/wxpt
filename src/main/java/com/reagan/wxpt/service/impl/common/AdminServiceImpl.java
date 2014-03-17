package com.reagan.wxpt.service.impl.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reagan.util.MD5;
import com.reagan.views.dto.PageBean;
import com.reagan.wxpt.dao.common.IAdminDao;
import com.reagan.wxpt.pojo.common.CommonAdmin;
import com.reagan.wxpt.service.common.IAdminService;

@Service("adminService")
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	private IAdminDao adminDao;

	@Override
	public void addAdmin(CommonAdmin admin) {
		MD5 md5 = new MD5();
		String password = admin.getPassword();
		String md5Pwd = md5.getMD5ofStr(password);
		admin.setPassword(md5Pwd);
		adminDao.saveAdmin(admin);
	}

	@Override
	public CommonAdmin getAdmin(CommonAdmin admin) {
		return adminDao.queryAdmin(admin);
	}

	@Override
	public PageBean<CommonAdmin> queryAdminList(CommonAdmin admin, int pageON,
			int pageCount) {
		return adminDao.queryAdminForList(admin, pageON, pageCount);
	}

}

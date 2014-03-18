package com.reagan.wxpt.service.impl.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reagan.util.MD5;
import com.reagan.views.dto.PageBean;
import com.reagan.wxpt.dao.common.IAdminDao;
import com.reagan.wxpt.pojo.common.CommonAdmin;
import com.reagan.wxpt.service.common.IAdminService;
import com.reagan.wxpt.vo.common.AdminVO;

@Service("adminService")
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	private IAdminDao adminDao;

	@Override
	public void addAdmin(AdminVO adminVO) {
		MD5 md5 = new MD5();
		CommonAdmin admin = adminVO.getAdmin();
		String password = admin.getPassword();
		String md5Pwd = md5.getMD5ofStr(password);
		admin.setPassword(md5Pwd);
		adminDao.saveAdmin(admin);
	}

	@Override
	public CommonAdmin verifiAdmin(AdminVO adminVO) {
		MD5 md5 = new MD5();
		CommonAdmin admin = adminVO.getAdmin();
		String password = admin.getPassword();
		String md5Pwd = md5.getMD5ofStr(password);
		admin.setPassword(md5Pwd);
		
		return adminDao.queryAdmin(adminVO);
	}

	@Override
	public PageBean<CommonAdmin> queryAdminList(AdminVO adminVO) {
		return adminDao.queryAdminForPage(adminVO);
	}

}

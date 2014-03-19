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
		String password = adminVO.getAdmin().getPassword();
		String md5Pwd = md5.getMD5ofStr(password);
		adminVO.getAdmin().setPassword(md5Pwd);
		adminDao.saveAdmin(adminVO.getAdmin());
	}

	@Override
	public AdminVO verifiAdmin(AdminVO adminVO) {
		MD5 md5 = new MD5();
		String password = adminVO.getAdmin().getPassword();
		String md5Pwd = md5.getMD5ofStr(password);
		adminVO.getAdmin().setPassword(md5Pwd);
		adminVO.setAdmin(adminDao.queryAdmin(adminVO));
		return adminVO;
	}
	
	@Override
	public AdminVO viewAdminDetail(AdminVO adminVO) {
		CommonAdmin admin = adminDao.queryAdmin(adminVO);
		adminVO.setAdmin(admin);
		return adminVO;
	}
	
	@Override
	public boolean modifiAdmin(AdminVO adminVO) {
		int rows = adminDao.updateAdmin(adminVO.getAdmin());
		if(rows > 0) {
			return true;
		} 
		return false;
	}

	@Override
	public boolean modifiAdminPwd(AdminVO adminVO) {
		CommonAdmin admin = adminDao.queryAdmin(adminVO);
		if(admin != null) {
			MD5 md5 = new MD5();
			String password = adminVO.getNewPassword();
			String md5Pwd = md5.getMD5ofStr(password);
			adminVO.getAdmin().setPassword(md5Pwd);
			int rows = adminDao.updateAdmin(admin);
			if(rows > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean revmoeAdmin(AdminVO adminVO) {
		int rowNum = adminDao.deleteAdmin(adminVO);
		if(rowNum > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public PageBean<CommonAdmin> queryAdminList(AdminVO adminVO) {
		return adminDao.queryAdminForPage(adminVO);
	}

}

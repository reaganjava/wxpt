package com.reagan.wxpt.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reagan.util.MD5;
import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.business.ICompanyDao;
import com.reagan.wxpt.dao.common.IAdminDao;
import com.reagan.wxpt.dao.common.IAdminMenuDao;
import com.reagan.wxpt.dao.common.IGroupDao;
import com.reagan.wxpt.pojo.business.BusinessCompany;
import com.reagan.wxpt.pojo.common.CommonAdmin;
import com.reagan.wxpt.pojo.common.CommonGroup;
import com.reagan.wxpt.pojo.common.CommonMenuItem;
import com.reagan.wxpt.service.common.IAdminService;
import com.reagan.wxpt.vo.common.AdminVO;

@Service("adminService")
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	private IAdminDao adminDao;
	
	@Autowired
	private IAdminMenuDao adminMenuDao;
	
	@Autowired
	private IGroupDao groupDao;
	
	@Autowired
	private ICompanyDao companyDao;

	@Override
	public void addAdmin(AdminVO adminVO) throws Exception {
		MD5 md5 = new MD5();
		String password = adminVO.getAdmin().getPassword();
		String md5Pwd = md5.getMD5ofStr(password);
		adminVO.getAdmin().setPassword(md5Pwd);
		adminDao.save(adminVO.getAdmin());
	}

	@Override
	public AdminVO verifiAdmin(AdminVO adminVO) {
		MD5 md5 = new MD5();
		String password = adminVO.getAdmin().getPassword();
		//密码加密
		String md5Pwd = md5.getMD5ofStr(password);
		adminVO.getAdmin().setPassword(md5Pwd);
		//获得用户信息
		adminVO.setAdmin(adminDao.query(adminVO.getAdmin()));
		//用户不为空是获取用户的菜单
		if(adminVO.getAdmin() != null) {
			CommonMenuItem commonMenuItem = new CommonMenuItem();
			//根据用户组来查找用户的菜单
			commonMenuItem.setGroupId(adminVO.getAdmin().getGroupId());
			List<CommonMenuItem> menuItemList = adminMenuDao.queryForList(commonMenuItem);
			adminVO.setMenuItemList(menuItemList);
		}
		return adminVO;
	}
	
	@Override
	public AdminVO viewAdminDetail(AdminVO adminVO) {
		CommonAdmin admin = adminDao.query(adminVO.getAdmin());
		adminVO.setAdmin(admin);
		CommonGroup group = new CommonGroup();
		group.setGroupId(admin.getGroupId());
		group = groupDao.query(group, new String[] {"NAME"});
		adminVO.setGroup(group);
		BusinessCompany company = new BusinessCompany();
		company = companyDao.query(company, new String[] {"NAME"});
		adminVO.setCompany(company);
		return adminVO;
	}
	
	@Override
	public boolean modifiAdmin(AdminVO adminVO) {
		int rows = adminDao.update(adminVO.getAdmin());
		if(rows > 0) {
			return true;
		} 
		return false;
	}

	@Override
	public boolean modifiAdminPwd(AdminVO adminVO) {
		CommonAdmin admin = adminDao.query(adminVO.getAdmin());
		if(admin != null) {
			MD5 md5 = new MD5();
			String password = adminVO.getNewPassword();
			String md5Pwd = md5.getMD5ofStr(password);
			adminVO.getAdmin().setPassword(md5Pwd);
			int rows = adminDao.update(admin);
			if(rows > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean revmoeAdmin(AdminVO adminVO) {
		int rowNum = adminDao.delete(adminVO.getAdmin());
		if(rowNum > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public PageBean<CommonAdmin> queryAdminList(AdminVO adminVO) {
		return adminDao.queryForPage(adminVO.getAdmin(), adminVO.getPageNO(), adminVO.getPageCount());
	}

}

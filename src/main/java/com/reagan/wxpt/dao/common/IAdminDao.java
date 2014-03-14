package com.reagan.wxpt.dao.common;

import java.util.List;

import com.reagan.views.dto.PageBean;
import com.reagan.wxpt.pojo.common.CommonAdmin;

public interface IAdminDao {

	public void saveAdmin(CommonAdmin admin);
	
	public int updateForPassword(String password, int admid);
	
	public int deleteAdmin(CommonAdmin admin);
	
	public CommonAdmin findAdmin(CommonAdmin admin);
	
	public List<CommonAdmin> findAdminForList(CommonAdmin admin);
	
	public PageBean<CommonAdmin> findAdminForList(CommonAdmin admin, int pageON, int pageCount);
}

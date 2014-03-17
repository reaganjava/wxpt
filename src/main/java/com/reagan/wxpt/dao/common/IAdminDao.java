package com.reagan.wxpt.dao.common;

import java.util.List;

import com.reagan.views.dto.PageBean;
import com.reagan.wxpt.pojo.common.CommonAdmin;

public interface IAdminDao {

	public void saveAdmin(CommonAdmin admin);
	
	public int updateForPassword(String password, int admid);
	
	public int deleteAdmin(CommonAdmin admin);
	
	public CommonAdmin queryAdmin(CommonAdmin admin);
	
	public List<CommonAdmin> queryAdminForList(CommonAdmin admin);
	
	public PageBean<CommonAdmin> queryAdminForList(CommonAdmin admin, int pageON, int pageCount);
}

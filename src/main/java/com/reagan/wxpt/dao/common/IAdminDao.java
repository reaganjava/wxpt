package com.reagan.wxpt.dao.common;

import java.util.List;

import com.reagan.views.dto.PageBean;
import com.reagan.wxpt.pojo.common.CommonAdmin;
import com.reagan.wxpt.vo.common.AdminVO;

public interface IAdminDao {

	public void saveAdmin(CommonAdmin admin);
		
	public int updateAdmin(CommonAdmin admin);
	
	public int deleteAdmin(AdminVO adminVO);
	
	public CommonAdmin queryAdmin(AdminVO adminVO);
	
	public List<CommonAdmin> queryAdminForList(AdminVO adminVO);
	
	public PageBean<CommonAdmin> queryAdminForPage(AdminVO adminVO);
}

package com.reagan.wxpt.service.common;


import com.reagan.views.dto.PageBean;
import com.reagan.wxpt.pojo.common.CommonAdmin;
import com.reagan.wxpt.vo.common.AdminVO;


public interface IAdminService {

	public void addAdmin(AdminVO adminVO);
	
	public CommonAdmin verifiAdmin(AdminVO adminVO);
	
	public PageBean<CommonAdmin> queryAdminList(AdminVO adminVO);
}

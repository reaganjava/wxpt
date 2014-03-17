package com.reagan.wxpt.service.common;


import com.reagan.views.dto.PageBean;
import com.reagan.wxpt.pojo.common.CommonAdmin;

public interface IAdminService {

	public void addAdmin(CommonAdmin admin);
	
	public CommonAdmin getAdmin(CommonAdmin admin);
	
	public PageBean<CommonAdmin> queryAdminList(CommonAdmin admin, int pageNO, int pageCount);
}

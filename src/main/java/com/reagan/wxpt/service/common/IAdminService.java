package com.reagan.wxpt.service.common;

import com.reagan.util.PageBean;
import com.reagan.wxpt.pojo.common.CommonAdmin;
import com.reagan.wxpt.vo.common.AdminVO;


public interface IAdminService {

	public void addAdmin(AdminVO adminVO) throws Exception;
	
	public AdminVO verifiAdmin(AdminVO adminVO);
	
	public AdminVO viewAdminDetail(AdminVO adminVO);
	
	public boolean modifiAdmin(AdminVO adminVO);
	
	public int modifiAdminPwd(AdminVO adminVO);
	
	public boolean revmoeAdmin(AdminVO adminVO);
	
	public PageBean<CommonAdmin> queryAdminList(AdminVO adminVO);
}

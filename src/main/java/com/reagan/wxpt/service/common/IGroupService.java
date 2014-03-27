package com.reagan.wxpt.service.common;

import com.reagan.util.PageBean;
import com.reagan.wxpt.pojo.common.CommonGroup;
import com.reagan.wxpt.vo.common.GroupVO;

public interface IGroupService {

	public void addGroup(GroupVO groupVO) throws Exception;
	
	public int modifiGroup(GroupVO groupVO);
	
	public int removeGroup(GroupVO groupVO);
	
	public GroupVO viewGroupDetail(GroupVO groupVO);
	
	public GroupVO viewGroupList(GroupVO groupVO);
	
	public PageBean<CommonGroup> queryGroupList(GroupVO groupVO);
}

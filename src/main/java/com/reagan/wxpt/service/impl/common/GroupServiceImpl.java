package com.reagan.wxpt.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.common.IGroupDao;
import com.reagan.wxpt.pojo.common.CommonGroup;
import com.reagan.wxpt.service.common.IGroupService;
import com.reagan.wxpt.vo.common.GroupVO;

@Service("groupService")
public class GroupServiceImpl implements IGroupService {
	
	@Autowired
	private IGroupDao groupDao;

	@Override
	public void addGroup(GroupVO groupVO) throws Exception {
		groupDao.save(groupVO.getGroup());
	}

	@Override
	public boolean modifiGroup(GroupVO groupVO) {
		int rows = groupDao.update(groupVO.getGroup());
		if(rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeGroup(GroupVO groupVO) {
		int rows = groupDao.delete(groupVO.getGroup());
		if(rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public GroupVO viewGroupDetail(GroupVO groupVO) {
		CommonGroup group = groupDao.query(groupVO.getGroup());
		groupVO.setGroup(group);
		return groupVO;
	}

	@Override
	public GroupVO viewGroupList(GroupVO groupVO) {
		List<CommonGroup> groupList = groupDao.queryForList(groupVO.getGroup());
		groupVO.setGroupList(groupList);
		return groupVO;
	}

	@Override
	public PageBean<CommonGroup> queryGroupList(GroupVO groupVO) {
		return groupDao.queryForPage(groupVO.getGroup(), groupVO.getPageNO(), groupVO.getPageRows());
	}

}

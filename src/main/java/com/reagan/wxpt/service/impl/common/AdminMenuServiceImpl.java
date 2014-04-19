package com.reagan.wxpt.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.common.IAdminMenuDao;
import com.reagan.wxpt.dao.join.IGroupMenuItemDao;
import com.reagan.wxpt.pojo.common.CommonMenuItem;
import com.reagan.wxpt.pojo.join.JoinGroupMenuItem;
import com.reagan.wxpt.service.common.IAdminMenuService;
import com.reagan.wxpt.vo.common.MenuItemVO;

@Service("adminMenuService")
public class AdminMenuServiceImpl implements IAdminMenuService {

	@Autowired
	private IAdminMenuDao adminMenuDao;
	
	@Autowired
	private IGroupMenuItemDao groupMenuItemDao;
	
	@Override
	public void addMenuItem(MenuItemVO menuItemVO) throws Exception {
		Number pkValue = adminMenuDao.saveRePk(menuItemVO.getMenuItem());
		for(Integer groupId : menuItemVO.getGroupIds()) {
			JoinGroupMenuItem groupMenuItem = new JoinGroupMenuItem();
			groupMenuItem.setMenuItemId(pkValue.intValue());
			groupMenuItem.setGroupId(groupId);
			groupMenuItemDao.save(groupMenuItem);
		}
		
	}
	
	@Override
	public boolean modifiMenuItem(MenuItemVO menuItemVO) {
		try {
			groupMenuItemDao.delete(menuItemVO.getGroupMenuItem());
			if(menuItemVO.getGroupIds() != null) {
				for(Integer groupId : menuItemVO.getGroupIds()) {
					JoinGroupMenuItem groupMenuItem = new JoinGroupMenuItem();
					groupMenuItem.setMenuItemId(menuItemVO.getMenuItem().getMenuId());
					groupMenuItem.setGroupId(groupId);
					groupMenuItemDao.save(groupMenuItem);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		int rows = adminMenuDao.update(menuItemVO.getMenuItem());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean removeMenuItem(MenuItemVO menuItemVO) {
		menuItemVO.getGroupMenuItem().setMenuItemId(menuItemVO.getMenuItem().getMenuId());
		groupMenuItemDao.delete(menuItemVO.getGroupMenuItem());
		int rows = adminMenuDao.delete(menuItemVO.getMenuItem());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public MenuItemVO viewMenuItemDetail(MenuItemVO menuItemVO) {
		CommonMenuItem menuItem = adminMenuDao.query(menuItemVO.getMenuItem());
		menuItemVO.setMenuItem(menuItem);
		List<JoinGroupMenuItem> groupIdList = groupMenuItemDao.queryForList(menuItemVO.getGroupMenuItem(), new String[]{"GROUP_ID"});
		Integer[] groupIds = new Integer[groupIdList.size()];
		for(int i = 0; i < groupIds.length; i++) {
			groupIds[i] = groupIdList.get(i).getGroupId();
		}
		menuItemVO.setGroupIds(groupIds);
		return menuItemVO;
	}
	
	@Override
	public MenuItemVO viewMenuItemList(MenuItemVO menuItemVO) {
		List<CommonMenuItem> menuItemList = adminMenuDao.queryForList(menuItemVO.getMenuItem());
		menuItemVO.setMenuItemList(menuItemList);
		return menuItemVO;
	}
	
	@Override
	public PageBean<CommonMenuItem> queryMenuItemList(MenuItemVO menuItemVO) {
		return adminMenuDao.queryForPage(menuItemVO.getMenuItem(), menuItemVO.getPageNO(), menuItemVO.getPageRows());
	}
}

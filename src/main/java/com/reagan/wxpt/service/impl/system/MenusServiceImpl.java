package com.reagan.wxpt.service.impl.system;

import java.util.List;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.system.IMenuDao;
import com.reagan.wxpt.pojo.system.SysMenus;
import com.reagan.wxpt.service.system.IMenuGroupService;
import com.reagan.wxpt.vo.system.MenusVO;

public class MenusServiceImpl implements IMenuGroupService {

	private IMenuDao menuDao;
	
	public void addMenu(MenusVO menusVO) throws Exception {
		menuDao.save(menusVO.getMenus());
	}
	
	public boolean modifiMenu(MenusVO menusVO) {
		int rows = menuDao.update(menusVO.getMenus());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public boolean removeMenu(MenusVO menusVO) {
		int rows = menuDao.delete(menusVO.getMenus());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public MenusVO viewMenuDetail(MenusVO menusVO) {
		SysMenus menus = menuDao.query(menusVO.getMenus());
		menusVO.setMenus(menus);
		return menusVO;
	}
	
	public MenusVO viewsMenuList(MenusVO menusVO) {
		List<SysMenus> menusList = menuDao.queryForList(menusVO.getMenus());
		menusVO.setMenusList(menusList);
		return menusVO;
	}
	
	public PageBean<SysMenus> queryMenuList(MenusVO menusVO) {
		return menuDao.queryForPage(menusVO.getMenus(), menusVO.getPageNO(), menusVO.getPageCount());
	}
}

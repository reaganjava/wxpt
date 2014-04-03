package com.reagan.wxpt.vo.system;

import java.util.List;

import com.reagan.wxpt.pojo.system.SysMenus;
import com.reagan.wxpt.vo.BaseVO;

public class MenusVO extends BaseVO {

	private SysMenus menus;
	
	private List<SysMenus> menusList;

	public SysMenus getMenus() {
		return menus;
	}

	public void setMenus(SysMenus menus) {
		this.menus = menus;
	}

	public List<SysMenus> getMenusList() {
		return menusList;
	}

	public void setMenusList(List<SysMenus> menusList) {
		this.menusList = menusList;
	}
	
}

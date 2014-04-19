package com.reagan.wxpt.service.common;

import com.reagan.util.PageBean;
import com.reagan.wxpt.pojo.common.CommonMenuItem;
import com.reagan.wxpt.vo.common.MenuItemVO;

public interface IAdminMenuService {

	void addMenuItem(MenuItemVO menuItemVO) throws Exception;

	boolean modifiMenuItem(MenuItemVO menuItemVO);

	boolean removeMenuItem(MenuItemVO menuItemVO);

	MenuItemVO viewMenuItemDetail(MenuItemVO menuItemVO);

	MenuItemVO viewMenuItemList(MenuItemVO menuItemVO);

	PageBean<CommonMenuItem> queryMenuItemList(MenuItemVO menuItemVO);

}

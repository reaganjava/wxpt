package com.reagan.wxpt.util;

import java.util.HashMap;
import java.util.Map;

public class Constant {

	public static Map<String, String> MENU_ITEM_URLS = new HashMap<String, String>();
	
	static {
		MENU_ITEM_URLS.put("管理员管理", "admin/list/all/all/1/1.html");
		MENU_ITEM_URLS.put("公司管理", "company/list/all/0/0/0/all/1/1.html");
		MENU_ITEM_URLS.put("分组管理", "group/list/all/1.html");
	    MENU_ITEM_URLS.put("菜单管理", "menuItem/list/all/all/1/1.html");
	}
}

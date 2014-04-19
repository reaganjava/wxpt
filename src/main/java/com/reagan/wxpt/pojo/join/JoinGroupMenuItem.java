package com.reagan.wxpt.pojo.join;

import com.reagan.core.annotation.Mapper;

@Mapper(tableName="JOIN_GROUP_MENUITEM")
public class JoinGroupMenuItem {

	@Mapper(column="ID", insert=false, updateWhere=true)
	private Integer id;
	
	@Mapper(column="GROUP_ID", update=true)
	private Integer groupId;
	
	@Mapper(column="MENUITEM_ID", update=true)
	private Integer menuItemId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(Integer menuItemId) {
		this.menuItemId = menuItemId;
	}
	
}

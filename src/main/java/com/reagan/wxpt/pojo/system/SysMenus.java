package com.reagan.wxpt.pojo.system;

// Generated 2014-3-14 10:25:00 by Hibernate Tools 3.4.0.CR1


/**
 * SysMenus generated by hbm2java
 */

public class SysMenus implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1767930225031057027L;
	private Integer menuid;
	private Integer menuGroupId;
	private String name;
	private int type;
	private String event;

	public Integer getMenuid() {
		return this.menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public Integer getMenuGroupId() {
		return menuGroupId;
	}

	public void setMenuGroupId(Integer menuGroupId) {
		this.menuGroupId = menuGroupId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}


	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

}

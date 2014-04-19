package com.reagan.wxpt.pojo.common;

import java.io.Serializable;
import java.util.Date;

import com.reagan.core.annotation.Mapper;

@Mapper(tableName="COMMON_MENU_ITEM")
public class CommonMenuItem implements Serializable {
	
	private static final long serialVersionUID = -3219478887210096832L;

	@Mapper(column="MENUID", insert=false, updateWhere=true)
	private Integer menuId;
	
	@Mapper(column="TITLE", update=true, like=true)
	private String title;
	
	@Mapper(column="URL", update=true, like=true)
	private String url;
	
	@Mapper(column="CREATEDATE")
	private Date createDate;
	
	@Mapper(column="CREATENAME")
	private String createName;
	
	@Mapper(column="ICON", update=true)
	private String icon;
	
	@Mapper(column="STATUS", update=true)
	private Integer status;
	
	@Mapper(column="PRIORITY", update=true)
	private Integer priority;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
}

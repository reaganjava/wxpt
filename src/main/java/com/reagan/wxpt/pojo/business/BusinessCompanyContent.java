package com.reagan.wxpt.pojo.business;

import com.reagan.core.annotation.Mapper;

@Mapper(tableName="BUSINESS_COMPANY_CONTENT")
public class BusinessCompanyContent implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6834307561478111164L;
	@Mapper(column="COID", updateWhere=true)
	private Integer coid;
	
	@Mapper(column="TITLE", update=true)
	private String title;
	
	@Mapper(column="DESCRIPTION", update=true)
	private String description;
	
	@Mapper(column="CONTENT", update=true)
	private String content;
	
	@Mapper(column="URL", update=true)
	private String url;
	
	@Mapper(column="STATUS", update=true)
	private Integer status;
	
	@Mapper(column="IS_HTML", update=true)
	private Integer isHtml;
	
	@Mapper(column="FRONT_COVER_PIC", update=true)
	private String frontConverPic;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCoid() {
		return coid;
	}

	public void setCoid(Integer coid) {
		this.coid = coid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsHtml() {
		return isHtml;
	}

	public void setIsHtml(Integer isHtml) {
		this.isHtml = isHtml;
	}

	public String getFrontConverPic() {
		return frontConverPic;
	}

	public void setFrontConverPic(String frontConverPic) {
		this.frontConverPic = frontConverPic;
	}
	
}

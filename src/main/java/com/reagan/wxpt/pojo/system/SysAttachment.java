package com.reagan.wxpt.pojo.system;

// Generated 2014-3-14 10:25:00 by Hibernate Tools 3.4.0.CR1

import java.util.Date;


/**
 * SysAttachment generated by hbm2java
 */

public class SysAttachment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3913958906744635704L;
	private Integer atid;
	private Integer advertisementId;
	private Integer goodsId;
	private String filename;
	private String path;
	private Date date;
	private int mimetype;
	private String createname;

	public Integer getAtid() {
		return this.atid;
	}

	public void setAtid(Integer atid) {
		this.atid = atid;
	}


	public Integer getAdvertisementId() {
		return this.advertisementId;
	}

	public void setAdvertisementId(Integer advertisementId) {
		this.advertisementId = advertisementId;
	}


	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}


	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}


	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public int getMimetype() {
		return this.mimetype;
	}

	public void setMimetype(int mimetype) {
		this.mimetype = mimetype;
	}


	public String getCreatename() {
		return this.createname;
	}

	public void setCreatename(String createname) {
		this.createname = createname;
	}

}

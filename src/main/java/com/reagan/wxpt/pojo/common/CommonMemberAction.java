package com.reagan.wxpt.pojo.common;

// Generated 2014-3-14 10:25:00 by Hibernate Tools 3.4.0.CR1

import java.util.Date;


/**
 * CommonMemberAction generated by hbm2java
 */

public class CommonMemberAction implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6266744486839199533L;
	private Integer acid;
	private long uid;
	private String content;
	private Date date;
	private String nickname;
	private int type;

	public CommonMemberAction() {
	}

	public CommonMemberAction(long uid, String content, Date date,
			String nickname, int type) {
		this.uid = uid;
		this.content = content;
		this.date = date;
		this.nickname = nickname;
		this.type = type;
	}


	public Integer getAcid() {
		return this.acid;
	}

	public void setAcid(Integer acid) {
		this.acid = acid;
	}


	public long getUid() {
		return this.uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}


	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

}

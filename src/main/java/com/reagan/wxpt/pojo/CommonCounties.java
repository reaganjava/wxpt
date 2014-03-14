package com.reagan.wxpt.pojo;

// Generated 2014-3-14 10:25:00 by Hibernate Tools 3.4.0.CR1



/**
 * CommonCounties generated by hbm2java
 */

public class CommonCounties implements java.io.Serializable {

	private long uid;
	private CommonMembers commonMembers;
	private String tel;
	private String mobile;
	private String zipcode;
	private String address;

	public CommonCounties() {
	}

	public CommonCounties(CommonMembers commonMembers, String tel,
			String mobile, String zipcode, String address) {
		this.commonMembers = commonMembers;
		this.tel = tel;
		this.mobile = mobile;
		this.zipcode = zipcode;
		this.address = address;
	}


	public long getUid() {
		return this.uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}



	public CommonMembers getCommonMembers() {
		return this.commonMembers;
	}

	public void setCommonMembers(CommonMembers commonMembers) {
		this.commonMembers = commonMembers;
	}


	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

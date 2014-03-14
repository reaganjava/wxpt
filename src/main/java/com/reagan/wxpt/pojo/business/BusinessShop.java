package com.reagan.wxpt.pojo.business;

// Generated 2014-3-14 10:25:00 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import com.reagan.wxpt.pojo.system.SysCategory;
import com.reagan.wxpt.pojo.system.SysMenuGroup;
import com.reagan.wxpt.pojo.system.SysRegionCategory;


/**
 * BusinessShop generated by hbm2java
 */

public class BusinessShop implements java.io.Serializable {

	private Integer shid;
	private BusinessCompany businessCompany;
	private SysCategory sysCategory;
	private SysRegionCategory sysRegionCategory;
	private String name;
	private String address;
	private String tel;
	private String mobile;
	private String contact;
	private String province;
	private String city;
	private String district;
	private int pushType;
	private String description;
	private Set<BusinessGoods> businessGoodses = new HashSet<BusinessGoods>(0);
	private Set<BusinessOrderDetail> businessOrderDetails = new HashSet<BusinessOrderDetail>(
			0);
	private Set<SysMenuGroup> sysMenuGroups = new HashSet<SysMenuGroup>(0);

	public BusinessShop() {
	}

	public BusinessShop(BusinessCompany businessCompany,
			SysCategory sysCategory, SysRegionCategory sysRegionCategory,
			String name, String address, String tel, String mobile,
			String contact, String province, String city, String district,
			int pushType, String description) {
		this.businessCompany = businessCompany;
		this.sysCategory = sysCategory;
		this.sysRegionCategory = sysRegionCategory;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.mobile = mobile;
		this.contact = contact;
		this.province = province;
		this.city = city;
		this.district = district;
		this.pushType = pushType;
		this.description = description;
	}

	public BusinessShop(BusinessCompany businessCompany,
			SysCategory sysCategory, SysRegionCategory sysRegionCategory,
			String name, String address, String tel, String mobile,
			String contact, String province, String city, String district,
			int pushType, String description,
			Set<BusinessGoods> businessGoodses,
			Set<BusinessOrderDetail> businessOrderDetails,
			Set<SysMenuGroup> sysMenuGroups) {
		this.businessCompany = businessCompany;
		this.sysCategory = sysCategory;
		this.sysRegionCategory = sysRegionCategory;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.mobile = mobile;
		this.contact = contact;
		this.province = province;
		this.city = city;
		this.district = district;
		this.pushType = pushType;
		this.description = description;
		this.businessGoodses = businessGoodses;
		this.businessOrderDetails = businessOrderDetails;
		this.sysMenuGroups = sysMenuGroups;
	}


	public Integer getShid() {
		return this.shid;
	}

	public void setShid(Integer shid) {
		this.shid = shid;
	}


	public BusinessCompany getBusinessCompany() {
		return this.businessCompany;
	}

	public void setBusinessCompany(BusinessCompany businessCompany) {
		this.businessCompany = businessCompany;
	}


	public SysCategory getSysCategory() {
		return this.sysCategory;
	}

	public void setSysCategory(SysCategory sysCategory) {
		this.sysCategory = sysCategory;
	}


	public SysRegionCategory getSysRegionCategory() {
		return this.sysRegionCategory;
	}

	public void setSysRegionCategory(SysRegionCategory sysRegionCategory) {
		this.sysRegionCategory = sysRegionCategory;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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


	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}


	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}


	public int getPushType() {
		return this.pushType;
	}

	public void setPushType(int pushType) {
		this.pushType = pushType;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Set<BusinessGoods> getBusinessGoodses() {
		return this.businessGoodses;
	}

	public void setBusinessGoodses(Set<BusinessGoods> businessGoodses) {
		this.businessGoodses = businessGoodses;
	}


	public Set<BusinessOrderDetail> getBusinessOrderDetails() {
		return this.businessOrderDetails;
	}

	public void setBusinessOrderDetails(
			Set<BusinessOrderDetail> businessOrderDetails) {
		this.businessOrderDetails = businessOrderDetails;
	}


	public Set<SysMenuGroup> getSysMenuGroups() {
		return this.sysMenuGroups;
	}

	public void setSysMenuGroups(Set<SysMenuGroup> sysMenuGroups) {
		this.sysMenuGroups = sysMenuGroups;
	}

}
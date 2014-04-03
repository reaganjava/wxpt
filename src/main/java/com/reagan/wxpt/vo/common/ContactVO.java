package com.reagan.wxpt.vo.common;

import java.util.ArrayList;
import java.util.List;

import com.reagan.wxpt.pojo.common.CommonContact;
import com.reagan.wxpt.vo.BaseVO;

public class ContactVO extends BaseVO {

	private CommonContact contact;
	
	private List<CommonContact> contactList;
	
	public ContactVO() {
		contact = new CommonContact();
		contactList = new ArrayList<CommonContact>();
	}

	public CommonContact getContact() {
		return contact;
	}

	public void setContact(CommonContact contact) {
		this.contact = contact;
	}

	public List<CommonContact> getContactList() {
		return contactList;
	}

	public void setContactList(List<CommonContact> contactList) {
		this.contactList = contactList;
	}

	
}

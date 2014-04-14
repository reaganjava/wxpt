package com.reagan.wxpt.service.impl.common;

import java.util.List;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.common.IContactDao;
import com.reagan.wxpt.pojo.common.CommonContact;
import com.reagan.wxpt.service.common.ICountiesService;
import com.reagan.wxpt.vo.common.ContactVO;

public class ContactServiceImpl implements ICountiesService {

	public IContactDao contactDao;
	
	public void addContact(ContactVO contactVO) throws Exception {
		contactDao.save(contactVO.getContact());
	}
	
	public boolean modifiContact(ContactVO contactVO) {
		int rows = contactDao.update(contactVO.getContact());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public boolean removeContact(ContactVO contactVO) {
		int rows = contactDao.delete(contactVO.getContact());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public ContactVO viewContactDetail(ContactVO contactVO) {
		CommonContact contact = contactDao.query(contactVO.getContact());
		contactVO.setContact(contact);
		return contactVO;
	}
	
	public ContactVO viewContactList(ContactVO contactVO) {
		List<CommonContact> contactList = contactDao.queryForList(contactVO.getContact());
		contactVO.setContactList(contactList);
		return contactVO;
	}
	
	public PageBean<CommonContact> queryContactList(ContactVO contactVO) {
		return contactDao.queryForPage(contactVO.getContact(), contactVO.getPageNO(), contactVO.getPageRows());
	}
}

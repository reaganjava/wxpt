package com.reagan.wxpt.service.impl.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.system.IAttachmentDao;
import com.reagan.wxpt.pojo.system.SysAttachment;
import com.reagan.wxpt.service.system.IAttachmentService;
import com.reagan.wxpt.vo.system.AttachmentVO;

@Service("attachmentService")
public class AttachmentServiceImpl implements IAttachmentService {

	@Autowired
	private IAttachmentDao attachmentDao;
	
	@Override
	public void addAttachement(AttachmentVO attachmentVO) throws Exception {
		attachmentDao.save(attachmentVO.getAttachment());
	}
	
	@Override
	public boolean removeAttachement(AttachmentVO attachmentVO) {
		int rows = attachmentDao.delete(attachmentVO.getAttachment());
		if(rows > 0) {
			return true;
		} 
		return false;
	} 
	
	@Override
	public PageBean<SysAttachment> queryAttachementList(AttachmentVO attachmentVO) {
		return attachmentDao.queryForPage(attachmentVO.getAttachment(), attachmentVO.getPageNO(), attachmentVO.getPageRows());
	}
}

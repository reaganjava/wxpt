package com.reagan.wxpt.service.system;

import com.reagan.util.PageBean;
import com.reagan.wxpt.pojo.system.SysAttachment;
import com.reagan.wxpt.vo.system.AttachmentVO;

public interface IAttachmentService {

	void addAttachement(AttachmentVO attachmentVO) throws Exception;

	boolean removeAttachement(AttachmentVO attachmentVO);

	PageBean<SysAttachment> queryAttachementList(AttachmentVO attachmentVO);

}

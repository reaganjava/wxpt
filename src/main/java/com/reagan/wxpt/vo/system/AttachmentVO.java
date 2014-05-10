package com.reagan.wxpt.vo.system;

import java.util.ArrayList;
import java.util.List;

import com.reagan.wxpt.pojo.system.SysAttachment;
import com.reagan.wxpt.vo.BaseVO;

public class AttachmentVO extends BaseVO {

	private SysAttachment attachment;
	
	private List<SysAttachment> attachmentList;
	
	public AttachmentVO() {
		attachment = new SysAttachment();
		attachmentList = new ArrayList<SysAttachment>();
	}

	public SysAttachment getAttachment() {
		return attachment;
	}

	public void setAttachment(SysAttachment attachment) {
		this.attachment = attachment;
	}

	public List<SysAttachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<SysAttachment> attachmentList) {
		this.attachmentList = attachmentList;
	}
	
}

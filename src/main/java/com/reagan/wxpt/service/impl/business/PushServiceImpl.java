package com.reagan.wxpt.service.impl.business;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.business.IPushDao;
import com.reagan.wxpt.pojo.business.BusinessPush;
import com.reagan.wxpt.service.business.IPushService;
import com.reagan.wxpt.vo.business.PushVO;

public class PushServiceImpl implements IPushService {

	private IPushDao pushDao;
	
	public void addPush(PushVO pushVO) throws Exception {
		pushDao.save(pushVO.getPush());
	}
	
	public boolean modifiPush(PushVO pushVO) {
		int rows = pushDao.update(pushVO.getPush());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public boolean removePush(PushVO pushVO) {
		int rows = pushDao.delete(pushVO.getPush());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public PushVO viewPushDetail(PushVO pushVO) {
		BusinessPush push = pushDao.query(pushVO.getPush());
		pushVO.setPush(push);
		return pushVO;
	}
	
	public PageBean<BusinessPush> queryPushList(PushVO pushVO) {
		return pushDao.queryForPage(pushVO.getPush(), pushVO.getPageNO(), pushVO.getPageRows());
	}
}

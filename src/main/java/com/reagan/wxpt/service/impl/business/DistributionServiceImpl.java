package com.reagan.wxpt.service.impl.business;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.business.IDistributionDao;
import com.reagan.wxpt.pojo.business.BusinessDistribution;
import com.reagan.wxpt.service.business.IDistributionService;
import com.reagan.wxpt.vo.business.DistributionVO;

public class DistributionServiceImpl implements IDistributionService {

	private IDistributionDao distributionDao;
	
	public void addDistribution(DistributionVO distributionVO) throws Exception {
		distributionDao.save(distributionVO.getDistribution());
	}
	
	public boolean modifiDistribution(DistributionVO distributionVO) {
		int rows = distributionDao.update(distributionVO.getDistribution());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public DistributionVO viewDistributionDetail(DistributionVO distributionVO) {
		BusinessDistribution distribution = distributionDao.query(distributionVO.getDistribution());
		distributionVO.setDistribution(distribution);
		return distributionVO;
	}
	
	public PageBean<BusinessDistribution> queryDistributionList(DistributionVO distributionVO) {
		return distributionDao.queryForPage(distributionVO.getDistribution(), distributionVO.getPageNO(), distributionVO.getPageRows());
	}
}

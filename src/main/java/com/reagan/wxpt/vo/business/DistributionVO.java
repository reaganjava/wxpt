package com.reagan.wxpt.vo.business;

import java.util.ArrayList;
import java.util.List;

import com.reagan.wxpt.pojo.business.BusinessDistribution;
import com.reagan.wxpt.vo.BaseVO;

public class DistributionVO extends BaseVO {

	private BusinessDistribution distribution;
	
	private List<BusinessDistribution> distributionList;
	
	public DistributionVO() {
		distribution = new BusinessDistribution();
		distributionList = new ArrayList<BusinessDistribution>();
	}

	public BusinessDistribution getDistribution() {
		return distribution;
	}

	public void setDistribution(BusinessDistribution distribution) {
		this.distribution = distribution;
	}

	public List<BusinessDistribution> getDistributionList() {
		return distributionList;
	}

	public void setDistributionList(List<BusinessDistribution> distributionList) {
		this.distributionList = distributionList;
	}
	
}

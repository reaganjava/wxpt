package com.reagan.wxpt.vo.business;

import java.util.ArrayList;
import java.util.List;

import com.reagan.wxpt.pojo.business.BusinessAdvertisement;
import com.reagan.wxpt.vo.BaseVO;

public class AdvertisementVO extends BaseVO {

	private BusinessAdvertisement advertisement;
	
	private List<BusinessAdvertisement> advertisementList;
	
	public AdvertisementVO() {
		advertisement = new BusinessAdvertisement();
		advertisementList = new ArrayList<BusinessAdvertisement>();
	}

	public BusinessAdvertisement getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(BusinessAdvertisement advertisement) {
		this.advertisement = advertisement;
	}

	public List<BusinessAdvertisement> getAdvertisementList() {
		return advertisementList;
	}

	public void setAdvertisementList(List<BusinessAdvertisement> advertisementList) {
		this.advertisementList = advertisementList;
	}

}

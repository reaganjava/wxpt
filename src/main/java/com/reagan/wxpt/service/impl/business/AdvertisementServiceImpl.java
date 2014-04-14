package com.reagan.wxpt.service.impl.business;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.business.IAdvertisementDao;
import com.reagan.wxpt.pojo.business.BusinessAdvertisement;
import com.reagan.wxpt.service.business.IAdvertisementService;
import com.reagan.wxpt.vo.business.AdvertisementVO;

public class AdvertisementServiceImpl implements IAdvertisementService {

	private IAdvertisementDao advertisementDao;
	
	public void addAdvertisement(AdvertisementVO advertisementVO) throws Exception {
		advertisementDao.save(advertisementVO.getAdvertisement());
	}
	
	public boolean modifiAdvertisement(AdvertisementVO advertisementVO) {
		int rows = advertisementDao.update(advertisementVO.getAdvertisement());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public boolean removeAdvertisement(AdvertisementVO advertisementVO) {
		int rows = advertisementDao.delete(advertisementVO.getAdvertisement());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public AdvertisementVO viewAdvertisementDetail(AdvertisementVO advertisementVO) {
		BusinessAdvertisement advertisement = advertisementDao.query(advertisementVO.getAdvertisement());
		advertisementVO.setAdvertisement(advertisement);
		return advertisementVO;
	}
	
	public PageBean<BusinessAdvertisement> queryAdvertisementList(AdvertisementVO advertisementVO) {
		return advertisementDao.queryForPage(advertisementVO.getAdvertisement(), advertisementVO.getPageNO(), advertisementVO.getPageRows());
	}
}

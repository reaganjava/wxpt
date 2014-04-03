package com.reagan.wxpt.service.impl.common;

import java.util.List;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.common.ILocationDao;
import com.reagan.wxpt.pojo.common.CommonLocation;
import com.reagan.wxpt.service.common.ILocationService;
import com.reagan.wxpt.vo.common.LocationVO;

public class LocationServiceImpl implements ILocationService {

	public ILocationDao locationDao;
	
	public void addLocation(LocationVO locationVO) throws Exception {
		locationDao.save(locationVO.getLocation());
	}
	
	public boolean modifiLocation(LocationVO locationVO) {
		int rows = locationDao.update(locationVO.getLocation());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public boolean removeLocation(LocationVO locationVO) {
		int rows = locationDao.delete(locationVO.getLocation());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public LocationVO viewLocationDetail(LocationVO locationVO) {
		CommonLocation contact = locationDao.query(locationVO.getLocation());
		locationVO.setLocation(contact);
		return locationVO;
	}
	
	public LocationVO viewLocationList(LocationVO locationVO) {
		List<CommonLocation> contactList = locationDao.queryForList(locationVO.getLocation());
		locationVO.setLocationList(contactList);
		return locationVO;
	}
	
	public PageBean<CommonLocation> queryLocationList(LocationVO locationVO) {
		return locationDao.queryForPage(locationVO.getLocation(), locationVO.getPageNO(), locationVO.getPageCount());
	}
}

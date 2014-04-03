package com.reagan.wxpt.vo.common;

import java.util.ArrayList;
import java.util.List;

import com.reagan.wxpt.pojo.common.CommonLocation;
import com.reagan.wxpt.vo.BaseVO;

public class LocationVO extends BaseVO {

	private CommonLocation location;
	
	private List<CommonLocation> locationList;
	
	public LocationVO() {
		location = new CommonLocation();
		locationList = new ArrayList<CommonLocation>();
	}

	public CommonLocation getLocation() {
		return location;
	}

	public void setLocation(CommonLocation location) {
		this.location = location;
	}

	public List<CommonLocation> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<CommonLocation> locationList) {
		this.locationList = locationList;
	}
	
}

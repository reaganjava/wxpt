package com.reagan.wxpt.service.system;

import com.reagan.util.PageBean;
import com.reagan.wxpt.pojo.system.SysRegionCategory;
import com.reagan.wxpt.vo.system.RegionCategoryVO;

public interface IRegionCategoryService {

	void addRegionCategory(RegionCategoryVO regionCategoryVO) throws Exception;

	boolean modifiRegionCategory(RegionCategoryVO regionCategoryVO);

	boolean removeRegionCategory(RegionCategoryVO regionCategoryVO);

	RegionCategoryVO viewRegionCategoryDetail(RegionCategoryVO regionCategoryVO);

	PageBean<SysRegionCategory> queryRegionCategoryList(
			RegionCategoryVO regionCategoryVO);

}

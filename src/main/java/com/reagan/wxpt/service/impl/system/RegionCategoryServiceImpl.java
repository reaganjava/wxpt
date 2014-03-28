package com.reagan.wxpt.service.impl.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.system.IRegionCategoryDao;
import com.reagan.wxpt.pojo.system.SysRegionCategory;
import com.reagan.wxpt.service.system.IRegionCategoryService;
import com.reagan.wxpt.vo.system.RegionCategoryVO;

@Service("regionCategoryService")
public class RegionCategoryServiceImpl implements IRegionCategoryService {

	@Autowired
	private IRegionCategoryDao regionCategoryDao;
	
	@Override
	public void addRegionCategory(RegionCategoryVO regionCategoryVO) throws Exception {
		regionCategoryDao.save(regionCategoryVO.getRegionCategory());
	}
	
	@Override
	public boolean modifiRegionCategory(RegionCategoryVO regionCategoryVO) {
		int row = regionCategoryDao.update(regionCategoryVO.getRegionCategory());
		if(row > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean removeRegionCategory(RegionCategoryVO regionCategoryVO) {
		int row = regionCategoryDao.delete(regionCategoryVO.getRegionCategory());
		if(row > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public RegionCategoryVO viewRegionCategoryDetail(RegionCategoryVO regionCategoryVO) {
		SysRegionCategory regionCategory =  regionCategoryDao.query(regionCategoryVO.getRegionCategory());
		regionCategoryVO.setRegionCategory(regionCategory);
		return regionCategoryVO;
	}
	
	@Override
	public PageBean<SysRegionCategory> queryRegionCategoryList(RegionCategoryVO regionCategoryVO) {
		return regionCategoryDao.queryForPage(regionCategoryVO.getRegionCategory(), regionCategoryVO.getPageNO(), regionCategoryVO.getPageCount());
	}

}

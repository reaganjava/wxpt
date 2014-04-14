package com.reagan.wxpt.service.impl.system;

import java.util.List;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.join.IShopMenuGroupDao;
import com.reagan.wxpt.dao.system.IMenuGroupDao;
import com.reagan.wxpt.pojo.join.JoinShopMenuGroup;
import com.reagan.wxpt.pojo.system.SysMenuGroup;
import com.reagan.wxpt.service.system.IMenuGroupService;
import com.reagan.wxpt.vo.business.ShopVO;
import com.reagan.wxpt.vo.system.MenuGroupVO;

public class MenuGroupSerivceImpl implements IMenuGroupService {

	private IMenuGroupDao menuGroupDao;
	
	private IShopMenuGroupDao shopMenuGroupDao;
	
	public void addMenuGroup(MenuGroupVO menuGroupVO, ShopVO shopVO) throws Exception {
		Number pk = menuGroupDao.saveRePk(menuGroupVO.getMenuGroup());
		int menuGroupId = pk.intValue();
		JoinShopMenuGroup shopMenuGroup = new JoinShopMenuGroup();
		shopMenuGroup.setMenuGroupId(menuGroupId);
		shopMenuGroup.setShopId(shopVO.getShop().getShid());
		shopMenuGroupDao.save(shopMenuGroup);
	}
	
	public boolean modifiMenuGroup(MenuGroupVO menuGroupVO) {
		int rows = menuGroupDao.update(menuGroupVO.getMenuGroup());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public boolean removeMenuGroup(MenuGroupVO menuGroupVO) {
		JoinShopMenuGroup shopMenuGroup = new JoinShopMenuGroup();
		shopMenuGroup.setMenuGroupId(menuGroupVO.getMenuGroup().getMgid());
		shopMenuGroupDao.delete(shopMenuGroup);
		int rows = menuGroupDao.delete(menuGroupVO.getMenuGroup());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public MenuGroupVO viewMenuGroupDetail(MenuGroupVO menuGroupVO) {
		SysMenuGroup menuGroup = menuGroupDao.query(menuGroupVO.getMenuGroup());
		menuGroupVO.setMenuGroup(menuGroup);
		return menuGroupVO;
	}
	
	public MenuGroupVO viewMenuGroupList(MenuGroupVO menuGroupVO) {
		List<SysMenuGroup> menuGroupList = menuGroupDao.queryForList(menuGroupVO.getMenuGroup());
		menuGroupVO.setMenuGroupList(menuGroupList);
		return menuGroupVO;
	}
	
	public PageBean<SysMenuGroup> queryMenuGroupList(MenuGroupVO menuGroupVO) {
		return menuGroupDao.queryForPage(menuGroupVO.getMenuGroup(), menuGroupVO.getPageNO(), menuGroupVO.getPageRows());
	}
		
}

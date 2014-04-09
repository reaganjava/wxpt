package com.reagan.wxpt.service.impl.business;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.business.IShopDao;
import com.reagan.wxpt.pojo.business.BusinessShop;
import com.reagan.wxpt.service.business.IShopService;
import com.reagan.wxpt.vo.business.ShopVO;

public class ShopServiceImpl implements IShopService {

	private IShopDao shopDao;
	
	public void addShop(ShopVO shopVO) throws Exception {
		shopDao.save(shopVO.getShop());
	}
	
	public boolean modifiShop(ShopVO shopVO) {
		int rows = shopDao.update(shopVO.getShop());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public boolean removeShop(ShopVO shopVO) {
		int rows = shopDao.delete(shopVO.getShop());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public ShopVO viewShopDetail(ShopVO shopVO) {
		BusinessShop shop = shopDao.query(shopVO.getShop());
		shopVO.setShop(shop);
		return shopVO;
	}
	
	public PageBean<BusinessShop> queryShopList(ShopVO shopVO) {
		return shopDao.queryForPage(shopVO.getShop(), shopVO.getPageNO(), shopVO.getPageCount());
	}
}

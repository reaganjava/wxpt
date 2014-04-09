package com.reagan.wxpt.service.impl.business;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.business.IGoodsDao;
import com.reagan.wxpt.pojo.business.BusinessGoods;
import com.reagan.wxpt.service.business.IGoodsService;
import com.reagan.wxpt.vo.business.GoodsVO;

public class GoodsServiceImpl implements IGoodsService {

	private IGoodsDao goodsDao;
	
	public void addGoods(GoodsVO goodsVO) throws Exception {
		goodsDao.save(goodsVO.getGoods());
	}
	
	public boolean modifiGoods(GoodsVO goodsVO) {
		int rows = goodsDao.update(goodsVO.getGoods());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public boolean removeGoods(GoodsVO goodsVO) {
		int rows = goodsDao.delete(goodsVO.getGoods());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public GoodsVO viewGoodsDetail(GoodsVO goodsVO) {
		BusinessGoods goods = goodsDao.query(goodsVO.getGoods());
		goodsVO.setGoods(goods);
		return goodsVO;
	}
	
	public PageBean<BusinessGoods> queryGoodsList(GoodsVO goodsVO) {
		return goodsDao.queryForPage(goodsVO.getGoods(), goodsVO.getPageNO(), goodsVO.getPageCount());
	}
}

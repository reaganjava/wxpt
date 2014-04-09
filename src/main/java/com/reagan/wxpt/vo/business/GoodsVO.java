package com.reagan.wxpt.vo.business;

import java.util.ArrayList;
import java.util.List;

import com.reagan.wxpt.pojo.business.BusinessGoods;
import com.reagan.wxpt.vo.BaseVO;

public class GoodsVO extends BaseVO {
	
	private BusinessGoods goods;
	
	private List<BusinessGoods> goodsList;
	
	public GoodsVO() {
		goods = new BusinessGoods();
		goodsList = new ArrayList<BusinessGoods>();
	}

	public BusinessGoods getGoods() {
		return goods;
	}

	public void setGoods(BusinessGoods goods) {
		this.goods = goods;
	}

	public List<BusinessGoods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<BusinessGoods> goodsList) {
		this.goodsList = goodsList;
	}
	
}

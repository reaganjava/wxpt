package com.reagan.wxpt.service.impl.business;

import com.reagan.wxpt.dao.business.IOrderDao;
import com.reagan.wxpt.service.business.IOrderService;
import com.reagan.wxpt.vo.business.OrderVO;

public class OrderServiceImpl implements IOrderService {

	private IOrderDao orderDao;
	
	public void addOrder(OrderVO orderVO) {
		orderDao.save(orderVO.get);
	}
}

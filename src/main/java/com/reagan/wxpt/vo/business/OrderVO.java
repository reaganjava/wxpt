package com.reagan.wxpt.vo.business;

import java.util.ArrayList;
import java.util.List;

import com.reagan.wxpt.pojo.business.BusinessOrder;
import com.reagan.wxpt.vo.BaseVO;

public class OrderVO extends BaseVO {
	
	private BusinessOrder order;
	
	private List<BusinessOrder> orderList;
	
	public OrderVO() {
		order = new BusinessOrder();
		orderList = new ArrayList<BusinessOrder>();
	}

	public BusinessOrder getOrder() {
		return order;
	}

	public void setOrder(BusinessOrder order) {
		this.order = order;
	}

	public List<BusinessOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<BusinessOrder> orderList) {
		this.orderList = orderList;
	}

}

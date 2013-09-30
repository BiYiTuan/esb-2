package com.boohoo.esb.database.dao;

import com.boohoo.esb.database.dao.model.AllocatedOrder;

public interface AllocatedOrderDao extends BaseDao<AllocatedOrder, Integer> {
	public Integer createAllocatedOrder(Integer orderNumber, Integer orderStatus, Integer insertId);
	public Integer updateAllocatedOrderStatus(Integer orderStatus, Integer id);
	public Integer getAllocatedOrderId(String orderNumber);
}

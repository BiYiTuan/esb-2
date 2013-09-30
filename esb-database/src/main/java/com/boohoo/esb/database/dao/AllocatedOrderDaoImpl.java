package com.boohoo.esb.database.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.boohoo.esb.database.dao.model.AllocatedOrder;

@Repository
@Transactional
public class AllocatedOrderDaoImpl extends JpaBaseDao<AllocatedOrder, Integer>
		implements AllocatedOrderDao {
	@PersistenceContext
	private EntityManager em;
	@Override
	public Integer createAllocatedOrder(Integer orderNumber, Integer orderStatus,Integer outParameter) {
		Query query = em.createNativeQuery("{call CreateAllocatedOrder(?1, ?2, ?3)}",AllocatedOrder.class);
		query.setParameter(1, orderNumber);
		query.setParameter(2, orderStatus);
		query.setParameter(3, outParameter);
		return query.getFirstResult();
	}
	@Override
	public Integer updateAllocatedOrderStatus(Integer orderStatus, Integer id) {
		Query query = em.createNativeQuery("{call UpdateAllocatedOrderStatus(?1, ?2)}", AllocatedOrder.class);
		query.setParameter(1, orderStatus);
		query.setParameter(2, id);
		return query.getFirstResult();
	}
	@Override
	public Integer getAllocatedOrderId(String orderNumber) {
		Query query = em.createNativeQuery("{call GetAllocatedOrderId(?1)}", AllocatedOrder.class);
		query.setParameter(1, orderNumber);
		return query.getFirstResult();
	}

}

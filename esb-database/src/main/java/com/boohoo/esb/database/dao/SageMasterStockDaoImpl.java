package com.boohoo.esb.database.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.boohoo.esb.database.dao.model.SageMasterStock;

@Repository("sageMasterStockDao")
@Transactional(readOnly=true)
public class SageMasterStockDaoImpl extends JpaBaseDao<SageMasterStock, Integer> implements SageMasterStockDao {
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Integer updateSageStock(SageMasterStock masterStock) {
		return entityManager.merge(masterStock).getId();
	}
	
	public List<SageMasterStock> findAll(){
		List<SageMasterStock>  resultList = entityManager.createNativeQuery("call GetAllSageMasterStock()", SageMasterStock.class).getResultList();
		return resultList;
	}
}
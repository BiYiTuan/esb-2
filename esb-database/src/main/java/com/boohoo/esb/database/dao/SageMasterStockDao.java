package com.boohoo.esb.database.dao;

import java.util.List;

import com.boohoo.esb.database.dao.model.SageMasterStock;

public interface SageMasterStockDao extends BaseDao<SageMasterStock, Integer> {
	public SageMasterStock updateSageStock(SageMasterStock masterStock);
	public List<SageMasterStock> findAll();
}
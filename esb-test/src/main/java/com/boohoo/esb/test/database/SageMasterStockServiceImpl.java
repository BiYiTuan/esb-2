package com.boohoo.esb.test.database;

import org.apache.commons.lang.RandomStringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boohoo.esb.database.dao.SageMasterStockDao;
import com.boohoo.esb.database.dao.model.SageMasterStock;

public class SageMasterStockServiceImpl implements SageMasterStockService {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SageMasterStockServiceImpl.class);
	private SageMasterStockDao sageMasterStockDao;

	public SageMasterStockServiceImpl(SageMasterStockDao sageMasterStockDao) {
		this.sageMasterStockDao = sageMasterStockDao;
	}

	@Override
	public SageMasterStock insertSage() {
		LOGGER.info("Inserting into database.");
		
		SageMasterStock sageMasterStock = new SageMasterStock();
		sageMasterStock.setQuantity(Integer.parseInt(RandomStringUtils.randomNumeric(2)));
		sageMasterStock.setSku(RandomStringUtils.randomAlphanumeric(10));
		sageMasterStock.setUpdatedDateTime(DateTime.now().toString());
		SageMasterStock save = this.sageMasterStockDao.save(sageMasterStock);
		LOGGER.info("Inserted:" + save);
		return save;
	}

}

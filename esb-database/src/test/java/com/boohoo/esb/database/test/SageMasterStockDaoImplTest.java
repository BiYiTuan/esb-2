package com.boohoo.esb.database.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boohoo.esb.database.dao.SageMasterStockDao;
import com.boohoo.esb.database.dao.model.SageMasterStock;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:testApplicationContext.xml")
@Ignore
public class SageMasterStockDaoImplTest {
	@Autowired
	SageMasterStockDao sageMasterStockDao;
	
	@Test
	public void save(){
		SageMasterStock s = new SageMasterStock();
		s.setQuantity(Integer.parseInt(RandomStringUtils.randomNumeric(4)));
		s.setSku(RandomStringUtils.randomAlphabetic(10));
		s.setUpdatedDateTime("2012-12-12");
		SageMasterStock save = sageMasterStockDao.save(s);
		assertNotNull(save.getId());
	}
	
	@After
	public void tearDown(){
		//sageMasterStockDao.deleteAll();
	}

	@Test
	public  void testFindAll() throws Exception {
		List<SageMasterStock> findAll = sageMasterStockDao.findAll();
		for (SageMasterStock sageMasterStock : findAll) {
			System.out.println(sageMasterStock);
		}
	}
}

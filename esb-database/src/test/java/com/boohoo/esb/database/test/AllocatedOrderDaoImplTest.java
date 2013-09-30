package com.boohoo.esb.database.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boohoo.esb.database.dao.AllocatedOrderDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:testApplicationContext.xml")
public class AllocatedOrderDaoImplTest {
	@Autowired
	AllocatedOrderDao dao; 

	@Test
	public  void testCreateAllocatedOrder() throws Exception {
		Integer insertId = new Integer(-1);
		Integer count = dao.createAllocatedOrder(23,1, insertId);
		assertNotNull(count);
	}

	@Test
	public  void testUpdateAllocatedOrderStatus() throws Exception {
		Integer insertId = new Integer(-1);
		Integer count = dao.createAllocatedOrder(23,1, insertId);
		assertNotNull(count);
		
		dao.updateAllocatedOrderStatus(2, insertId);
	}
}

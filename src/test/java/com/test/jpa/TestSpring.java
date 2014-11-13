package com.test.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestSpring extends SpringBasedTest {

	@Autowired
	private OtcRunService otcRunService;
	@Autowired
	private OtcRunDao otcRunDao;

	@Test
	@Transactional
	public void test() {
		List<OtcRun> findAll = otcRunDao.findAll();
		assertEquals(0, findAll.size());

		otcRunService.executeWithTransaction();

		findAll = otcRunDao.findAll();
		assertEquals(1, findAll.size());

		try {
			otcRunService.executeWithTransactionAndThrowException();
		} catch (RuntimeException e) {
		}

		Iterator<OtcRun> findAllIterator = otcRunDao.findAllIterator();
		assertTrue(findAllIterator.hasNext());
		assertNotNull(findAllIterator.next());
		assertFalse(findAllIterator.hasNext());

	}

}

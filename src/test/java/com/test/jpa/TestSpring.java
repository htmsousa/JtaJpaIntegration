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
	private RunService runService;
	@Autowired
	private RunDao runDao;

	@Test
	@Transactional
	public void test() {
		List<Run> findAll = runDao.findAll();
		assertEquals(0, findAll.size());

		runService.executeWithTransaction();

		findAll = runDao.findAll();
		assertEquals(1, findAll.size());

		try {
			runService.executeWithTransactionAndThrowException();
		} catch (RuntimeException e) {
		}

		Iterator<Run> findAllIterator = runDao.findAllIterator();
		assertTrue(findAllIterator.hasNext());
		assertNotNull(findAllIterator.next());
		assertFalse(findAllIterator.hasNext());

	}

}

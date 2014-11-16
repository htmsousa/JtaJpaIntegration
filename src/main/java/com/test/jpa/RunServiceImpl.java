package com.test.jpa;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunServiceImpl implements RunService {

	@Autowired
	private RunDao runDao;

	@Transactional(value = Transactional.TxType.REQUIRES_NEW)
	public void executeWithTransaction() {
		Run run = new Run();
		run.runId = 1;
		runDao.create(run);
	}

	@Transactional(value = Transactional.TxType.REQUIRES_NEW)
	public void executeWithTransactionAndThrowException() {
		Run run = new Run();
		run.runId = 2;
		runDao.create(run);
		throw new RuntimeException();
	}

}

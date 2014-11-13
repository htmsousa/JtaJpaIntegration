package com.test.jpa;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtcRunServiceImpl implements OtcRunService {

	@Autowired
	private OtcRunDao otcRunDao;

	@Transactional(value = Transactional.TxType.REQUIRES_NEW)
	public void executeWithTransaction() {
		OtcRun otcRun = new OtcRun();
		otcRun.runId = 1;
		otcRunDao.create(otcRun);
	}

	@Transactional(value = Transactional.TxType.REQUIRES_NEW)
	public void executeWithTransactionAndThrowException() {
		OtcRun otcRun = new OtcRun();
		otcRun.runId = 2;
		otcRunDao.create(otcRun);
		throw new RuntimeException();
	}

}

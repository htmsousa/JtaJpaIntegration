package com.test.jpa;

public interface OtcRunService {

	void executeWithTransaction();

	void executeWithTransactionAndThrowException();
}

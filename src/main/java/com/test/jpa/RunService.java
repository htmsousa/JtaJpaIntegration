package com.test.jpa;

public interface RunService {

	void executeWithTransaction();

	void executeWithTransactionAndThrowException();
}

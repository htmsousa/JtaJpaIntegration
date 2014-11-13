package com.test.jpa;

import org.springframework.stereotype.Repository;


@Repository
public class OtcRunDaoImpl extends GenericDaoImpl<OtcRun, Integer> implements
		OtcRunDao {

	public OtcRunDaoImpl() {
		super(OtcRun.class);
	}
}

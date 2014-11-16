package com.test.jpa;

import org.springframework.stereotype.Repository;


@Repository
public class RunDaoImpl extends GenericDaoImpl<Run, Integer> implements
		RunDao {

	public RunDaoImpl() {
		super(Run.class);
	}
}

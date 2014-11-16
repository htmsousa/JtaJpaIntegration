package com.test.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Run {

	public Run() {

	}

	@Column
	@Id
	public int runId;

	@Column
	public String val;
}

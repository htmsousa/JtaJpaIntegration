package com.test.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OtcRun {

	public OtcRun() {

	}

	@Column
	@Id
	public int runId;

	@Column
	public String val;
}

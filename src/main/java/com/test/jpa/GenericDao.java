package com.test.jpa;

import java.util.Iterator;
import java.util.List;

public interface GenericDao<T, ID> {
	T create(T t);

	T find(ID id);

	List<T> findAll();

	Iterator<T> findAllIterator();
}
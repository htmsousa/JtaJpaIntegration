package com.test.jpa;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.StatelessSession;

public abstract class GenericDaoImpl<T, ID> implements GenericDao<T, ID> {

	@PersistenceContext
	private EntityManager em;

	private Class<T> type;

	public GenericDaoImpl(Class<T> type) {
		this.type = type;
	}

	public T create(T t) {
		em.persist(t);
		return t;
	}

	public List<T> findAll() {
		return em.createQuery("from " + type.getName(), type).getResultList();
	}

	public Iterator<T> findAllIterator() {
		Session session = (Session) em.unwrap(Session.class);
		StatelessSession statelessSession = session.getSessionFactory()
				.openStatelessSession();
		final ScrollableResults scrollableResults = statelessSession
				.createQuery("from " + type.getName()).scroll();

		return new Iterator<T>() {

			public boolean hasNext() {
				return scrollableResults.next();
			}

			@SuppressWarnings("unchecked")
			public T next() {
				return (T) scrollableResults.get(0);
			}
		};
	}

	public T find(ID id) {
		return em.find(type, id);
	}

}

package com.web.dao.Generic;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("genericDao")
@SuppressWarnings("unchecked")
public abstract class AbstractGenericDao<T> implements GenericDao<T> {

	private Class<T> Entity;

	@Autowired
	private SessionFactory sessionFactory;

	public AbstractGenericDao() {
		this.Entity = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	protected final Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void AddEntity(T entity) {
		getSession().persist(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	public void deleteById(Integer entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}

	public void update(T entity) {
		getSession().merge(entity);
	}

	public T findOne(Integer id) {
		return (T) getSession().get(Entity, id);
	}

	protected Criteria createEntityCriteria() {
		return getSession().createCriteria(Entity);
	}

	public List<T> findAll() {
		return getSession().createQuery("from " + Entity.getName()).list();
	}

	public void deleteAll() {
		List<T> entities = findAll();
		for (T entity : entities) {
			getSession().delete(entity);
		}
	}

	public void clear() {
		getSession().clear();

	}

	public void flush() {
		getSession().flush();

	}
}

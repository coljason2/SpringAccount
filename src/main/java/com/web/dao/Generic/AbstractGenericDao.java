package com.web.dao.Generic;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.model.BaseMode;

@Repository("genericDao")
@SuppressWarnings("all")
public abstract class AbstractGenericDao<T extends BaseMode> implements GenericDao<T> {

	private Logger logger = Logger.getLogger(this.getClass());

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
		entity.setCreateDate(new Date());
		entity.setUpdateDate(new Date());
		getSession().persist(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	public void deleteById(UUID entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}

	public void update(T entity) {
		entity.setUpdateDate(new Date());
		getSession().merge(entity);
	}

	public T findOne(UUID id) {
		return (T) getSession().get(Entity, id);
	}

	public T findOne(String id) {
		return (T) getSession().get(Entity, id);
	}

	protected Criteria createEntityCriteria() {
		return getSession().createCriteria(Entity);
	}

	public List<T> findAll() {
		logger.info("DAO findAll()");
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

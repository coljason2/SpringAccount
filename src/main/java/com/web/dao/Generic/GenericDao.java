package com.web.dao.Generic;

import java.util.List;

public interface GenericDao<T> {
	T findOne(final long id);

	List<T> findAll();

	void AddEntity(final T entity);

	void update(final T entity);

	void delete(final T entity);

	void deleteById(final long entityId);

	void deleteAll();

	void clear();

	void flush();
}

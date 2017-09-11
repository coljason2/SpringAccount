package com.web.dao.Generic;

import java.util.List;

public interface GenericDao<T> {
	T findOne(final Integer id);

	List<T> findAll();

	void AddEntity(final T entity);

	void update(final T entity);

	void delete(final T entity);

	void deleteById(final Integer entityId);

	void deleteAll();

	void clear();

	void flush();
}

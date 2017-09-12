package com.web.dao.Generic;

import java.util.List;

import com.web.model.BaseMode;

public interface GenericDao<T extends BaseMode> {
	T findOne(final Long id);

	List<T> findAll();

	void AddEntity(final T entity);

	void update(final T entity);

	void delete(final T entity);

	void deleteById(final Long entityId);

	void deleteAll();

	void clear();

	void flush();
}

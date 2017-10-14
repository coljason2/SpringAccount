package com.web.dao.Generic;

import java.util.List;
import java.util.UUID;

import com.web.model.BaseMode;

public interface GenericDao<T extends BaseMode> {
	T findOne(final UUID id);

	T findOne(final String id);
	
	List<T> findAll();

	void AddEntity(final T entity);

	void update(final T entity);

	void delete(final T entity);

	void deleteById(final UUID entityId);

	void deleteAll();

	void clear();

	void flush();
}

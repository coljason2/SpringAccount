package com.web.service.Generic;

import java.util.List;

import com.web.model.BaseMode;

public interface GenericService<T extends BaseMode> {

	public List<T> getAll();

	public T findbyOne(Long id);

	public void add(T entity);

	public void update(T entity);

	public void remove(T entity);
}

package com.web.service.Generic;

import java.util.List;
import java.util.UUID;

import com.web.model.BaseMode;

public interface GenericService<T extends BaseMode> {

	public List<T> getAll();

	public T findbyOne(UUID id);

	public T findbyOne(String id);

	public void add(T entity);

	public void update(T entity);

	public void remove(T entity);

	public void removebyId(UUID id);
}

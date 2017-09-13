package com.web.service.Generic;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.web.dao.Generic.GenericDao;
import com.web.model.BaseMode;

@Service
@Transactional
public abstract class GenericServiceImpl<T extends BaseMode> implements GenericService<T> {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private GenericDao<T> genericDao;

	@Override
	public List<T> getAll() {
		logger.info("getAll()");
		return genericDao.findAll();
	}

	@Override
	public T findbyOne(Long id) {
		logger.info("findbyOne" + id);
		return genericDao.findOne(id);
	}

	@Override
	public void add(T entity) {
		logger.info("findbyOne" + entity.toString());
		genericDao.AddEntity(entity);
	}

	@Override
	public void update(T entity) {
		logger.info("update" + entity.toString());
		genericDao.update(entity);
	}

	@Override
	public void remove(T entity) {
		logger.info("remove" + entity.toString());
		genericDao.delete(entity);
	}

	@Override
	public void removebyId(Long id) {
		logger.info("removebyId" + id);
		genericDao.deleteById(id);
	}

}

package com.web.dao;

import java.util.List;
import java.util.UUID;

import com.web.dao.Generic.GenericDao;
import com.web.model.MedItem;

public interface MedItemDao extends GenericDao<MedItem> {

	public List<MedItem> findbyformId(UUID id);

	public void removebyformId(UUID id);

}

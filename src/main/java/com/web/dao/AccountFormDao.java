package com.web.dao;

import java.util.List;
import java.util.UUID;

import com.web.dao.Generic.GenericDao;
import com.web.model.AccountForm;

public interface AccountFormDao extends GenericDao<AccountForm> {
	public List<AccountForm> findByHosId(UUID id);
}

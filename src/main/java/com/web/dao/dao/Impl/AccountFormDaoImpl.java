package com.web.dao.dao.Impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.web.dao.AccountFormDao;
import com.web.dao.Generic.AbstractGenericDao;
import com.web.model.AccountForm;

@Repository
public class AccountFormDaoImpl extends AbstractGenericDao<AccountForm> implements AccountFormDao {

	@Override
	public List<AccountForm> findByHosId(UUID id) {
		String hql = "from AccountForm a where a.hospital.id = ?";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, id);
		List<AccountForm> list = query.list();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;

	}

}

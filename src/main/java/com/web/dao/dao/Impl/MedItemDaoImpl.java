package com.web.dao.dao.Impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.web.dao.MedItemDao;
import com.web.dao.Generic.AbstractGenericDao;
import com.web.model.MedItem;

@Repository
public class MedItemDaoImpl extends AbstractGenericDao<MedItem> implements MedItemDao {

	@Override
	public List<MedItem> findbyformId(UUID id) {
		String hql = "from MedItem m where m.accountform.id = ?";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, id);
		List<MedItem> list = query.list();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public void removebyformId(UUID id) {
		String hql = "delete from MedItem m where m.accountform.id = ?";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, id);
		query.executeUpdate();
	}

}

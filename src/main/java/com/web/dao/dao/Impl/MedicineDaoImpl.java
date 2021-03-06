package com.web.dao.dao.Impl;

import java.util.List;
import java.util.UUID;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.web.dao.MedicineDao;
import com.web.dao.Generic.AbstractGenericDao;
import com.web.model.Medicine;

@Repository
public class MedicineDaoImpl extends AbstractGenericDao<Medicine> implements MedicineDao {

	@Override
	public List<Medicine> findAllByCompanyId(UUID id) {

		String hql = "from Medicine m where m.company.id = ?";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, id);
		List<Medicine> list = query.list();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;

	}

	@Override
	public void deleteByComId(UUID id) {

		// List<Medicine> meds = findAllByCompanyId(id);
		// if (meds != null) {
		String hql = "delete from Medicine m  where m.company.id = ?";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, id);
		query.executeUpdate();
		// }
	}

	@Override
	public List<Medicine> findAllByCompanyName(String name) {

		String hql = "from Medicine m where m.company.com_name = ?";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, name);
		List<Medicine> list = query.list();
		if (list != null && list.size() > 0) {
			return list;
		}

		return null;
	}

}

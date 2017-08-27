package com.web.dao.dao.Impl;

import org.springframework.stereotype.Repository;

import com.web.dao.MedicineDao;
import com.web.dao.Generic.AbstractGenericDao;
import com.web.model.Medicine;

@Repository
public class MedicineDaoImpl extends AbstractGenericDao<Medicine> implements MedicineDao {

}

package com.web.service.implment;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.web.dao.MedItemDao;
import com.web.model.MedItem;
import com.web.service.MedItemService;

@Service
@Transactional
public class MedItemServiceImpl implements MedItemService {
	final static Logger logger = Logger.getLogger(MedItemServiceImpl.class);

	@Autowired
	MedItemDao dao;

	@Override
	public void AddMedItem(MedItem com) {
		// TODO Auto-generated method stub

	}

	@Override
	public void UpdateMedItem(MedItem com) {
		// TODO Auto-generated method stub

	}

	@Override
	public void DeleteMedItem(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MedItem> findAllMedItem() {
		// TODO Auto-generated method stub
		return null;
	}

}

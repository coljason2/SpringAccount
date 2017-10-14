package com.web.service.implment;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.web.dao.MedItemDao;
import com.web.model.MedItem;
import com.web.service.MedItemService;
import com.web.service.Generic.GenericServiceImpl;

@Service
@Transactional
public class MedItemServiceImpl extends GenericServiceImpl<MedItem> implements MedItemService {

	@Autowired
	MedItemDao dao;

	@Override
	public List<MedItem> findbyformId(UUID id) {
		return dao.findbyformId(id);
	}

}

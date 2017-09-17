package com.web.service.implment;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.AccountFormDao;
import com.web.model.AccountForm;
import com.web.service.AccountFormService;
import com.web.service.Generic.GenericServiceImpl;

@Service
@Transactional
public class AccountFormServiceImpl extends GenericServiceImpl<AccountForm> implements AccountFormService {

	@Autowired
	AccountFormDao dao;

	@Override
	public List<AccountForm> findByHosId(UUID id) {

		return dao.findByHosId(id);
	}

}

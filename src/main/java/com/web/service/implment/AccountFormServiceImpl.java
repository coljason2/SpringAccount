package com.web.service.implment;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.AccountFormDao;
import com.web.model.AccountForm;
import com.web.service.AccountFormService;

@Service
@Transactional
public class AccountFormServiceImpl implements AccountFormService {
	final static Logger logger = Logger.getLogger(AccountFormServiceImpl.class);
	@Autowired
	AccountFormDao dao;

	@Override
	public void AddAccountForm(AccountForm com) {
		logger.debug("Add Form");

	}

	@Override
	public void UpdateAccountForm(AccountForm com) {
		// TODO Auto-generated method stub

	}

	@Override
	public void DeleteAccountForm(Long id) {
		dao.deleteById(id);

	}

	@Override
	public List<AccountForm> findAllAccountForm() {
		logger.debug("List All Form ");
		return dao.findAll();
	}

	@Override
	public AccountForm findbyOne(Long id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

}

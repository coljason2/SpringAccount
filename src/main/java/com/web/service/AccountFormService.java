package com.web.service;

import java.util.List;

import com.web.model.AccountForm;

public interface AccountFormService {

	public void AddAccountForm(AccountForm com);

	public void UpdateAccountForm(AccountForm com);

	public void DeleteAccountForm(Long id);

	public List<AccountForm> findAllAccountForm();

	public AccountForm findbyOne(Long id);
}

package com.web.service;

import java.util.List;
import java.util.UUID;

import com.web.model.AccountForm;
import com.web.service.Generic.GenericService;

public interface AccountFormService extends GenericService<AccountForm> {

	public List<AccountForm> findByHosId(UUID id);

}

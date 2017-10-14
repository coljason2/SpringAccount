package com.web.service;

import java.util.List;
import java.util.UUID;

import com.web.model.MedItem;
import com.web.service.Generic.GenericService;

public interface MedItemService extends GenericService<MedItem> {

	public List<MedItem> findbyformId(UUID id);

}

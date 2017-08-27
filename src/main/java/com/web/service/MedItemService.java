package com.web.service;

import java.util.List;

import com.web.model.MedItem;

public interface MedItemService {

	public void AddMedItem(MedItem mit);

	public void UpdateMedItem(MedItem mit);

	public void DeleteMedItem(int id);

	public List<MedItem> findAllMedItem();
}

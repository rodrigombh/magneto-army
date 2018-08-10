package com.rmbh.models.dao;

import com.rmbh.models.DnaItem;

public interface DnaItemDAO {
	
	void put(DnaItem dnaItem);
	
	DnaItem get(String id);
	
	Integer getTotalDnaCount();
	
	Integer getMutantsDnaCount();
	
}

package com.rmbh.core.mutant;

import java.util.Arrays;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rmbh.core.analyzer.DnaAnalyzer;
import com.rmbh.core.analyzer.DnaAnalyzerImpl;
import com.rmbh.models.DnaItem;
import com.rmbh.models.dao.DnaItemDAO;

public class MutantServiceImpl implements MutantService {

	private final DnaAnalyzer dnaAnalyzer;
	private final DnaItemDAO dnaItemDAO;
	
	public MutantServiceImpl(DnaAnalyzer dnaAnalyzer, DnaItemDAO dnaItemDAO) {
		this.dnaAnalyzer = dnaAnalyzer;
		this.dnaItemDAO = dnaItemDAO;
	}
	
	Logger logger = LoggerFactory.getLogger(DnaAnalyzerImpl.class);

	public boolean isMutant(String[] dna) {
	
		String stringDna = Arrays.toString(dna);
		String id = UUID.nameUUIDFromBytes(stringDna.getBytes()).toString();
		
		DnaItem dnaItem = dnaItemDAO.get(id);
		
		if (dnaItem != null) {
			
			logger.info("Dna with Id: " + id + " already exist.");
			
			return dnaItem.getIsMutant();
			
		} else {
			
			logger.info("Dna does not exist. Going to validate: " + stringDna);
			
			boolean isMutant = dnaAnalyzer.isMutant(dna);
			dnaItemDAO.put(new DnaItem(id, Arrays.asList(dna), isMutant));
			
			return isMutant;
		}
		
	}
	
}

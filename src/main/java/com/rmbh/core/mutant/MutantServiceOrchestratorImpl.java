package com.rmbh.core.mutant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rmbh.api.StatsResponse;
import com.rmbh.core.analyzer.DnaAnalyzer;
import com.rmbh.core.analyzer.DnaAnalyzerImpl;
import com.rmbh.dao.DnaItemDAO;
import com.rmbh.models.DnaItem;

public class MutantServiceOrchestratorImpl implements MutantServiceOrchestrator {

	private final DnaAnalyzer dnaAnalyzer;
	private final DnaItemDAO dnaItemDAO;
	
	public MutantServiceOrchestratorImpl(DnaAnalyzer dnaAnalyzer, DnaItemDAO dnaItemDAO) {
		this.dnaAnalyzer = dnaAnalyzer;
		this.dnaItemDAO = dnaItemDAO;
	}
	
	Logger logger = LoggerFactory.getLogger(DnaAnalyzerImpl.class);
	
	@Override
	public boolean isMutant(String[] dna) {
	
		String id = DnaItem.generateId(dna);
		DnaItem dnaItem = dnaItemDAO.get(id);
		
		if (dnaItem == null) {
			
			logger.info("New Dna received.");
			dnaItem = new DnaItem(id, dna, dnaAnalyzer.isMutant(dna));
			dnaItemDAO.put(dnaItem);
		}
		
		logger.info("DnaAnalyzer mutant result was: {}.", dnaItem.getIsMutant());
		
		return dnaItem.getIsMutant();
	}
	
	@Override
	public StatsResponse getStatistics() {
		
		StatsResponse statsResponse = new StatsResponse(dnaItemDAO.getDnaCount(true), dnaItemDAO.getDnaCount(false));
		
		logger.info("Ratio resolved for MutantCount: {}, HumansDnaCount: {}, was {}", 
				statsResponse.getCountMutantDna(), statsResponse.getCountHumanDna(), statsResponse.getRatio());
		
		return statsResponse;
	}
	
}

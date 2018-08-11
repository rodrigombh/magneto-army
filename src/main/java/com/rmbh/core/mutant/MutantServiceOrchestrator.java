package com.rmbh.core.mutant;

import com.rmbh.api.StatsResponse;

public interface MutantServiceOrchestrator {

	boolean isMutant(String[] dna);

	StatsResponse getStatistics();
	
}

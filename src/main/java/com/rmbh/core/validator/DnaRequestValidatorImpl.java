package com.rmbh.core.validator;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DnaRequestValidatorImpl implements DnaRequestValidator {
	
	Logger logger = LoggerFactory.getLogger(DnaRequestValidatorImpl.class);
	
	private static final String ATCG = "ATCG";
	
	@Override
	public boolean isValid(String[] dna) {
		
		boolean isValid = validate(dna);
		
		logger.info("Request validation result was: {} for sequence: {}", isValid, dna);
		
		return isValid;
	}

	private boolean validate(String[] dna) {
		
		int rowLength = dna.length;
		
		for (String dnaRow : dna) {
			
			if (!StringUtils.containsOnly(dnaRow, ATCG)) {
				logger.info("Invalid character in dna row: {}", dnaRow);
				return false;
			}
			
			if (dnaRow.length() != rowLength) {
				logger.info("Invalid length for dna row: {}", dnaRow);
				return false;
			}
		}
		
		return true;
	}

}

package com.rmbh.core.utils;

import org.apache.commons.lang3.StringUtils;

public class DnaRequestValidator {
	
	private static final String ATCG = "ATCG";

	public static boolean isValid(String[] dna) {
		
		int rowLength = dna.length;
		
		for (String dnaRow : dna) {
			if(!StringUtils.containsOnly(dnaRow, ATCG)) {
				return false;
			}
			if(dnaRow.length() != rowLength) {
				return false;
			}
		}
		
		return true;
	}

}

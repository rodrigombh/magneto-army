package com.rmbh.core.analyzer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rmbh.core.extractor.MatrixExtractor;
import com.rmbh.core.extractor.MatrixExtractorImpl;
import com.rmbh.core.utils.SecuenceFinder;

public class DnaAnalyzerImpl implements DnaAnalyzer {
	
	Logger logger = LoggerFactory.getLogger(DnaAnalyzerImpl.class);

	@Override
	public boolean isMutant(String[] dna) {
		
		MatrixExtractor matrixExtractor = new MatrixExtractorImpl(dna);
		int secuenceCounter = 0;

		for (String line : matrixExtractor.getHorizontalLines()) {
			secuenceCounter = secuenceCounter + SecuenceFinder.countSecuences(line);
		}

		for (String line : matrixExtractor.getVerticalLines()) {
			secuenceCounter = secuenceCounter + SecuenceFinder.countSecuences(line);
		}

		for (String line : matrixExtractor.getDiagonalLines()) {
			secuenceCounter = secuenceCounter + SecuenceFinder.countSecuences(line);
		}
		
		logger.info("Secuences Found: " + secuenceCounter);

		return secuenceCounter > 1;
	}

}

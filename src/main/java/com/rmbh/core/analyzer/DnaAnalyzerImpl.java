package com.rmbh.core.analyzer;

import com.rmbh.core.extractor.MatrixExtractor;
import com.rmbh.core.extractor.MatrixExtractorImpl;
import com.rmbh.core.utils.SecuenceFinder;

public class DnaAnalyzerImpl implements DnaAnalyzer {

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
		
		return secuenceCounter > 1;
	}

}

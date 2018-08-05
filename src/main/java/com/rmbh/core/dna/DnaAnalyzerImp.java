package com.rmbh.core.dna;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rmbh.core.extractor.MatrixExtractor;
import com.rmbh.core.extractor.MatrixExtractorImp;
import com.rmbh.core.utils.SecuenceFinder;

public class DnaAnalyzerImp implements DnaAnalyzer {
	
	Logger logger = LoggerFactory.getLogger(DnaAnalyzerImp.class);

	@Override
	public boolean isMutant(String[] dna) {

		logger.info("Going to validate: " + Arrays.toString(dna));
		
		MatrixExtractor matrixExtractor = new MatrixExtractorImp(dna);
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

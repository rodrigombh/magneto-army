package com.rmbh.core.dna;

import com.rmbh.core.utils.MatrixExtractor;
import com.rmbh.core.utils.SecuenceFinder;

public class DnaAnalyzerSimpleImp implements DnaAnalyzer {

	@Override
	public boolean isMutant(String[] dna) {

		int secuenceCounter = 0;

		MatrixExtractor matrixExtractor = new MatrixExtractor(dna);

		for (String line : matrixExtractor.getHorizontalLines()) {
			secuenceCounter = secuenceCounter + SecuenceFinder.countSecuences(line);
		}

		for (String line : matrixExtractor.getVerticalLines()) {
			secuenceCounter = secuenceCounter + SecuenceFinder.countSecuences(line);
		}

		for (String line : matrixExtractor.getDiagonalLeftToRightLines()) {
			secuenceCounter = secuenceCounter + SecuenceFinder.countSecuences(line);
		}
		
		for (String line : matrixExtractor.getDiagonalRightToLeftLines()) {
			secuenceCounter = secuenceCounter + SecuenceFinder.countSecuences(line);
		}
		
		//TODO: Loguea cuantas encontraste
		System.out.println("secuenceCounter: " + secuenceCounter);

		return secuenceCounter > 1;
	}

}

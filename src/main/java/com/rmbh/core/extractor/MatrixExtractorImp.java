package com.rmbh.core.extractor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class MatrixExtractorImp implements MatrixExtractor{
	
	private String[] stringArray;
	private List<String> verticalLines = new ArrayList<String>();
	private List<String> horizontalLines = new ArrayList<String>();
	private List<String> diagonalLines = new ArrayList<String>();

	public MatrixExtractorImp(String[] stringArray) {
		this.stringArray = stringArray;
		resolveVerticalLines();
		resolveDiagonalLines();
		resolveHorizonalLines();
	}

	private void resolveHorizonalLines() {
		horizontalLines = new ArrayList<>(Arrays.asList(stringArray));
	}

	private void resolveDiagonalLines() {
		
		String stringRow = StringUtils.EMPTY;
		String stringRowReversed = StringUtils.EMPTY;
		int stringArrayLength = stringArray.length;
		
		// Resolve 1st Triangle
		for (int fil = 0; fil < stringArrayLength; fil++) {
			stringRow = StringUtils.EMPTY;
			stringRowReversed = StringUtils.EMPTY;
			for (int col = 0; col <= fil; col++) {
				stringRow = stringRow.concat(getStringElem(fil - col, col));
				stringRowReversed = stringRowReversed.concat(getStringElemReversed(fil - col, col));
			}
			diagonalLines.add(stringRow);
			diagonalLines.add(stringRowReversed);
		}
		
		// Resolve 2do Triangle
		for (int col = 0; col < stringArrayLength - 1; col++) {
			stringRow = StringUtils.EMPTY;
			stringRowReversed = StringUtils.EMPTY;
			for (int fil = stringArrayLength - 1; fil - col > 0; fil--) {
				stringRow = stringRow.concat(getStringElem(fil, col + (stringArrayLength - fil)));
				stringRowReversed = stringRowReversed.concat(getStringElemReversed(fil, col + (stringArrayLength - fil)));
			}
			diagonalLines.add(stringRow);
			diagonalLines.add(stringRowReversed);
		}
		
	}

	private void resolveVerticalLines() {
		
		String stringRow = StringUtils.EMPTY;
		int stringArrayLength = stringArray.length;
		
		for (int col = 0; col < stringArrayLength; col++) {
			stringRow = StringUtils.EMPTY;
			for (int fil = 0; fil < stringArrayLength; fil++) {
				stringRow = stringRow.concat(getStringElem(fil, col));
			}
			verticalLines.add(stringRow);
		}
	}
	
	private String getStringElem(int fil, int col) {
		String stringRow = stringArray[fil];
		return stringRow.substring(col, col +1);
	}
	
	private String getStringElemReversed(int fil, int col) {
		StringBuilder stringBuilder = new StringBuilder(stringArray[fil]);
		return stringBuilder.reverse().substring(col, col +1);
	}

	public String[] getStringArray() {
		return stringArray;
	}

	@Override
	public List<String> getVerticalLines() {
		return verticalLines;
	}

	@Override
	public List<String> getHorizontalLines() {
		return horizontalLines;
	}
	
	@Override
	public List<String> getDiagonalLines() {
		return diagonalLines;
	}
	
}
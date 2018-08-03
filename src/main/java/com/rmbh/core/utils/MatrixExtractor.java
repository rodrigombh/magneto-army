package com.rmbh.core.utils;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class MatrixExtractor {
	
	private String[] stringArray;
	private ArrayList<String> verticalLines = new ArrayList<String>();
	private ArrayList<String> horizontalLines = new ArrayList<String>();
	private ArrayList<String> diagonalLeftToRightLines = new ArrayList<String>();
	private ArrayList<String> diagonalRightToLeftLines = new ArrayList<String>(); //TBD

	public MatrixExtractor(String[] stringArray) {
		this.stringArray = stringArray;
		extractLines();
	}

	private void extractLines() {
		
		int stringArrayLength = stringArray.length;
		String stringRow = StringUtils.EMPTY;
		String stringRowReversed = StringUtils.EMPTY;
		
		// Resolve Vertical Lines
		for (int col = 0; col < stringArrayLength; col++) {
			stringRow = StringUtils.EMPTY;
			for (int fil = 0; fil < stringArrayLength; fil++) {
				stringRow = stringRow.concat(getStringElem(fil, col));
			}
			verticalLines.add(stringRow);
		}
		
		// Resolve Diagonal Lines (1st Triangle)
		
		for (int fil = 0; fil < stringArrayLength; fil++) {
			stringRow = StringUtils.EMPTY;
			stringRowReversed = StringUtils.EMPTY;
			for (int col = 0; col <= fil; col++) {
				stringRow = stringRow.concat(getStringElem(fil - col, col));
				stringRowReversed = stringRowReversed.concat(getStringElemReversed(fil - col, col));
			}
			diagonalLeftToRightLines.add(stringRow);
			diagonalRightToLeftLines.add(stringRowReversed);
		}
		
		// Resolve Diagonal Lines (2do Triangle)
		for (int col = 0; col < stringArrayLength - 1; col++) {
			stringRow = StringUtils.EMPTY;
			stringRowReversed = StringUtils.EMPTY;
			for (int fil = stringArrayLength - 1; fil - col > 0; fil--) {
				stringRow = stringRow.concat(getStringElem(fil, col + (stringArrayLength - fil)));
				stringRowReversed = stringRowReversed.concat(getStringElemReversed(fil, col + (stringArrayLength - fil)));
			}
			diagonalLeftToRightLines.add(stringRow);
			diagonalRightToLeftLines.add(stringRowReversed);
		}
		
		// Resolve Horizonal  Lines
		horizontalLines = new ArrayList<>(Arrays.asList(stringArray));
		
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

	public ArrayList<String> getVerticalLines() {
		return verticalLines;
	}

	public ArrayList<String> getHorizontalLines() {
		return horizontalLines;
	}

	public ArrayList<String> getDiagonalLeftToRightLines() {
		return diagonalLeftToRightLines;
	}

	public ArrayList<String> getDiagonalRightToLeftLines() {
		return diagonalRightToLeftLines;
	}
	
}
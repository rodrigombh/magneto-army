package com.rmbh.core.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class MatrixExtractorTest {

	@Test
	public void test() {
		
		String[] stringArray = {
				"ABCDEFG", 
				"HIJKLMN", 
				"OPQRSTU", 
				"VWXYZAB", 
				"CDEFGHI", 
				"JKLMNOP", 
				"QRSTUVW"
		};
		
		MatrixExtractor matrixExtractor = new MatrixExtractor(stringArray);
		
		ArrayList<String> horizontalLines = matrixExtractor.getHorizontalLines();
		ArrayList<String> verticalLines = matrixExtractor.getVerticalLines();
		ArrayList<String> diagonalLeftToRightLines = matrixExtractor.getDiagonalLeftToRightLines();
		ArrayList<String> diagonalRightToLeftLines = matrixExtractor.getDiagonalRightToLeftLines();
		
		assertEquals(7, horizontalLines.size());
		assertEquals(7, verticalLines.size());
		assertEquals(13, diagonalLeftToRightLines.size());
		assertEquals(13, diagonalRightToLeftLines.size());
		
		assertTrue(horizontalLines.contains("ABCDEFG"));
		assertTrue(horizontalLines.contains("HIJKLMN"));
		assertTrue(horizontalLines.contains("OPQRSTU"));
		assertTrue(horizontalLines.contains("VWXYZAB"));
		assertTrue(horizontalLines.contains("CDEFGHI"));
		assertTrue(horizontalLines.contains("JKLMNOP"));
		assertTrue(horizontalLines.contains("QRSTUVW"));
		
		assertTrue(verticalLines.contains("AHOVCJQ"));
		assertTrue(verticalLines.contains("BIPWDKR"));
		assertTrue(verticalLines.contains("CJQXELS"));
		assertTrue(verticalLines.contains("DKRYFMT"));
		assertTrue(verticalLines.contains("ELSZGNU"));
		assertTrue(verticalLines.contains("FMTAHOV"));
		assertTrue(verticalLines.contains("GNUBIPW"));
		
		assertTrue(diagonalLeftToRightLines.contains("A"));
		assertTrue(diagonalLeftToRightLines.contains("HB"));
		assertTrue(diagonalLeftToRightLines.contains("OIC"));
		assertTrue(diagonalLeftToRightLines.contains("VPJD"));
		assertTrue(diagonalLeftToRightLines.contains("CWQKE"));
		assertTrue(diagonalLeftToRightLines.contains("JDXRLF"));
		assertTrue(diagonalLeftToRightLines.contains("QKEYSMG"));
		assertTrue(diagonalLeftToRightLines.contains("RLFZTN"));
		assertTrue(diagonalLeftToRightLines.contains("SMGAU"));
		assertTrue(diagonalLeftToRightLines.contains("TNHB"));
		assertTrue(diagonalLeftToRightLines.contains("UOI"));
		assertTrue(diagonalLeftToRightLines.contains("VP"));
		assertTrue(diagonalLeftToRightLines.contains("W"));
		
		assertTrue(diagonalRightToLeftLines.contains("G"));
		assertTrue(diagonalRightToLeftLines.contains("NF"));
		assertTrue(diagonalRightToLeftLines.contains("UME"));
		assertTrue(diagonalRightToLeftLines.contains("BTLD"));
		assertTrue(diagonalRightToLeftLines.contains("IASKC"));
		assertTrue(diagonalRightToLeftLines.contains("PHZRJB"));
		assertTrue(diagonalRightToLeftLines.contains("WOGYQIA"));
		assertTrue(diagonalRightToLeftLines.contains("VNFXPH"));
		assertTrue(diagonalRightToLeftLines.contains("UMEWO"));
		assertTrue(diagonalRightToLeftLines.contains("TLDV"));
		assertTrue(diagonalRightToLeftLines.contains("SKC"));
		assertTrue(diagonalRightToLeftLines.contains("RJ"));
		assertTrue(diagonalRightToLeftLines.contains("Q"));
	}

}

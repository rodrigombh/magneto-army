package com.rmbh.core.extractor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class MatrixExtractorImpTest {

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
		
		MatrixExtractorImp matrixExtractor = new MatrixExtractorImp(stringArray);
		
		List<String> horizontalLines = matrixExtractor.getHorizontalLines();
		List<String> verticalLines = matrixExtractor.getVerticalLines();
		List<String> diagonalLines = matrixExtractor.getDiagonalLines();
		
		assertEquals(7, horizontalLines.size());
		assertEquals(7, verticalLines.size());
		assertEquals(26, diagonalLines.size());
		
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
		
		assertTrue(diagonalLines.contains("A"));
		assertTrue(diagonalLines.contains("HB"));
		assertTrue(diagonalLines.contains("OIC"));
		assertTrue(diagonalLines.contains("VPJD"));
		assertTrue(diagonalLines.contains("CWQKE"));
		assertTrue(diagonalLines.contains("JDXRLF"));
		assertTrue(diagonalLines.contains("QKEYSMG"));
		assertTrue(diagonalLines.contains("RLFZTN"));
		assertTrue(diagonalLines.contains("SMGAU"));
		assertTrue(diagonalLines.contains("TNHB"));
		assertTrue(diagonalLines.contains("UOI"));
		assertTrue(diagonalLines.contains("VP"));
		assertTrue(diagonalLines.contains("W"));
		assertTrue(diagonalLines.contains("G"));
		assertTrue(diagonalLines.contains("NF"));
		assertTrue(diagonalLines.contains("UME"));
		assertTrue(diagonalLines.contains("BTLD"));
		assertTrue(diagonalLines.contains("IASKC"));
		assertTrue(diagonalLines.contains("PHZRJB"));
		assertTrue(diagonalLines.contains("WOGYQIA"));
		assertTrue(diagonalLines.contains("VNFXPH"));
		assertTrue(diagonalLines.contains("UMEWO"));
		assertTrue(diagonalLines.contains("TLDV"));
		assertTrue(diagonalLines.contains("SKC"));
		assertTrue(diagonalLines.contains("RJ"));
		assertTrue(diagonalLines.contains("Q"));
	}

}

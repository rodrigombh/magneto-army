package com.rmbh.core.dna;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.rmbh.core.analyzer.DnaAnalyzer;
import com.rmbh.core.analyzer.DnaAnalyzerImpl;

public class DnaAnalyzerImplTest {

	DnaAnalyzer dnaAnalyzer;
	
	@Before
	public void setup() {
		dnaAnalyzer = new DnaAnalyzerImpl();
	}
	
	@Test
	public void test_exampleGiven_true() {
		
		String[] dna = {
				"ATGCGA",
				"CAGTGC",
				"TTATGT",
				"AGAAGG",
				"CCCCTA",
				"TCACTG"
		};
		
		boolean isMutant = dnaAnalyzer.isMutant(dna);
		
		assertTrue(isMutant);
	}
	
	@Test
	public void test_exampleGiven_false() {
		
		String[] dna = {
				"ATGCGA", 
				"CAGTGC", 
				"TTATTT", 
				"AGACGG", 
				"GCGTCA", 
				"TCACTG"
		};
		
		boolean isMutant = dnaAnalyzer.isMutant(dna);
		
		assertFalse(isMutant);
	}
	
	@Test
	public void test_diagonaEdgelLeftToRightAndHorizontalBottom_true() {
		
		String[] dna = {
				"ATGCGA", 
				"CAGTAC", 
				"TTAATT", 
				"AGACGG", 
				"ACGTCA", 
				"TTTTTG"
		};
		
		boolean isMutant = dnaAnalyzer.isMutant(dna);
		
		assertTrue(isMutant);
	}
	
	@Test
	public void test_gerenic1_true() {
		
		String[] dna = {
				"ATGCGA", 
				"CAGTGA", 
				"TTATTA", 
				"AGACGA", 
				"GCGTCA", 
				"TTTTTG"
		};
		
		boolean isMutant = dnaAnalyzer.isMutant(dna);
		
		assertTrue(isMutant);
	}
	
	@Test
	public void test_gerenic2_true() {
		
		String[] dna = {
				"ATGCGA", 
				"AAGTGC", 
				"ATATTT", 
				"ATACGG", 
				"GTGTCA", 
				"TTACTG"
		};
		
		boolean isMutant = dnaAnalyzer.isMutant(dna);
		
		assertTrue(isMutant);
	}
	
	@Test
	public void test_bigger_false() {
		
		String[] dna = {
				"ATGCGACGT", 
				"CAGTGCAGT", 
				"TTATATTGA", 
				"AGACGGCTA", 
				"GCGTCATTA", 
				"TCACTGGAT",
				"GCGTCATTA",
				"CAGTGCAGT",
				"GCGTCATTA"
		};
		
		boolean isMutant = dnaAnalyzer.isMutant(dna);
		
		assertFalse(isMutant);
	}
	
	@Test
	public void test_twoConsecutivesSecOfSameLetter_true() {
		
		String[] dna = {
				"ATGCGACGT", 
				"CAGTGCAGT", 
				"TTATATTGT", 
				"AGACGGCTT", 
				"GCGTCATTT", 
				"TCACTGGAT",
				"GCGTCATTT",
				"CAGTGCAGT",
				"GCGTCATTT"
		};
		
		boolean isMutant = dnaAnalyzer.isMutant(dna);
		
		assertTrue(isMutant);
	}
	
	@Test
	public void test_diagonalLeftToRightAndVerticalOnSide_true() {
		
		String[] dna = {
				"ATGCGACGT", 
				"CAGTGCAGT", 
				"TTATATTGA",
				"AGACGGCTT", 
				"GCGTCATTA", 
				"ACACTGGAT",
				"GAGTCATTT",
				"CAATGCAGT",
				"GCGACATTT"
		};
		
		boolean isMutant = dnaAnalyzer.isMutant(dna);
		
		assertTrue(isMutant);
	}
	
	@Test
	public void test_bigger_true() {
		
		String[] dna = {
				"ATGCGACGT", 
				"CAGTGCAGT", 
				"TTATATTGA", 
				"AGATGGCTA", 
				"GCGTCATTA", 
				"TCACTGGAT",
				"GCGTCAATA",
				"CAGTGAAGT",
				"GCGTCATTA"
		};
		
		boolean isMutant = dnaAnalyzer.isMutant(dna);
		
		assertTrue(isMutant);
	}

}

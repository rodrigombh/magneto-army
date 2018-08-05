package com.rmbh.core.dna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DnaAnalyzerImpTest {

	DnaAnalyzer dnaAnalyzer;
	
	@BeforeEach
	public void setup() {
		dnaAnalyzer = new DnaAnalyzerImp();
	}
	
	@Test
	void test_exampleGiven_true() {
		
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
	void test_exampleGiven_false() {
		
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
	void test_diagonaEdgelLeftToRightAndHorizontalBottom_true() {
		
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
	void test_gerenic1_true() {
		
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
	void test_gerenic2_true() {
		
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
	void test_bigger_false() {
		
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
	void test_twoConsecutivesSecOfSameLetter_true() {
		
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
	void test_diagonalLeftToRightAndVerticalOnSide_true() {
		
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
	void test_bigger_true() {
		
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

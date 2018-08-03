package com.rmbh.core.dna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DnaAnalyzerSimpleImpTest {

	DnaAnalyzer dnaAnalyzer;
	
	@BeforeEach
	public void setup() {
		dnaAnalyzer = new DnaAnalyzerSimpleImp();
	}
	
	@Test
	void test() {
		
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
	void test2() {
		
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
	void test3() {
		
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
	void test4() {
		
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
	void test5() {
		
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
	void test6() {
		
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
	void test7() {
		
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
	
	@Test
	void test8() {
		
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
	void test9() {
		
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

}

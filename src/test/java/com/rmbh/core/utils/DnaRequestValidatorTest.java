package com.rmbh.core.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DnaRequestValidatorTest {

	@Test
	void isValid_true() {
		
		String[] dna = {
				"ATGCGA",
				"CAGTGC",
				"TTATGT",
				"AGAAGG",
				"CCCCTA",
				"TCACTG"
		};
		
		assertTrue(DnaRequestValidator.isValid(dna));
	}
	
	@Test
	void isValid_invalidLetter_false() {
		
		String[] dna = {
				"ATGCGA", 
				"CAGTGC", 
				"TTATTT", 
				"AGARGG", 
				"GCGTCA", 
				"TCACTG"
		};
		
		assertFalse(DnaRequestValidator.isValid(dna));
	}
	
	@Test
	void isValid_invalidSize_false() {
		
		String[] dna = {
				"ATGCGA",
				"CAGTGC",
				"TTATGT",
				"AGAAGG",
				"CCCCTA",
				"TCACT"
		};
		
		assertFalse(DnaRequestValidator.isValid(dna));
	}
	
	@Test
	void isValid_both_false() {
		
		String[] dna = {
				"ATGCGA",
				"CAGTGC",
				"TTATGT",
				"AGARGG",
				"CCCCTA",
				"TCACT"
		};
		
		assertFalse(DnaRequestValidator.isValid(dna));
	}
	
}

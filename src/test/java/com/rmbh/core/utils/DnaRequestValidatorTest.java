package com.rmbh.core.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DnaRequestValidatorTest {

	@Test
	public void isValid_true() {
		
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
	public void isValid_invalidLetter_false() {
		
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
	public void isValid_invalidSize_false() {
		
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
	public void isValid_both_false() {
		
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

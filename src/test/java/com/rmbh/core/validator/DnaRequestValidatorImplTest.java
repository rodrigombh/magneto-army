package com.rmbh.core.validator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DnaRequestValidatorImplTest {
	
	DnaRequestValidator dnaRequestValidator;
	
	@Before
	public void setup() {
		dnaRequestValidator = new DnaRequestValidatorImpl();
	} 

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
		
		assertTrue(dnaRequestValidator.isValid(dna));
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
		
		assertFalse(dnaRequestValidator.isValid(dna));
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
		
		assertFalse(dnaRequestValidator.isValid(dna));
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
		
		assertFalse(dnaRequestValidator.isValid(dna));
	}
}
	

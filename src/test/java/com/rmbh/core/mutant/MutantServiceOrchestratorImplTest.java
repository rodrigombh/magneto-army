package com.rmbh.core.mutant;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.rmbh.core.analyzer.DnaAnalyzer;
import com.rmbh.dao.DnaItemDAO;
import com.rmbh.models.DnaItem;

public class MutantServiceOrchestratorImplTest {

	MutantServiceOrchestratorImpl mutantService;
	
	@Mock
	DnaAnalyzer dnaAnalyzer;
	
	@Mock
	DnaItemDAO dnaItemDAO;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mutantService = new MutantServiceOrchestratorImpl(dnaAnalyzer, dnaItemDAO);
	}
	
	@Test
	public void isMutant_dnaAlreadyExist() {
		
		String[] dna = {
				"AT",
				"CA",
		};
		
		DnaItem dnaItem = new DnaItem("id", dna, true); 
		Mockito.when(dnaItemDAO.get(anyString())).thenReturn(dnaItem);
		
		boolean response = mutantService.isMutant(dna);
		
		verify(dnaItemDAO, never()).put(anyObject());
		assertTrue(response);
	}
	
	@Test
	public void isMutant_dnaNotExist() {
		
		String[] dna = {
				"AT",
				"CA",
		};
		
		Mockito.when(dnaItemDAO.get(anyString())).thenReturn(null);
		Mockito.when(dnaAnalyzer.isMutant(anyObject())).thenReturn(false);
		
		boolean response = mutantService.isMutant(dna);
		
		verify(dnaItemDAO, Mockito.times(1)).put(anyObject());
		assertFalse(response);
	}

}

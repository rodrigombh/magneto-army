package com.rmbh.api;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class StatsResponseTest {

	@Test
	public void test1() {
		StatsResponse statsResponse = new StatsResponse(40, 100);
		assertEquals(new BigDecimal("0.4"), statsResponse.getRatio());
	}
	
	@Test
	public void test2() {
		StatsResponse statsResponse = new StatsResponse(17, 9);
		assertEquals(new BigDecimal("1.9"), statsResponse.getRatio());
	}
	
	@Test
	public void test3() {
		StatsResponse statsResponse = new StatsResponse(0, 70);
		assertEquals(new BigDecimal("0.0"), statsResponse.getRatio());
	}
	
	@Test
	public void test4() {
		StatsResponse statsResponse = new StatsResponse(50, 0);
		assertNull(statsResponse.getRatio());
	}

}

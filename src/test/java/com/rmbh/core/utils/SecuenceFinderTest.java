package com.rmbh.core.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SecuenceFinderTest {

	@Test
	public void countEqualConsecutiveCharacters_count3() {

		List<Character> list = new ArrayList<Character>();
		list.add(new Character('A'));
		list.add(new Character('A'));
		list.add(new Character('A'));
		list.add(new Character('B'));

		int counter = SecuenceFinder.countEqualConsecutiveCharacters(list, new Character('A'));

		assertEquals(3, counter);
	}

	@Test
	public void countEqualConsecutiveCharacters_count2() {

		List<Character> list = new ArrayList<Character>();
		list.add(new Character('A'));
		list.add(new Character('A'));
		list.add(new Character('B'));

		int counter = SecuenceFinder.countEqualConsecutiveCharacters(list, new Character('A'));

		assertEquals(2, counter);
	}

	@Test
	public void countEqualConsecutiveCharacters_count1() {

		List<Character> list = new ArrayList<Character>();
		list.add(new Character('A'));
		list.add(new Character('B'));

		int counter = SecuenceFinder.countEqualConsecutiveCharacters(list, new Character('A'));

		assertEquals(1, counter);
	}

	@Test
	public void countEqualConsecutiveCharacters_nothing() {

		List<Character> list = new ArrayList<Character>();
		list.add(new Character('B'));

		int counter = SecuenceFinder.countEqualConsecutiveCharacters(list, new Character('A'));

		assertEquals(0, counter);
	}

	@Test
	public void countEqualConsecutiveCharacters_count4() {

		List<Character> list = new ArrayList<Character>();
		list.add(new Character('A'));
		list.add(new Character('A'));
		list.add(new Character('A'));
		list.add(new Character('A'));

		int counter = SecuenceFinder.countEqualConsecutiveCharacters(list, new Character('A'));

		assertEquals(4, counter);
	}
	
	@Test
	public void countSecuences_count1() {
		int counter = SecuenceFinder.countSecuences("AAAA");
		assertEquals(1, counter);
	}
	
	@Test
	public void countSecuences_nothing() {
		int counter = SecuenceFinder.countSecuences("AAA");
		assertEquals(0, counter);
	}
	
	@Test
	public void countSecuences_rightSide_found1() {
		int counter = SecuenceFinder.countSecuences("AABBBB");
		assertEquals(1, counter);
	}
	
	@Test
	public void countSecuences_rightSideBigger_found1() {
		int counter = SecuenceFinder.countSecuences("AABBBBB");
		assertEquals(1, counter);
	}
	
	@Test
	public void countSecuences_middle_found1() {
		int counter = SecuenceFinder.countSecuences("AABBBBAA");
		assertEquals(1, counter);
	}
	
	@Test
	public void countSecuences_consecutives_found2() {
		int counter = SecuenceFinder.countSecuences("AAAAAAAA");
		assertEquals(2, counter);
	}
	
	@Test
	public void countSecuences_consecutivesMoreLetters_found2() {
		int counter = SecuenceFinder.countSecuences("AAAAAAAAA");
		assertEquals(2, counter);
	}
	
	@Test
	public void countSecuences_onSide_found2() {
		int counter = SecuenceFinder.countSecuences("AAAAABBAAAAAA");
		assertEquals(2, counter);
	}
}

package com.rmbh.core.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class SecuenceFinderTest {

	@Test
	public void test1() {

		List<Character> list = new ArrayList<Character>();
		list.add(new Character('A'));
		list.add(new Character('A'));
		list.add(new Character('A'));
		list.add(new Character('B'));

		int counter = SecuenceFinder.countEqualConsecutiveCharacters(list, new Character('A'));

		assertEquals(3, counter);
	}

	@Test
	public void test2() {

		List<Character> list = new ArrayList<Character>();
		list.add(new Character('A'));
		list.add(new Character('A'));
		list.add(new Character('B'));

		int counter = SecuenceFinder.countEqualConsecutiveCharacters(list, new Character('A'));

		assertEquals(2, counter);
	}

	@Test
	public void test3() {

		List<Character> list = new ArrayList<Character>();
		list.add(new Character('A'));
		list.add(new Character('B'));

		int counter = SecuenceFinder.countEqualConsecutiveCharacters(list, new Character('A'));

		assertEquals(1, counter);
	}

	@Test
	public void test4() {

		List<Character> list = new ArrayList<Character>();
		list.add(new Character('B'));

		int counter = SecuenceFinder.countEqualConsecutiveCharacters(list, new Character('A'));

		assertEquals(0, counter);
	}

	@Test
	public void test5() {

		List<Character> list = new ArrayList<Character>();
		list.add(new Character('A'));
		list.add(new Character('A'));
		list.add(new Character('A'));
		list.add(new Character('A'));

		int counter = SecuenceFinder.countEqualConsecutiveCharacters(list, new Character('A'));

		assertEquals(4, counter);
	}
	
	@Test
	public void test6() {
		int counter = SecuenceFinder.countSecuences("AAAA");
		assertEquals(1, counter);
	}
	
	@Test
	public void test7() {
		int counter = SecuenceFinder.countSecuences("AAA");
		assertEquals(0, counter);
	}
	
	@Test
	public void test8() {
		int counter = SecuenceFinder.countSecuences("AABBBB");
		assertEquals(1, counter);
	}
	
	@Test
	public void test9() {
		int counter = SecuenceFinder.countSecuences("AABBBBB");
		assertEquals(1, counter);
	}
	
	@Test
	public void test10() {
		int counter = SecuenceFinder.countSecuences("AABBBBAA");
		assertEquals(1, counter);
	}
	
	@Test
	public void test11() {
		int counter = SecuenceFinder.countSecuences("AAAAAAAA");
		assertEquals(2, counter);
	}
	
	@Test
	public void test12() {
		int counter = SecuenceFinder.countSecuences("AAAAAAAAA");
		assertEquals(2, counter);
	}
	
	@Test
	public void test13() {
		int counter = SecuenceFinder.countSecuences("AAAAABBAAAAAA");
		assertEquals(2, counter);
	}
}

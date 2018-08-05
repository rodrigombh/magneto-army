package com.rmbh.core.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ListUtilsTest {

	@Test
	public void getHead() {
		List<Character> list = new ArrayList<Character>();
		list.add(new Character('A'));
		list.add(new Character('B'));
		list.add(new Character('C'));

		Character head = ListUtils.getHead(list);

		assertEquals(new Character('A'), head);
	}
	
	@Test
	public void getTail() {
		List<Character> list = new ArrayList<Character>();
		list.add(new Character('A'));
		list.add(new Character('B'));
		list.add(new Character('C'));

		List<Character> tail = ListUtils.getTail(list);

		assertEquals(2, tail.size());
		assertEquals(new Character('B'), tail.get(0));
		assertEquals(new Character('C'), tail.get(1));
	}

	@Test
	public void getTail_oneElem_noElems() {
		List<Character> list = new ArrayList<Character>();
		list.add(new Character('A'));

		List<Character> tail = ListUtils.getTail(list);

		assertEquals(0, tail.size());
	}

}

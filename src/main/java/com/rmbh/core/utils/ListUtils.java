package com.rmbh.core.utils;

import java.util.List;

public class ListUtils {

	public static Character getHead(List<Character> list) {
    return list.get(0);
	}

	public static List<Character> getTail(List<Character> list) {
	    return list.subList(1, list.size());
	}
}

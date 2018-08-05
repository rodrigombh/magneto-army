package com.rmbh.core.utils;

import java.util.List;

import com.google.common.collect.Lists;

public class SecuenceFinder {

	private static final int MIN_VALUE_FOR_VALID_SEC = 4;

	public static int countEqualConsecutiveCharacters(List<Character> charList, Character character) {
		
		if(!charList.isEmpty() && ListUtils.getHead(charList).equals(character) ) {
			return 1 + countEqualConsecutiveCharacters(ListUtils.getTail(charList), character);
		}
		
		return 0;
	}
	
	static public int countSecuences(String string) {
		
		List<Character> charList = Lists.charactersOf(string);
		
		int charListSize = charList.size();
		int secuenceCounter = 0;
		int index = 0;
		
		while(index < charListSize - 1) {
		
			int equalConsecutiveCharactersCounter = countEqualConsecutiveCharacters(charList.subList(index, charListSize), charList.get(index));
			
			secuenceCounter = secuenceCounter + Math.floorDiv(equalConsecutiveCharactersCounter, MIN_VALUE_FOR_VALID_SEC);
			
			index = index + equalConsecutiveCharactersCounter;
		}
		
		return secuenceCounter;
	}
	
}

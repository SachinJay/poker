package com.sachinjay.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.sachinjay.poker.Rank;

public class Constants
{
	/**
	 * Map from Rank to Int for comparison purposes
	 * 
	 */
	public static final Map<Rank, Integer> RANK_TO_INT;
	static
	{
		Map<Rank, Integer> aMap = new HashMap<Rank, Integer>();

		aMap.put(Rank.TWO, 2);
		aMap.put(Rank.THREE, 3);
		aMap.put(Rank.FOUR, 4);
		aMap.put(Rank.FIVE, 5);
		aMap.put(Rank.SIX, 6);
		aMap.put(Rank.SEVEN, 7);
		aMap.put(Rank.EIGHT, 8);
		aMap.put(Rank.NINE, 9);
		aMap.put(Rank.TEN, 10);
		aMap.put(Rank.JACK, 11);
		aMap.put(Rank.QUEEN, 12);
		aMap.put(Rank.KING, 13);
		aMap.put(Rank.ACE, 14);

		RANK_TO_INT = Collections.unmodifiableMap(aMap);
	}

	public static final int HAND_SIZE = 5;
	public static final String HAND_SIZE_MSG = "The Hand size must be " + HAND_SIZE;
}

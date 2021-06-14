package com.sachinjay.poker;

import org.apache.commons.lang3.SerializationUtils;

public class Hand
{
	/**
	 * Array of cards that makes up the hand
	 * 
	 * INVARIANT: hand.length == 5
	 */
	private Card[] hand;

	/**
	 * Constructor, sets the hand equal to the given array
	 * 
	 * @param hand teh given array of cards
	 */
	public void Hand(Card[] hand)
	{
		this.hand = SerializationUtils.clone(hand);
		if (this.hand.length != 5)
		{
			// TODO Come up with exception to throw
		}
	}
}

package com.sachinjay.poker;

import org.apache.commons.lang3.SerializationUtils;

import Utils.Constants;

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
	 * @param hand the given array of cards
	 * @throws HandSizeException
	 */
	public void Hand(Card[] hand) throws HandSizeException
	{
		this.hand = SerializationUtils.clone(hand);
		if (this.hand.length != 5)
		{
			throw new HandSizeException(Constants.HAND_SIZE_MSG);
		}
	}
}

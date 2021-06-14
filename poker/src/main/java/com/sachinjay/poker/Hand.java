package com.sachinjay.poker;

public class Hand
{
	/**
	 * Array of cards that makes up the hand
	 * 
	 * INVARIANT: hand.length == 5
	 */
	private Card[] hand;

	public void Hand(Card[] hand)
	{
		this.hand = hand;
	}
}

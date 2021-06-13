package com.sachinjay.poker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CardTest
{

	Card card;

	@Test
	public void testEmpty()
	{
		card = new Card();
		assertEquals(card.getRank(), Rank.ACE);
		assertEquals(card.getSuit(), Suit.SPADES);
	}

}

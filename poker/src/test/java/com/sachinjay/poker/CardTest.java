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

	@Test
	public void testRest()
	{
		for (Suit suit : Suit.values())
		{
			for (Rank rank : Rank.values())
			{
				card = new Card(rank, suit);

				assertEquals(rank, card.getRank());
				assertEquals(suit, card.getSuit());
			}
		}
	}

}

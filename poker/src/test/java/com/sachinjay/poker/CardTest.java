package com.sachinjay.poker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class CardTest
{

	Card card;
	Card card2 = new Card(Rank.SEVEN, Suit.SPADES);

	/**
	 * Test the card class's empty constructor
	 */
	@Test
	public void testEmptyConstructor()
	{
		card = new Card();
		assertEquals(card.getRank(), Rank.ACE);
		assertEquals(card.getSuit(), Suit.SPADES);
	}

	/**
	 * Test the constructor for the Card class that takes in arguments
	 */
	@Test
	public void testNonEmptyConstructor()
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

	/**
	 * Test that a card equals itself, regardless of suit
	 */
	@Test
	public void testCompare0()
	{
		card = new Card(Rank.SEVEN, Suit.CLUBS);
		assertEquals(0, card.compareTo(card));
		assertEquals(0, card.compareTo(card2));
	}

	/**
	 * Make sure other comparisions work
	 */
	@Test
	public void testCompareRest()
	{
		card = new Card(Rank.TWO, Suit.SPADES);
		assertEquals(-1, card.compareTo(card2));

		card = new Card(Rank.THREE, Suit.SPADES);
		assertEquals(-1, card.compareTo(card2));

		card = new Card(Rank.FOUR, Suit.SPADES);
		assertEquals(-1, card.compareTo(card2));

		card = new Card(Rank.FIVE, Suit.SPADES);
		assertEquals(-1, card.compareTo(card2));

		card = new Card(Rank.SIX, Suit.SPADES);
		assertEquals(-1, card.compareTo(card2));

		card = new Card(Rank.SEVEN, Suit.SPADES);
		assertEquals(0, card.compareTo(card2));

		card = new Card(Rank.EIGHT, Suit.SPADES);
		assertEquals(1, card.compareTo(card2));

		card = new Card(Rank.NINE, Suit.SPADES);
		assertEquals(1, card.compareTo(card2));

		card = new Card(Rank.TEN, Suit.SPADES);
		assertEquals(1, card.compareTo(card2));

		card = new Card(Rank.JACK, Suit.SPADES);
		assertEquals(1, card.compareTo(card2));

		card = new Card(Rank.QUEEN, Suit.SPADES);
		assertEquals(1, card.compareTo(card2));

		card = new Card(Rank.KING, Suit.SPADES);
		assertEquals(1, card.compareTo(card2));

		card = new Card(Rank.ACE, Suit.SPADES);
		assertEquals(1, card.compareTo(card2));
	}

	/**
	 * Make sure that an ace is not lower than a 2 (though technically this could be
	 * the case in a game)
	 */
	@Test
	public void testCompareFails()
	{
		card = new Card(Rank.ACE, Suit.SPADES);
		card2 = new Card(Rank.TWO, Suit.CLUBS);

		assertNotEquals(-1, card.compareTo(card2));
	}

}

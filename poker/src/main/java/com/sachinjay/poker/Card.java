package com.sachinjay.poker;

import com.sachinjay.utils.Constants;

public class Card implements Comparable<Card>
{
	private Rank rank;
	private Suit suit;

	public Card()
	{
		this.setRank(Rank.ACE);
		this.setSuit(Suit.SPADES);
	}

	public Card(Rank rank, Suit suit)
	{
		this.setRank(rank);
		this.setSuit(suit);
	}

	/**
	 * @return the suit
	 */
	public Suit getSuit()
	{
		return suit;
	}

	/**
	 * @param suit the suit to set
	 */
	public void setSuit(Suit suit)
	{
		this.suit = suit;
	}

	/**
	 * @return the rank
	 */
	public Rank getRank()
	{
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(Rank rank)
	{
		this.rank = rank;
	}

	@Override
	public int compareTo(Card card)
	{
		int diff = Constants.RANK_TO_INT.get(this.rank) - Constants.RANK_TO_INT.get(card.getRank());
		if (diff > 0) diff = 1;
		if (diff < 0) diff = -1;

		return diff;
	}

}

package com.sachinjay.poker;

import java.util.Arrays;

import org.apache.commons.lang3.SerializationUtils;

import com.sachinjay.utils.Constants;

public class Hand
{
	/**
	 * Array of cards that makes up the hand
	 * 
	 * INVARIANT: hand.length == 5
	 */
	private Card[] hand;

	private HandType handType;

	private Suit[] suits;
	private Integer[] ranks;

	/**
	 * Constructor, sets the hand equal to the given array of cards and sorts it
	 * 
	 * @param hand the given array of cards
	 * @throws HandSizeException if the Hand is not
	 *                           {@value Utils.Constants.#HAND_SIZE}
	 */
	public Hand(Card[] hand) throws HandSizeException
	{
		this.hand = SerializationUtils.clone(hand);
		if (this.hand.length != Constants.HAND_SIZE)
		{
			throw new HandSizeException(Constants.HAND_SIZE_MSG);
		}
		Arrays.sort(this.hand);

		for (int i = 0; i < this.hand.length; i++)
		{
			suits[i] = this.hand[i].getSuit();
			ranks[i] = Constants.RANK_TO_INT.get(this.hand[i].getRank());
		}
		setHandType();
	}

	private void setHandType()
	{
//		boolean isStraight = isStraight();
//		boolean isFlush = isFlush();
//
//		if (isStraight && isFlush)
//		{
//			// If the high card is an ace
//			if (this.ranks[this.ranks.length - 1] == 14)
//			{
//				this.handType = HandType.ROYAL_FLUSH;
//			}
//			else
//			{
//				this.handType = HandType.STRAIGHT_FLUSH;
//			}
//		}
//		// not a straight OR not a flush
//		else
//		{
//			if (isStraight) this.handType = HandType.STRAIGHT;
//			if (isFlush) this.handType = HandType.FLUSH;
//
//		}
//
//		if (!isStraight && !isFlush)
//		{
//			// gotta check for the two pair, full house, etc
//		}
//
//		// TODO set this.handType

		this.handType = null;
	}

	private boolean isStraight()
	{
		// Outlier where ace is used as a one
		if (this.ranks[0] == 14 && this.ranks[1] == 2 && this.ranks[2] == 3 && this.ranks[3] == 4 && this.ranks[4] == 5)
		{
			return true;
		}

		for (int i = 0; i < this.ranks.length - 1; i++)
		{
			if (this.ranks[i + 1] - this.ranks[i] != 1) return false;
		}

		return true;
	}

	private boolean isFlush()
	{
		Suit suit = hand[0].getSuit();

		for (Card card : hand)
		{
			if (card.getSuit() != suit) return false;
		}

		return true;
	}

	/**
	 * 
	 * @return the sorted Card array representing the hand
	 */
	public Card[] getHand()
	{
		return this.hand;
	}
}

package com.sachinjay.poker;

import java.util.Arrays;

import org.apache.commons.lang3.SerializationUtils;

import com.sachinjay.utils.Constants;
import com.sachinjay.utils.HandMethods;

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

	/**
	 * 
	 * @return the sorted Card array representing the hand
	 */
	public Card[] getHand()
	{
		return this.hand;
	}

	private void setHandType()
	{
		if (HandMethods.isRoyalFlush(this)) this.handType = HandType.ROYAL_FLUSH;
		if (HandMethods.isStraightFlush(this)) this.handType = HandType.STRAIGHT_FLUSH;
		if (HandMethods.isFourOfAKind(this)) this.handType = HandType.FOUR_OF_A_KIND;
		if (HandMethods.isFullHouse(this)) this.handType = HandType.FULL_HOUSE;
		if (HandMethods.isFlush(this)) this.handType = HandType.FLUSH;
		if (HandMethods.isStraight(this)) this.handType = HandType.STRAIGHT;
		if (HandMethods.isThreeOfAKind(this)) this.handType = HandType.THREE_OF_A_KIND;
		if (HandMethods.isTwoPair(this)) this.handType = HandType.TWO_PAIR;
		if (HandMethods.isPair(this)) this.handType = HandType.PAIR;
		if (HandMethods.isHighCard(this)) this.handType = HandType.HIGH_CARD;
	}
}

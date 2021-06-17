package com.sachinjay.utils;

import com.sachinjay.poker.Card;
import com.sachinjay.poker.Hand;
import com.sachinjay.poker.Rank;
import com.sachinjay.poker.Suit;

/**
 * Class containing methods used on hands. For these method purposes, a royal
 * flush IS a straight flush and a straight flush is both a straight and a flush
 * 
 * 
 * @author sachi
 *
 */
public class HandMethods
{

	public static boolean isRoyalFlush(Hand hand)
	{
		Card[] handArr = hand.getHand();
		return isStraightFlush(hand) && handArr[Constants.HAND_SIZE - 1].getRank() == Rank.ACE;
	}

	public static boolean isStraightFlush(Hand hand)
	{
		return isStraight(hand) && isFlush(hand);
	}

	public static boolean isFourOfAKind(Hand hand)
	{
		Card[] handArr = hand.getHand();

		// To be four of a kind in a sorted deck either the unmatched card is last or
		// first.
		// These are the two options
		boolean unmatchedCardIsLast = handArr[0].getRank() == handArr[Constants.HAND_SIZE - 2].getRank();

		boolean unmatchedCardIsFirst = handArr[1].getRank() == handArr[Constants.HAND_SIZE - 1].getRank();

		return unmatchedCardIsLast || unmatchedCardIsFirst;
	}

	public static boolean isFullHouse(Hand hand)
	{
		Card[] handArr = hand.getHand();

		// i.e. 3 of same rank then 2 of same rank
		boolean is3_2 = handArr[0].getRank() == handArr[2].getRank() && handArr[3].getRank() == handArr[4].getRank();

		// i.e. 2 of same rank then 3 of same rank
		boolean is2_3 = handArr[0].getRank() == handArr[1].getRank() && handArr[2].getRank() == handArr[4].getRank();

		return is3_2 || is2_3;
	}

	public static boolean isFlush(Hand hand)
	{
		Card[] handArr = hand.getHand();

		Suit suit = handArr[0].getSuit();

		for (Card card : handArr)
		{
			if (card.getSuit() != suit) return false;
		}

		return true;
	}

	public static boolean isStraight(Hand hand)
	{
		Card[] handArr = hand.getHand();
		// Outlier where ace is used as a one
		if (handArr[0].getRank() == Rank.ACE && handArr[1].getRank() == Rank.TWO && handArr[2].getRank() == Rank.THREE
				&& handArr[3].getRank() == Rank.FOUR && handArr[4].getRank() == Rank.FIVE)
		{
			return true;
		}

		for (int i = 0; i < handArr.length - 1; i++)
		{
			Rank r1 = handArr[i + 1].getRank();
			Rank r2 = handArr[i].getRank();
			if (Constants.RANK_TO_INT.get(r1) - Constants.RANK_TO_INT.get(r2) != 1) return false;
		}

		return true;
	}

	public static boolean isThreeOfAKind(Hand hand)
	{
		if (isFourOfAKind(hand) || isFullHouse(hand)) return false;

		Card[] handArr = hand.getHand();

		// i.e. the last 2 (cards 4 and 5) are unmatched
		boolean is4_5 = handArr[0].getRank() == handArr[2].getRank();

		// i.e. the first and last cards are unmatched
		boolean is1_5 = handArr[1].getRank() == handArr[3].getRank();

		// i.e. the first and second cards are unmatched
		boolean is1_2 = handArr[2].getRank() == handArr[4].getRank();

		return is4_5 || is1_5 || is1_2;
	}

	public static boolean isTwoPair(Hand hand)
	{
		if (isFourOfAKind(hand) || isFullHouse(hand)) return false;

		Card[] handArr = hand.getHand();

		// i.e. the unmatched card is first
		boolean is1 = handArr[1].getRank() == handArr[2].getRank() && handArr[3].getRank() == handArr[4].getRank();

		// i.e. the unmatched card is third
		boolean is3 = handArr[0].getRank() == handArr[1].getRank() && handArr[3].getRank() == handArr[4].getRank();

		// i.e. the unmatched card is last
		boolean is5 = handArr[0].getRank() == handArr[1].getRank() && handArr[2].getRank() == handArr[3].getRank();

		return is1 || is3 || is5;
	}

	public static boolean isPair(Hand hand)
	{

		if (isFourOfAKind(hand) || isFullHouse(hand) || isThreeOfAKind(hand) || isTwoPair(hand)) return false;

		Card[] handArr = hand.getHand();

		// Check 4 possible positions the pair could be

		// i.e. pair starts in first position etc.
		boolean is1 = handArr[0].getRank() == handArr[1].getRank();
		boolean is2 = handArr[1].getRank() == handArr[2].getRank();
		boolean is3 = handArr[2].getRank() == handArr[3].getRank();
		boolean is4 = handArr[3].getRank() == handArr[4].getRank();

		return is1 || is2 || is3 || is4;
	}

	public static boolean isHighCard(Hand hand)
	{
		return (!isFourOfAKind(hand) && !isFullHouse(hand) && !isFlush(hand) && !isStraight(hand)
				&& !isThreeOfAKind(hand) && !isTwoPair(hand) && !isPair(hand));
	}
}

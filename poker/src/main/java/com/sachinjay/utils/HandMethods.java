package com.sachinjay.utils;

import com.sachinjay.poker.Card;
import com.sachinjay.poker.Hand;
import com.sachinjay.poker.Rank;
import com.sachinjay.poker.Suit;

/**
 * Class containing methods used on hands.
 * 
 * 
 * @author sachi
 *
 */
public class HandMethods
{

	/**
	 * Checks if a hand is a royal flush
	 * 
	 * @param hand the hand in question
	 * @return true if the hand is a royal flush, else false
	 */
	public static boolean isRoyalFlush(Hand hand)
	{
		Card[] handArr = hand.getHand();
		return isIncreasing(hand) && allSameSuit(hand) && handArr[Constants.HAND_SIZE - 1].getRank() == Rank.ACE;
	}

	/**
	 * Checks is a hand is a straight flush
	 * 
	 * @param hand the hand
	 * @return whether the hand is a straight flush or not
	 */
	public static boolean isStraightFlush(Hand hand)
	{
		return !isRoyalFlush(hand) && isIncreasing(hand) && allSameSuit(hand);
	}

	/**
	 * Checks if a hand is a four of a kind
	 * 
	 * @param hand the hand
	 * @return whether or not the hand is a four of a kind
	 */
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

	/**
	 * Checks if a hand is a full house
	 * 
	 * @param hand the hand
	 * @return whether or not the hand is a full house
	 */
	public static boolean isFullHouse(Hand hand)
	{
		Card[] handArr = hand.getHand();

		// i.e. 3 of same rank then 2 of same rank
		boolean is3_2 = handArr[0].getRank() == handArr[2].getRank() && handArr[3].getRank() == handArr[4].getRank();

		// i.e. 2 of same rank then 3 of same rank
		boolean is2_3 = handArr[0].getRank() == handArr[1].getRank() && handArr[2].getRank() == handArr[4].getRank();

		return is3_2 || is2_3;
	}

	/**
	 * Checks if a hand is a flush
	 * 
	 * @param hand the hand
	 * @return whether or not the hand is a flush
	 */
	public static boolean isFlush(Hand hand)
	{
		return !isRoyalFlush(hand) && !isStraightFlush(hand) && allSameSuit(hand);
	}

	/**
	 * Checks if a hand is a straight
	 * 
	 * @param hand the hand
	 * @return whether or not the hand is a straight
	 */
	public static boolean isStraight(Hand hand)
	{
		return !isRoyalFlush(hand) && !isStraightFlush(hand) && isIncreasing(hand);
	}

	/**
	 * Checks if a hand is a three of a kind
	 * 
	 * @param hand the hand
	 * @return whether or not the hand is a three of a kind
	 */
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

	/**
	 * Checks if a hand is a two pair
	 * 
	 * @param hand the hand
	 * @return whether or not the hand is a two pair
	 */
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

	/**
	 * Checks if a hand is a pair
	 * 
	 * @param hand the hand
	 * @return whether or not the hand is a pair
	 */
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

	/**
	 * Checks if a hand is a high card
	 * 
	 * @param hand the hand
	 * @return whether or not the hand is a high card
	 */
	public static boolean isHighCard(Hand hand)
	{
		return (!isFourOfAKind(hand) && !isFullHouse(hand) && !isFlush(hand) && !isStraight(hand)
				&& !isThreeOfAKind(hand) && !isTwoPair(hand) && !isPair(hand));
	}

	public static boolean allSameSuit(Hand hand)
	{
		Card[] handArr = hand.getHand();

		Suit suit = handArr[0].getSuit();

		for (Card card : handArr)
		{
			if (card.getSuit() != suit) return false;
		}

		return true;
	}

	public static boolean isIncreasing(Hand hand)
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

	/**
	 * Gives a score to a specific hand. Hands with higher scores beat hands with
	 * lower scores. Hands with the same score tie
	 * 
	 * @param hand the hand to score
	 * @return the score of the hand
	 */
	public static int score(Hand hand)
	{
		// TODO: implement
		return 0;
	}
}

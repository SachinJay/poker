package com.sachinjay.utils;

import com.sachinjay.poker.Card;
import com.sachinjay.poker.Hand;
import com.sachinjay.poker.Rank;
import com.sachinjay.poker.Suit;

public class Utils
{
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

	private boolean isFlush(Hand hand)
	{
		Card[] handArr = hand.getHand();

		Suit suit = handArr[0].getSuit();

		for (Card card : handArr)
		{
			if (card.getSuit() != suit) return false;
		}

		return true;
	}
}

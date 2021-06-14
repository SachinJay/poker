package com.sachinjay.poker;

public class HandSizeException extends Exception
{
	/**
	 * This exception should be thrown if the size of the hand breaks the invariant
	 * 
	 * @param msg
	 */
	public HandSizeException(String msg)
	{
		super(msg);
	}
}

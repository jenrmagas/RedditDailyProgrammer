package com.ewenicorn.reddit.dailyprogrammer.utility;

public class Bytelandian {
	
	public static int exchangeToZeroCoins(int n) {
		return (n == 0) ? 1 : exchangeToZeroCoins(n/2) + exchangeToZeroCoins(n/3) + exchangeToZeroCoins(n/4);
	}
	
	public static int exchangeToThrees(int n) {
		return n/2 + n/3 + n/4;
	}
}

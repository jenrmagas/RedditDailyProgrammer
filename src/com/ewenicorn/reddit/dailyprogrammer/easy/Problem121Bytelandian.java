/**
 * http://redd.it/19mn2d
 * 
 * Each coin is converted to three coins, dividing the original code into 2, 3, and 4.
 * For example: 7 -> 3 (7/2), 2 (7/3), and 1 (7/4)
 * 
 * We want to continuously break the coins into lower value coins until we get back 0-value coins for all.
 * 
 * Example provided was converting one 7-valued coin to fifteen 0-valued coins.
 * Here's a tree of the progression:
 * 7
 * / | \
 * 3 2 1
 * / | \ / | \ /|\
 * 1 1 0 1 0 0 0 0 0
 * /|\ /|\ - /|\ - - - - -
 * 0 0 0 0 0 0 0 0 0
 * - - - - - - - - -
 * 
 * We continue breaking them apart until we hit a zero, at which point we can start counting the coins. Thus, we need
 * a recursive method that keeps calling itself until it is given a 0-valued coin, then returns a '1' to indicate that
 * it's gotten a matching coin.
 * 
 */
package com.ewenicorn.reddit.dailyprogrammer.easy;

import static com.ewenicorn.reddit.dailyprogrammer.utility.Bytelandian.exchangeToZeroCoins;

public class Problem121Bytelandian {

    public static void main(final String[] args) {
        System.out.println("Exchanging one 7-value coin: " + exchangeToZeroCoins(7)); // sample answer as provided
        System.out.println("Exchanging one 1000-value coin: " + exchangeToZeroCoins(1000));
    }

}

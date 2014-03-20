package net.ewenicorn.reddit.dailyprogrammer.utility;

public class Bytelandian {

    public static int exchangeToZeroCoins(final int n) {
        int result = 1;

        if (n != 0) {
            result = exchangeToZeroCoins(n / 2) + exchangeToZeroCoins(n / 3) + exchangeToZeroCoins(n / 4);
        }

        return result;
    }

    public static int exchangeToThrees(final int n) {
        return n / 2 + n / 3 + n / 4;
    }
}

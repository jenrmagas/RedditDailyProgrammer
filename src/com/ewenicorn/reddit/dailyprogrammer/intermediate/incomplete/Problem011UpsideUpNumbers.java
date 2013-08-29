package com.ewenicorn.reddit.dailyprogrammer.intermediate.incomplete;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * http://redd.it/pwox3
 * 
 * An “upside up” number is a number that reads the same when it is rotated
 * 180°. For instance, 689 and 1961 are upside up numbers. Your task is to find
 * the next upside up number greater than 1961, and to count the number of
 * upside up numbers less than ten thousand.
 * 
 * Edit: since there is a confusion about 2 and 5, please consider them as
 * "upside up" numbers for this problem. If you have already done without it,
 * its ok. Sorry for the late reply.
 * 
 */
public class Problem011UpsideUpNumbers {

    private static Map<Integer, Integer> upsideUpMap = setupUpsideUpMap();

    public static void main(final String[] args) {
        // todo
    }

    private static Map<Integer, Integer> setupUpsideUpMap() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        map.put(2, 5);
        map.put(5, 2);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        return Collections.unmodifiableMap(map);
    }

}

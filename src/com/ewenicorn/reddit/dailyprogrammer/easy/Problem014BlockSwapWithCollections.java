package com.ewenicorn.reddit.dailyprogrammer.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * http://redd.it/q2v2k
 * 
 * Input: list of elements and a block size k or some other variable of your choice
 * Output: return the list of elements with every block of k elements reversed, starting from the beginning of the list.
 * For instance, given the list 12, 24, 32, 44, 55, 66 and the block size 2, the result is 24, 12, 44, 32, 66, 55.
 * 
 * ----------------
 * 
 * Reworking problem using Java collections
 */
public class Problem014BlockSwapWithCollections {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        List<String> entries = new ArrayList<String>();
        List<String> sortedEntries = new ArrayList<String>();
        Comparator<String> reverseComparator = Collections.reverseOrder();

        try {
            System.out.print("Enter a space-delimited list of values: ");
            String rawInput = reader.readLine();
            for (String entry : rawInput.split(" ")) {
                entries.add(entry);
            }

            System.out.print("Enter a block size for which to reverse the entries: ");
            int blockSize = Integer.valueOf(reader.readLine());

            sortedEntries.addAll(reverseBlocks(entries, reverseComparator, blockSize));

            System.out.println(sortedEntries.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static List<String> reverseBlocks(final List<String> entries, final Comparator<String> reverseComparator,
            final int blockSize) {
        List<String> sortedEntries = new ArrayList<String>();
        for (int i = 0; i < entries.size(); i += blockSize) {
            int end;
            if (i + blockSize > entries.size()) {
                end = entries.size();
            } else {
                end = i + blockSize;
            }

            List<String> sublist = entries.subList(i, end);

            Collections.reverseOrder();
            Collections.sort(sublist, reverseComparator);
            sortedEntries.addAll(sublist);
        }

        return sortedEntries;

    }

}

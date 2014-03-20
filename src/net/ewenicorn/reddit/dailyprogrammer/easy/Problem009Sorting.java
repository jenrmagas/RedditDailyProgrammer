package net.ewenicorn.reddit.dailyprogrammer.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * http://redd.it/pu1rf
 * 
 * Write a program that will allow the user to input digits, and arrange them in numerical order.
 * for extra credit, have it also arrange strings in alphabetical order
 * 
 */
public class Problem009Sorting {

    public static void main(final String[] args) {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        List<Integer> items = new ArrayList<Integer>();

        try {
            System.out.print("Enter a list of values to be sorted (separated by space): ");

            String rawList = reader.readLine();
            for (String item : rawList.split(" ")) {
                items.add(Integer.valueOf(item));
            }

            Collections.sort(items);
            System.out.println(items);
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

    }
}

package com.ewenicorn.reddit.dailyprogrammer.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Problem013DayOfYear {

    public static void main(final String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));

        try {
            System.out.print("To determine the day of the year, enter the date in the format of YYYY/MM/DD: ");
            String[] rawDate = reader.readLine().split("/");
            Calendar cal = Calendar.getInstance();
            cal.clear();
            cal.set(Integer.valueOf(rawDate[0]), Integer.valueOf(rawDate[1]) - 1, Integer.valueOf(rawDate[2]));
            System.out.println("The provided date is day " + cal.get(Calendar.DAY_OF_YEAR) + " of the year.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

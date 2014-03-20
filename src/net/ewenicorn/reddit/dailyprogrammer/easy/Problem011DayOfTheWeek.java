package net.ewenicorn.reddit.dailyprogrammer.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * http://redd.it/pwons
 * 
 * The program should take three arguments. The first will be a day, the second will be month, and the third will be
 * year. Then, your program should compute the day of the week that date will fall on.
 * 
 */
public class Problem011DayOfTheWeek {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        int day, mon, year;
        Calendar targetDate;
        try {
            System.out.println("Based on the day, month, and year provided, " +
                    "you can find out what day of the week it is.\n");

            System.out.print("Enter the year (format of YYYY): ");
            year = Integer.valueOf(reader.readLine());
            System.out.print("Enter the month (format of MM): ");
            mon = Integer.valueOf(reader.readLine()) - 1; // Accommodate zero-based months
            System.out.print("Enter the day (format of D or DD): ");
            day = Integer.valueOf(reader.readLine());

            targetDate = new GregorianCalendar(year, mon, day);
            System.out.println("The date provided occurred on a " + formatter.format(targetDate.getTime()));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}

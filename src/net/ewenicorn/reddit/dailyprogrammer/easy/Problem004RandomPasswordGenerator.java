package net.ewenicorn.reddit.dailyprogrammer.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * http://redd.it/pm6oj
 * 
 * "You're challenge for today is to create a random password generator!
 * For extra credit, allow the user to specify the amount of passwords to generate.
 * For even more extra credit, allow the user to specify the length of the strings he wants to generate!"
 * 
 * Personal added challenge: provide a mechanism for requiring that the first letter is a letter
 * 
 */
public class Problem004RandomPasswordGenerator {

    // valid range of ascii characters for password inclusion
    static final int rangeStart = 33;
    static final int rangeAlphaStart = 65;
    static final int rangeEnd = 126;

    public static void main(final String[] args) {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        try {
            System.out.println("Random Password Generator:\n\n");
            System.out.print("Password Length: ");
            int length = Integer.valueOf(reader.readLine());

            System.out.print("Does the first character need to be a letter? (true / false) > ");
            boolean letterFirst = Boolean.valueOf(reader.readLine());

            System.out.print("Number of passwords generated: ");
            int count = Integer.valueOf(reader.readLine());

            for (int i = 0; i < count; i++) {
                System.out.println(generatedPassword(length, letterFirst));
            }

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    private static String generatedPassword(final int length, final boolean letterFirst) {
        String pw = "";

        if (letterFirst) {
            char ch = ' ';
            do {
                ch = (char) (new Random().nextInt(rangeEnd - rangeAlphaStart) + rangeAlphaStart);
            } while (!Character.isLetter(ch));
            pw += ch;
        }

        while (pw.length() < length) {
            // limits to only getting an int equivalent to the ascii range
            pw += (char) (new Random().nextInt(rangeEnd - rangeStart) + rangeStart);
        }

        return pw;
    }

}

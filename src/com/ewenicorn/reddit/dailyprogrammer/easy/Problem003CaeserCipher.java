package com.ewenicorn.reddit.dailyprogrammer.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ewenicorn.reddit.dailyprogrammer.utility.StringUtility;

/**
 * http://redd.it/pkw2m
 * 
 * Since the question is pretty open-ended here, I decided to infer a few requirements:
 * - The can specify the shift distance, and go both directions
 * - When a character overflows (i.e., from a backwards into z), the case should stay the same
 * - Only letters are to be shifted, not numbers or punctuation
 * 
 * Utility Methods created for this problem:
 * 
 * - CharacterUtility:
 * - shiftCharacter
 * - shiftLeft
 * - shiftRight
 * 
 * - StringUtility
 * - caeserShiftString
 * 
 */
public class Problem003CaeserCipher {

    public static void main(final String[] args) {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.print("Enter a value to be encrypted: > ");
        try {
            String orig = reader.readLine();
            System.out.print("What number seed would you like to use to encrypt it? > ");
            int seed = Integer.valueOf(reader.readLine());

            String encrypted = encryptString(orig, seed);
            System.out.println("Encrypted value: " + encrypted);

            String decrypted = decryptString(encrypted, seed);
            System.out.println("Decrypted value: " + decrypted);

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    private static String encryptString(final String orig, final int shiftDistance) {
        return StringUtility.caeserShiftString(orig, shiftDistance, true);
    }

    private static String decryptString(final String orig, final int shiftDistance) {
        return StringUtility.caeserShiftString(orig, shiftDistance, false);
    }
}

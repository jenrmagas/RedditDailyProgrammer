package com.ewenicorn.reddit.dailyprogrammer.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * http://redd.it/pr2xr :
 * 
 * Write a program that can translate Morse code in the format of ...---... A
 * space and a slash will be placed between words. ..- / --.- For bonus, add the
 * capability of going from a string to Morse code. Super-bonus if your program
 * can flash or beep the Morse. This is your Morse to translate:
 * 
 * .... . .-.. .-.. --- / -.. .- .. .-.. -.-- / .--. .-. --- --. .-. .- -- -- .
 * .-. / --. --- --- -.. / .-.. ..- -.-. -.- / --- -. / - .... . / -.-. .... .-
 * .-.. .-.. . -. --. . ... / - --- -.. .- -.--
 * 
 * Translation: "HELLO DAILY PROGRAMMER GOOD LUCK ON THE CHALLENGES TODAY"
 * 
 * Personal Challenge: Update to take any input from end user and convert in
 * either direction.
 * 
 */
public class Problem007MorseCode {

    public static void main(final String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));

        while (true) {
            try {
                System.out
                        .print("Would you like to *encode* or *decode*? (Type one, or *exit* to quit): ");
                String choice = reader.readLine();
                if ("encode".equals(choice.toLowerCase())) {
                    System.out.print("Enter the text to be encoded: ");
                    String orig = reader.readLine();
                    System.out.println("Encoded result: ");
                    System.out.println(encodeMessage(orig.toUpperCase()));
                } else if ("decode".equals(choice.toLowerCase())) {
                    System.out.print("Enter the text to be decoded: ");
                    String orig = reader.readLine();
                    System.out.println("Decoded result: ");
                    System.out.println(decodeMessage(orig.toUpperCase()));
                } else if ("exit".equals(choice.toLowerCase())) {
                    break;
                }
            } catch (Exception ex) {
                System.out.println(ex.getStackTrace());
            }
        }
    }

    private static String encodeMessage(final String message) {
        String encoded = "";

        for (String word : Arrays.asList(message.split(" "))) {
            for (char letter : word.toCharArray()) {
                encoded += encodeLetter(letter) + " ";
            }
            encoded += "/ ";
        }
        return encoded.substring(0, encoded.length() - 3);
    }

    private static String decodeMessage(final String message) {
        String decoded = "";

        for (String word : Arrays.asList(message.split(" / "))) {
            for (String code : Arrays.asList(word.split(" "))) {
                decoded += decodeLetter(code);
            }
            decoded += " ";
        }

        return decoded;
    }

    private static String encodeLetter(final Character letter) {
        String encoded = "";

        if (getMorseMap().containsKey(letter)) {
            encoded = getMorseMap().get(letter);
        }

        return encoded;
    }

    private static Character decodeLetter(final String code) {
        Character ch = null;

        if (getMorseMap().containsValue(code)) {
            for (Entry<Character, String> entry : getMorseMap().entrySet()) {
                if (entry.getValue().equals(code)) {
                    ch = entry.getKey();
                    break;
                }
            }
        }

        return ch;
    }

    private static Map<Character, String> getMorseMap() {
        Map<Character, String> morseMap = new HashMap<Character, String>();
        morseMap.put('A', ".-");
        morseMap.put('B', "-...");
        morseMap.put('C', "-.-.");
        morseMap.put('D', "-..");
        morseMap.put('E', ".");
        morseMap.put('F', "..-.");
        morseMap.put('G', "--.");
        morseMap.put('H', "....");
        morseMap.put('I', "..");
        morseMap.put('J', ".---");
        morseMap.put('K', "-.-");
        morseMap.put('L', ".-..");
        morseMap.put('M', "--");
        morseMap.put('N', "-.");
        morseMap.put('O', "---");
        morseMap.put('P', ".--.");
        morseMap.put('Q', "--.-");
        morseMap.put('R', ".-.");
        morseMap.put('S', "...");
        morseMap.put('T', "-");
        morseMap.put('U', "..-");
        morseMap.put('V', "...-");
        morseMap.put('W', ".--");
        morseMap.put('X', "-..-");
        morseMap.put('Y', "-.--");
        morseMap.put('Z', "--..");
        morseMap.put('0', "-----");
        morseMap.put('1', ".----");
        morseMap.put('2', "..---");
        morseMap.put('3', "...--");
        morseMap.put('4', "....-");
        morseMap.put('5', ".....");
        morseMap.put('6', "-....");
        morseMap.put('7', "--...");
        morseMap.put('8', "---..");
        morseMap.put('9', "----.");

        return morseMap;
    }

}

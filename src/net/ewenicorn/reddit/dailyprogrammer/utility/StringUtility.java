package net.ewenicorn.reddit.dailyprogrammer.utility;

public class StringUtility {

    public static String caeserShiftString(final String orig, final int shiftDistance, final boolean shiftRight) {
        String translated = new String();
        for (int i = 0; i < orig.length(); i++) {
            String shifted = CharacterUtility.shiftCharacter(orig.charAt(i), shiftDistance, shiftRight).toString();
            translated += shifted;
        }
        return translated;
    }
}

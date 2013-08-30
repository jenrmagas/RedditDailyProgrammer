package com.ewenicorn.reddit.dailyprogrammer.utility;

public class CharacterUtility {

    public static Character shiftCharacter(final Character orig, final int shiftDistance, final boolean shiftRight) {
        int actualShiftDistance = shiftDistance % 26;
        char shifted = orig;

        int singleMove = 1;
        if (!shiftRight) {
            singleMove = -1;
        }

        if (Character.isLetter(orig)) {
            for (int i = 0; i < actualShiftDistance; i++) {
                shifted += singleMove;
                if (!Character.isLetter(shifted)) {
                    if (shiftRight) {
                        shifted = (char) (shifted - 26);
                    } else {
                        shifted = (char) (shifted + 26);
                    }

                }
            }
        }

        return shifted;
    }

    public static Character shiftLeft(final Character orig, final int shiftDistance) {
        return shiftCharacter(orig, shiftDistance, false);
    }

    public static Character shiftRight(final Character orig, final int shiftDistance) {
        return shiftCharacter(orig, shiftDistance, true);
    }

    public static boolean equalsIgnoreCase(final Character orig, final Character compare) {
        return orig.compareTo(Character.toLowerCase(compare)) == 0
                || orig.compareTo(Character.toUpperCase(compare)) == 0;
    }

}

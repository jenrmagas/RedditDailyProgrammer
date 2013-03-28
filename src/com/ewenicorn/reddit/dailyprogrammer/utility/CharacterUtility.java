package com.ewenicorn.reddit.dailyprogrammer.utility;

public class CharacterUtility {
	
	public static Character shiftCharacter(Character orig, int shiftDistance, boolean shiftRight) {
		shiftDistance = shiftDistance  % 26;
		char shifted = orig;
		int singleMove = shiftRight ? 1 : -1;

		if(Character.isLetter(orig)) {
			for(int i = 0; i < shiftDistance; i++) {
				shifted += singleMove;
				if(!Character.isLetter(shifted)) {
					shifted = (char) (shiftRight ? shifted - 26 : shifted + 26);
				}
			}
		}
		
		return shifted;
	}
	
	public static Character shiftLeft(Character orig, int shiftDistance) {
		return shiftCharacter(orig, shiftDistance, false);
	}
	
	public static Character shiftRight(Character orig, int shiftDistance) {
		return shiftCharacter(orig, shiftDistance, true);
	}
	
	public static boolean equalsIgnoreCase(Character orig, Character compare) {
		return orig.compareTo(Character.toLowerCase(compare)) == 0 ||
				orig.compareTo(Character.toUpperCase(compare)) == 0;
	}
	
}

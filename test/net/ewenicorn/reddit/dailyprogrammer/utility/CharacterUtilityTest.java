package net.ewenicorn.reddit.dailyprogrammer.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CharacterUtilityTest {

    @Test
    public void testEqualsIgnoreCase() {
        assertTrue(CharacterUtility.equalsIgnoreCase('a', 'A'));
        assertTrue(CharacterUtility.equalsIgnoreCase('A', 'A'));
        assertFalse(CharacterUtility.equalsIgnoreCase('A', 'z'));
    }

    @Test
    public void testShiftCharacter() {
        // typical left/right shifts
        assertEquals(new Character('e'), CharacterUtility.shiftCharacter('d', 1, true));
        assertEquals(new Character('c'), CharacterUtility.shiftCharacter('d', 1, false));

        // wrapping right shifts
        assertEquals(new Character('a'), CharacterUtility.shiftCharacter('z', 1, true));
        assertEquals(new Character('A'), CharacterUtility.shiftCharacter('Z', 1, true));

        // wrapping left shifts
        assertEquals(new Character('z'), CharacterUtility.shiftCharacter('a', 1, false));
        assertEquals(new Character('Z'), CharacterUtility.shiftCharacter('A', 1, false));
    }

}

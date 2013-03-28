package com.ewenicorn.reddit.dailyprogrammer.utility;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilityTest {

	@Test
	public void testCaeserShiftString() {
		String orig = "Testing, testing, one two three!";
		String expected = "Bmabqvo, bmabqvo, wvm bew bpzmm!";
		assertEquals(expected, StringUtility.caeserShiftString(orig, 8, true));
		
		assertEquals(orig, StringUtility.caeserShiftString(expected, 8, false));
	}

}

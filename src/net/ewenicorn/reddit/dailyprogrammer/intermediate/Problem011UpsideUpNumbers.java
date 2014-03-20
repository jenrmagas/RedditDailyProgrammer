package net.ewenicorn.reddit.dailyprogrammer.intermediate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * http://redd.it/pwox3
 * 
 * An "upside up" number is a number that reads the same when it is rotated
 * 180°. For instance, 689 and 1961 are upside up numbers. Your task is to find
 * the next upside up number greater than 1961, and to count the number of
 * upside up numbers less than ten thousand.
 * 
 * Edit: since there is a confusion about 2 and 5, please consider them as
 * "upside up" numbers for this problem. If you have already done without it,
 * its ok. Sorry for the late reply.
 * 
 */
public class Problem011UpsideUpNumbers {

	public static void main(String[] args) {
		UpsideUpNumber specificNumber = new UpsideUpNumber(1961);
		System.out.println("The next upside up number after 1961 is " + specificNumber.getNextUpsideUpNumber());
		
		UpsideUpNumber number = new UpsideUpNumber();
		int counter = 0;
		
		// making sure to get a count increase for the first value
		do {
			counter++;
		} while(number.getNextUpsideUpNumber() < 10000);
		
		System.out.println("Total count of upside up numbers: " + counter);
	}
}

class UpsideUpNumber {

	private int upsideUpNumberValue;
	private Map<Integer, Integer> upsideUpMap = setupUpsideUpMap();
	
	/** Default constructor starts at 0 **/
	public UpsideUpNumber() {
		upsideUpNumberValue = 0;
	}
	
	public UpsideUpNumber(int lastUpsideUpNumber) {
		upsideUpNumberValue = lastUpsideUpNumber;
	}
	
	private final Map<Integer, Integer> setupUpsideUpMap() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 0);
		map.put(1, 1);
		map.put(2, 5);
		map.put(5, 2);
		map.put(6, 9);
		map.put(8, 8);
		map.put(9, 6);
		return Collections.unmodifiableMap(map);
	}
	
	public int getNextUpsideUpNumber() {
		do {
			upsideUpNumberValue++;
		} while(!isUpsideUp(upsideUpNumberValue));
		
		return getUpsideUpNumberValue();
	}
	
	private boolean isUpsideUp(int number) {
		int tempNumber = number;
		String upsideUpValue = "";
		
		do {
			int temp = tempNumber % 10;
			tempNumber = tempNumber / 10;
			
			if(upsideUpMap.containsKey(temp)) {
				upsideUpValue += upsideUpMap.get(temp);
			}
		} while(tempNumber > 0);
		
		return upsideUpValue != "" && number == Integer.parseInt(upsideUpValue);
	}

	public int getUpsideUpNumberValue() {
		return upsideUpNumberValue;
	}
}

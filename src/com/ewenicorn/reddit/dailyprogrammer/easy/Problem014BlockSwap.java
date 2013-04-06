package com.ewenicorn.reddit.dailyprogrammer.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * http://redd.it/q2v2k
 * 
 * Input: list of elements and a block size k or some other variable of your choice
 * Output: return the list of elements with every block of k elements reversed, starting from the beginning of the list.
 * For instance, given the list 12, 24, 32, 44, 55, 66 and the block size 2, the result is 24, 12, 44, 32, 66, 55.
 * 
 * ----------------
 * 
 * Working through logic:
 * 
 * Example:
 * 		Input:
 * 		> List:			1 2 3 4 5 6
 * 		> Block Size:	3
 * 
 * 		Output:
 * 		> 3 2 1 6 5 4
 * 
 * Indexes:	 0 1 2 3 4 5
 * Modified: 2 1 0 5 4 3
 * 
 * Index Logic:
 * 				0 -> 2 = 3 - 1		1 => (0 % 3) + 1
 * 				1 -> 1 = 3 - 2		2 => (1 % 3) + 1
 * 				2 -> 0 = 3 - 3		3 => (2 % 3) + 1
 * 				3 -> 5 = 6 - 1		1 => (3 % 3) + 1
 * 				4 -> 4 = 6 - 2		2 => (4 % 3) + 1
 * 				5 -> 3 = 6 - 3		3 => (5 % 3) + 1
 * 
 */
public class Problem014BlockSwap {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		
		try {
			System.out.print("Enter a space-delimited list of values: ");
			String[] list = reader.readLine().split(" ");
			System.out.print("Enter a block size for which to reverse the entries: ");
			int blockSize = Integer.valueOf(reader.readLine());
			
			String[] reorderedList = new String[list.length];
			int pos = 0;
			for(int i = 0; pos < list.length; i++) {
				int multiple = ((i+blockSize) / blockSize) * blockSize;
				int modifier = ((i % blockSize) + 1);
				if((multiple - modifier) < list.length) {
					reorderedList[pos++] = list[multiple - modifier];
				}
			}
			
			for(String item : reorderedList) {
				System.out.print(item + " ");
			}
		} catch(Exception ex) {
			System.out.println("Error occurred:");
			ex.printStackTrace();
		}
	}

}

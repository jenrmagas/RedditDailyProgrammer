package net.ewenicorn.reddit.dailyprogrammer.difficult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * http://redd.it/pii6j
 * 
 * We all know the classic "guessing game" with higher or lower prompts. lets do a role reversal; 
 * you create a program that will guess numbers between 1-100, and respond appropriately based on 
 * whether users say that the number is too high or too low. Try to make a program that can guess your 
 * number based on user input and great code!
 *
 */
public class Problem001GuessingGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int top = 100;
		int bottom = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		GuessingGame guesser = new GuessingGame(bottom, top);

		// instructions to the user
		System.out.println("Welcome to the Guessing Game! Pick a number between "); 
		System.out.println(bottom + " and " + top + ", then let the computer try to guess it! ");
		System.out.println("Any time the computer is too low, type 'Higher', and if the computer is too high, ");
		System.out.println("type 'Lower'. Once the computer guesses correctly, type 'Correct' and you'll find ");
		System.out.println("out exactly how long it took the computer to guess!");
		System.out.print("\nPress enter when you've picked your number: ");
		
		try {
			reader.readLine();

			while(!guesser.isMatchFound()) {
				System.out.println("The computer guesses " + guesser.guess() );
				System.out.print("Higher, lower, or correct? ");
				guesser.getFeedback(reader.readLine());
			}
			
			System.out.println(guesser.showResults());
		} catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}

class GuessingGame {
	
	private int bottom;
	private int top;
	private int guess;
	private int count = 0;
	private ArrayList<Integer> historicGuesses = new ArrayList<Integer>();
	private boolean found = false;
	
	public GuessingGame(int bottom, int top) {
		this.bottom = bottom;
		this.top = top;
	}
	
	public int guess() {
		Random random = new Random();
		guess = random.nextInt(top-bottom) + bottom;

		count++;
		return guess;
	}
	
	public void getFeedback(String feedback) {
		if(feedback.equalsIgnoreCase("correct")) {
			found = true;
		} else {
			historicGuesses.add(guess);
			if(feedback.equalsIgnoreCase("higher")) {
				bottom = guess + 1;
			} else if(feedback.equalsIgnoreCase("lower")) {
				top = guess;
			}
		}
	}
	
	public String showResults() {
		String results = "It took " + count + " guesses to determine your number. Before " + guess + 
				", the computer also tried ";
		
		for(Integer number : historicGuesses) {
			results += number + ", ";
		}
		
		return results.substring(0, results.lastIndexOf(','));
	}
	
	public boolean isMatchFound() {
		return found;
	}
}

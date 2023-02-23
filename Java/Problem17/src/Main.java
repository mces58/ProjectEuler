import java.util.HashMap;
import java.util.Map;

/*
@author: mces58

Problem 17
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.

Answer: 21124
*/

public class Main {
	public static void main(String[] args) {
		// Calculate the total number of letters in the word forms of the numbers from 1 to 1000
		int totalLetters = 0;
		for (int i = 1; i <= 1000; i++) {
			totalLetters += numberLetters(i);
		}

		System.out.println(totalLetters);
	}
	
	// This dictionary maps numbers to their word forms, which we will use to calculate the total letter count
	private static final Map<Integer, String> numberWord = new HashMap<Integer, String>() {
		private static final long serialVersionUID = 1L;
		{
			put(0, "");
			put(1, "one");
			put(2, "two");
			put(3, "three");
			put(4, "four");
			put(5, "five");
			put(6, "six");
			put(7, "seven");
			put(8, "eight");
			put(9, "nine");
			put(10, "ten");
			put(11, "eleven");
			put(12, "twelve");
			put(13, "thirteen");
			put(14, "fourteen");
			put(15, "fifteen");
			put(16, "sixteen");
			put(17, "seventeen");
			put(18, "eighteen");
			put(19, "nineteen");
			put(20, "twenty");
			put(30, "thirty");
			put(40, "forty");
			put(50, "fifty");
			put(60, "sixty");
			put(70, "seventy");
			put(80, "eighty");
			put(90, "ninety");
			put(100, "hundred");
			put(1000, "onethousand");
		}
	};

	// This function calculates the number of letters in the word form of a given number
	public static int numberLetters(int num) {
		if (num == 1000) {
			return numberWord.get(num).length();
		}

		// Initialize variables to represent the ones, tens, and hundreds digits of the number
		int ones = num % 10;
		int tens = (num / 10) % 10;
		int hundreds = (num / 100) % 10;

		// Calculate the number of letters in the word form of the number
		int letterCount = 0;
		if (hundreds > 0) {
			letterCount += numberWord.get(hundreds).length() + numberWord.get(100).length();
			if (tens > 0 || ones > 0) {
				letterCount += 3; // add the number of letters in 'and'
			}
		}
		if (tens == 1) {
			letterCount += numberWord.get(tens * 10 + ones).length();
		} else {
			letterCount += numberWord.get(tens * 10).length() + numberWord.get(ones).length();
		}
		return letterCount;
	}
}

/*
@author: mces58

Problem 36
The decimal number, 585 = (1001001001)2 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)

Answer: 872187
*/

public class Main {
	public static void main(String[] args) {
		int limit = 1000000;
		int result = doubleBasePalindromes(limit);
		System.out.println(result);
	}

	// Function to check if a string is a palindrome
	public static boolean isPalindrome(String s) {
		return s.equals(new StringBuilder(s).reverse().toString());
	}

	// Function to find the sum of double-base palindromes below the given limit
	public static int doubleBasePalindromes(int limit) {
		int total = 0;
		for (int number = 1; number < limit; number++) {
			// Convert the number to its decimal and binary string representations
			String decimalRepresentation = Integer.toString(number);
			String binaryRepresentation = Integer.toBinaryString(number);

			// Check if both representations are palindromes
			if (isPalindrome(decimalRepresentation) && isPalindrome(binaryRepresentation)) {
				total += number;
			}
		}
		return total;
	}
}

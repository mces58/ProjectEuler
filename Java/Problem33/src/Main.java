/*
@author: mces58

Problem 33
The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.

Answer: 100
*/

public class Main {
	public static void main(String[] args) {
		int numeratorProduct = 1; // numeratorProduct variable stores the product of all numerators of the curious fractions
		int denominatorProduct = 1; // denominatorProduct variable stores the product of all denominators of the curious fractions

		for (int i = 10; i < 100; i++) { // iterate over all two-digit numerators
			for (int j = i + 1; j < 100; j++) { // iterate over all two-digit denominators greater than the numerator
				if (isCuriousFraction(i, j)) { // check if the fraction is curious
					numeratorProduct *= i; // multiply the numerator with the previous numerators of curious fractions
					denominatorProduct *= j; // multiply the denominator with the previous denominators of curious fractions
				}
			}
		}

		// calculate the greatest common divisor of the numerator product and denominator product
		int gcd = gcd(numeratorProduct, denominatorProduct);

		// calculate the reduced denominator by dividing the denominator product with the greatest common divisor
		int reducedDenominator = denominatorProduct / gcd;

		System.out.println(reducedDenominator); 
	}

	// returns true if the fraction is curious, false otherwise
	private static boolean isCuriousFraction(int numerator, int denominator) {
		if (numerator >= denominator) {
			return false; // if the numerator is greater or equal to the denominator, the fraction is not proper
		}

		int commonDigit = getCommonDigit(numerator, denominator); // find the common digit between numerator and denominator

		if (commonDigit == -1) {
			return false; // if there is no common digit, the fraction is not curious
		}

		// remove the common digit from numerator and denominator
		int reducedNumerator = removeDigit(numerator, commonDigit);
		int reducedDenominator = removeDigit(denominator, commonDigit);

		if (reducedDenominator == 0) {
			return false; // if the reduced denominator is zero, the fraction is not valid
		}

		// check if the reduced fraction is equal to the original fraction
		return numerator * reducedDenominator == reducedNumerator * denominator;
	}

	// returns the common digit between two integers, or -1 if there is no common digit
	private static int getCommonDigit(int x, int y) {
		for (int i = 1; i <= 9; i++) { // iterate over all possible digits
			if (hasDigit(x, i) && hasDigit(y, i)) { // check if both x and y have the digit
				return i; // return the common digit
			}
		}

		return -1; // return -1 if there is no common digit
	}

	// returns true if the integer x has the digit, false otherwise
	private static boolean hasDigit(int x, int digit) {
		while (x > 0) { // iterate over all digits of x
			if (x % 10 == digit) { // check if the digit is equal to the last digit of x
				return true; // return true if the digit is found
			}

			x /= 10; // remove the last digit of x
		}

		return false; // return false if the digit is not found
	}

	// returns the integer x with the digit removed
	private static int removeDigit(int x, int digit) {
		int result = 0; // initialize the result variable to zero
		int multiplier = 1; // initialize the multiplier variable to one

		while (x > 0) { // iterate over all digits of x
			int lastDigit = x % 10; // get the last digit of x

			if (lastDigit != digit) { // if the digit is not equal to the last digit of x
				result += lastDigit * multiplier; // add the last digit to the result variable
				multiplier *= 10; // multiply the multiplier by 10
			}

			x /= 10; // remove the last digit of x
		}

		return result; // return the result variable
	}

	// returns the greatest common divisor of two integers
	private static int gcd(int a, int b) {
		while (b != 0) { // while b is not zero
			int temp = b; // store the value of b in a temporary variable
			b = a % b; // set b to the remainder of a divided by b
			a = temp; // set a to the previous value of b
		}

		return a; // return the greatest common divisor
	}
}

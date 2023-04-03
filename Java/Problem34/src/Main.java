import java.util.HashMap;

/*
@author: mces58

Problem 34
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: As 1! = 1 and 2! = 2 are not sums they are not included.

Answer: 40730
*/

public class Main {
	public static void main(String[] args) {
		int sum = 0;
		HashMap<Integer, Integer> factorials = new HashMap<>();

		// Calculate factorials for each digit from 0 to 9 and store in the HashMap
		for (int i = 0; i <= 9; i++) {
			factorials.put(i, factorial(i));
		}

		// Find the upper bound for the range of numbers to check
		int upperBound = 7 * factorials.get(9);

		// Check each number to see if it equals the sum of the factorials of its digits
		for (int i = 10; i <= upperBound; i++) {
			if (isFactorialSum(i, factorials)) {
				sum += i;
			}
		}

		System.out.println(sum);
	}

	// Calculate the factorial of a given number
	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	// Check if the sum of factorials of the digits of a number is equal to the number itself
	public static boolean isFactorialSum(int num, HashMap<Integer, Integer> factorials) {
		int sum = 0;
		for (char c : Integer.toString(num).toCharArray()) {
			sum += factorials.get(Character.getNumericValue(c));
		}
		return num == sum;
	}
}

import java.util.HashSet;
import java.util.Set;

/*
@author: mces58

Problem 32
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.

Answer: 45228
*/

public class Main {
	public static void main(String[] args) {
		Set<Integer> panDigital = new HashSet<>();

		for (int i = 1; i < 2000; i++) {
			for (int j = 1; j < 100; j++) {
				int product = i * j;
				String pandigitalStr = String.valueOf(i) + String.valueOf(j) + String.valueOf(product);
				// Check if the length of the concatenated string is equal to 9 and
				// if the concatenated string is pandigital using the isPandigital function
				if (pandigitalStr.length() == 9 && isPandigital(pandigitalStr, 9)) {
					panDigital.add(product);
				}
			}
		}
		int sum = 0;
		for (int num : panDigital) {
			sum += num;
		}
		System.out.println(sum);
	}

	public static boolean isPandigital(String n, int s) {
		// Check if the length of the string is equal to s (default is 9)
		// and if the string contains all of the digits 1 through s exactly once
		if (n.length() != s) {
			return false;
		}
		for (int i = 1; i <= s; i++) {
			if (!n.contains(String.valueOf(i))) {
				return false;
			}
		}
		return true;
	}
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
@author: mces58

Problem 23
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

Answer: 4179871
*/

public class Main {
	public static void main(String[] args) {
		List<Integer> abundantNumbers = new ArrayList<Integer>();

		for (int i = 1; i < 28124; i++) {
			if (isAbundant(i)) {
				abundantNumbers.add(i);
			}
		}

		Set<Integer> abundantSums = new HashSet<Integer>();

		for (int i = 0; i < abundantNumbers.size(); i++) {
			for (int j = 0; j < abundantNumbers.size(); j++) {
				int sum = abundantNumbers.get(i) + abundantNumbers.get(j);
				if (sum > 28123) {
					break;
				}
				abundantSums.add(sum);
			}
		}

		Set<Integer> nonAbundantSums = new HashSet<Integer>();

		for (int i = 1; i <= 28123; i++) {
			if (!abundantSums.contains(i)) {
				nonAbundantSums.add(i);
			}
		}

		int sum = 0;
		for (Integer n : nonAbundantSums) {
			sum += n;
		}
		System.out.println(sum);
	}

	// This function generates a list of divisors of a given number and returns it.
	public static List<Integer> getDivisors(int n) {
		List<Integer> divisors = new ArrayList<Integer>();

		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				divisors.add(i);
			}
		}
		return divisors;
	}

	// This function calculates the sum of divisors of a given number and returns
	// it.
	public static int getDivisorSum(int n) {
		int sum = 0;
		List<Integer> divisors = getDivisors(n);

		for (int i = 0; i < divisors.size(); i++) {
			sum += divisors.get(i);
		}
		return sum;
	}

	// This function checks if a given number is a perfect number.
	public static boolean isPerfect(int n) {
		return getDivisorSum(n) == n;
	}

	// This function checks if a given number is an abundant number.
	public static boolean isAbundant(int n) {
		return getDivisorSum(n) > n;
	}

	// This function checks if a given number is a deficient number.
	public static boolean isDeficient(int n) {
		return getDivisorSum(n) < n;
	}
}

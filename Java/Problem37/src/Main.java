import java.util.Arrays;

/*
@author: mces58

Problem 37
The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

Answer: 748317
*/

public class Main {
	public static void main(String[] args) {
		int limit = 1000000;
		boolean[] primes = sieveOfEratosthenes(limit);
		int sum = 0;

		for (int i = 11; i < limit; i++) {
			if (primes[i] && isTruncatable(i, primes)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	// Generate all primes below a given limits
	public static boolean[] sieveOfEratosthenes(int limit) {
		boolean[] primes = new boolean[limit];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		for (int i = 2; i < limit; i++) {
			if (primes[i]) {
				for (int j = i * 2; j < limit; j += i) {
					primes[j] = false;
				}
			}
		}
		return primes;
	}

	// Check if a number is truncatable from left and right
	public static boolean isTruncatable(int n, boolean[] primes) {
		String strN = Integer.toString(n);
		for (int i = 0; i < strN.length(); i++) {
			if (!primes[Integer.parseInt(strN.substring(i))] || !primes[Integer.parseInt(strN.substring(0, i + 1))]) {
				return false;
			}
		}
		return true;
	}

}

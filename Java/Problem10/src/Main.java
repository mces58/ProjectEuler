import java.util.Arrays;

/*
@author: mces58

Problem 10
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
Find the sum of all the primes below two million.

Answer: 142913828922
*/

public class Main {

	public static void main(String[] args) {
		System.out.println(sumOfPrimes(2000000));
	}

	public static long sumOfPrimes(int n) {
		boolean[] sieve = new boolean[n];
		Arrays.fill(sieve, true);
		sieve[0] = false; // 1 is not prime
		int i = 2;

		while (i * i <= n) {
			if (sieve[i - 1]) {
				// Mark all multiples of i as composite
				for (int j = i * i; j <= n; j += i) {
					sieve[j - 1] = false;
				}
			}
			i++;
		}

		// Sum all primes
		long total = 0;
		for (int k = 1; k < n; k++) {
			if (sieve[k]) {
				total += k + 1; // Adjust for 0-based index
			}
		}

		return total;
	}
}

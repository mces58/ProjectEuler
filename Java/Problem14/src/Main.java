import java.util.HashMap;
import java.util.Map;

/*
@author: mces58

Problem 14
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.

Answer: 837799
*/

public class Main {
	// The cache stores the lengths of previously calculated Collatz sequences.
	private static Map<Long, Integer> cache = new HashMap<>();

	public static void main(String[] args) {
		int counter = 0;
		long maxLength = 0;

		long startTime = System.nanoTime();

		// We loop through all numbers from 1 to 1 million to find the longest sequence
		for (long i = 1; i < 1000000; i++) {
			int length = collatzSequence(i);
			if (length > counter) {
				counter = length;
				maxLength = i;
			}
		}

		long endTime = System.nanoTime();

		System.out.println(maxLength);
		System.out.println("Time taken: " + (endTime - startTime) / 1_000_000_000.0);
	}

	// This function calculates the length of a number's Collatz sequence
	private static int collatzSequence(long n) {
		// If we have a result in the cache, we return the value from the cache.
		if (cache.containsKey(n)) {
			return cache.get(n);
		}
		// Otherwise, we calculate the length of the Collatz sequence using a loop
		int length = 1;
		long originalN = n; // Store the original value of n
		while (n != 1) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n = 3 * n + 1;
			}

			if (cache.containsKey(n)) {
				length += cache.get(n);
				break;
			}
			length++;
		}

		cache.put(originalN, length);

		return length;
	}
}

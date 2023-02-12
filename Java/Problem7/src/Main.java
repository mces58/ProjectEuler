import java.util.ArrayList;
import java.util.List;

/*
@author: mces58

Problem 7
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?

Answer: 104743
*/

public class Main {
	public static void main(String[] args) {
		System.out.println(nthPrime(10001));
	}

	public static int nthPrime(int n) {
		List<Integer> primes = new ArrayList<>();
		primes.add(2);
		int num = 3;
		while (primes.size() < n) {
			boolean isPrime = true;
			for (int p : primes) {
				if (p * p > num) {
					break;
				}
				if (num % p == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(num);
			}
			num += 2;
		}
		return primes.get(primes.size() - 1);
	}

}

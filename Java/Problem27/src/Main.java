import java.math.BigInteger;
import java.util.stream.IntStream;

/*
@author: mces58

Problem 27

Euler discovered the remarkable quadratic formula:

    n^2 + n + 41

It turns out that the formula will produce 40 primes for the consecutive integer values 0 <= n <= 39.
However, when n = 40, 40^2 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when
n = 41, 41^2 + 41 + 41 is clearly divisible by 41.

The incredible formula n^2 - 79n 1601 was discovered, which produces 80 primes for the consecutive values
0 <= n <= 79. The product of the coefficients, −79 and 1601, is −126479.

Considering quadratics of the form:
    n^2 + an + b, where |a| < 1000 and |b| < 1000
    where |n| is the modulus/absolute value of n
    e.g. |11| = 11 and |-4| = 4

Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, 
starting with n = 0.

Answer: -59231
*/

public class Main {
	public static void main(String[] args) {
		int primeCount = 0;
		int aMax = 0;
		int bMax = 0;

		for (int a = -1000; a < 1000; a++) {
			for (int b : primesInRange(1, 1000)) {
				int tempPrimeCount = 0;
				int n = 0;

				while (isPrime(BigInteger.valueOf(n * n + a * n + b).intValue())) {
					tempPrimeCount++;
					n++;
				}

				if (tempPrimeCount > primeCount) {
					primeCount = tempPrimeCount;
					aMax = a;
					bMax = b;
				}
			}
		}

		System.out.println(aMax * bMax);
		System.out.println(primeCount);
	}

	private static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	private static int[] primesInRange(int start, int end) {
		return IntStream.range(start, end).filter(Main::isPrime).toArray();
	}
}

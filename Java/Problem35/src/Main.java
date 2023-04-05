/*
@author: mces58

Problem 35
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?

Answer: 55
*/

public class Main {
	public static void main(String[] args) {
		int count = 4; // 2, 3, 5, and 7 are already considered.

		for (int n = 11; n < 1000000; n += 2) {
			if (Integer.toString(n).matches(".*[024568].*")) {
				continue;
			}
			if (isCircularPrime(n)) {
				count++;
			}
		}
		System.out.println(count);
	}

	// Determines whether a number is prime or not
	public static boolean isPrime(int n) {
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

	// Returns the number obtained by rotating the digits of the input number
	public static String rotate(int n) {
		String s = Integer.toString(n);
		return s.substring(1) + s.charAt(0);
	}

	// Determines whether a number is circular prime or not
	public static boolean isCircularPrime(int n) {
		if (!isPrime(n)) {
			return false;
		}
		String rotated = rotate(n);

		while (!rotated.equals(Integer.toString(n))) {
			if (!isPrime(Integer.parseInt(rotated))) {
				return false;
			}
			rotated = rotate(Integer.parseInt(rotated));
		}
		return true;
	}

}

import java.math.BigInteger;

/*
@author: mces58

Problem 5
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

Answer : 232792560
*/

public class Main {
	public static void main(String[] args) {
		System.out.println(lcmOfRange(20));
	}

	public static BigInteger gcd(BigInteger a, BigInteger b) {
		while (!b.equals(BigInteger.valueOf(0))) {
			BigInteger temp = b;
			b = a.mod(b);
			a = temp;
		}

		return a;
	}

	public static BigInteger lcm(BigInteger a, BigInteger b) {
		return a.multiply(b).divide(gcd(a, b));
	}

	public static BigInteger lcmOfRange(int n) {
		BigInteger lcmVal = BigInteger.valueOf(1);

		for (int i = 1; i <= n; i++) {
			lcmVal = lcm(lcmVal, BigInteger.valueOf(i));
		}

		return lcmVal;
	}
}

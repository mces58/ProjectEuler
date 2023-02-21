import java.math.BigInteger;

/*
@author: mces58

Problem 15
Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.

How many such routes are there through a 20×20 grid?

Answer: 137846528820
*/

public class Main {
	public static void main(String[] args) {
		// calculate iterative permutation
		BigInteger bigInteger = calculateFact(40).divide(calculateFact(20).multiply(calculateFact(20)));

		System.out.println(bigInteger);
	}

	// calculate factorial
	public static BigInteger calculateFact(int number) {
		BigInteger factorial = BigInteger.ONE;

		for (int i = 1; i <= number; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}

		return factorial;
	}
}

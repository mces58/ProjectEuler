import java.math.BigInteger;

/*
@author: mces58

Problem 20
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!

Answer: 648
*/

public class Main {
	public static void main(String[] args) {
		BigInteger result = calculateFact(BigInteger.valueOf(100));

		int sum = 0;
		String strResult = result.toString();

		for (int i = 0; i < strResult.length(); i++) {
			sum += Character.getNumericValue(strResult.charAt(i));
		}

		System.out.println(sum);
	}

	public static BigInteger calculateFact(BigInteger number) {
		BigInteger factorial = BigInteger.ONE;

		for (BigInteger i = BigInteger.valueOf(2); i.compareTo(number) <= 0; i = i.add(BigInteger.ONE)) {
			factorial = factorial.multiply(i);
		}

		return factorial;
	}
}

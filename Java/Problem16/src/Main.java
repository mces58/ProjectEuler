import java.math.BigInteger;

/*
@author: mces58

Problem 16
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?

Answer: 1366
*/

public class Main {
	public static void main(String[] args) {
		BigInteger number = new BigInteger("2").pow(1000);

		String numberStr = number.toString();
		int sum = 0;

		for (int i = 0; i < numberStr.length(); i++) {
			sum += Character.getNumericValue(numberStr.charAt(i));
		}

		System.out.println(sum);
	}
}

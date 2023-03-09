/*
@author: mces58

Problem 30
Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 1^4 + 6^4 + 3^4 + 4^4
8208 = 8^4 + 2^4 + 0^4 + 8^4
9474 = 9^4 + 4^4 + 7^4 + 4^4
As 1 = 1^4 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.

Answer: 443839
*/

public class Main {
	public static void main(String[] args) {
		int total = 0;

		for (int i = 10; i < 355000; i++) {
			int digitSum = 0;

			for (char digit : String.valueOf(i).toCharArray()) {
				digitSum += Math.pow(Character.getNumericValue(digit), 5);
			}
			if (digitSum == i) {
				total += i;
			}
		}
		System.out.println(total);
	}
}

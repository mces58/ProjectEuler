/*
@author:mces58

Problem 4
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.

Answer: 906609
*/

public class Main {
	public static void main(String[] args) {
		System.out.println(largestPalindrome());
	}

	public static boolean isPalindrome(int n) {
		String str = Integer.toString(n);
		int len = str.length();
		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static int largestPalindrome() {
		int largestPalindrome = 0;
		for (int i = 999; i >= 100; i--) {
			for (int j = 999; j >= 100; j--) {
				int product = i * j;
				if (isPalindrome(product) && product > largestPalindrome) {
					largestPalindrome = product;
				}
			}
		}
		return largestPalindrome;
	}
}

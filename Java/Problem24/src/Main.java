import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
@author: mces58

Problem 24
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

Answer: 2783915460
*/

public class Main {
	public static void main(String[] args) {
		String digits = "0123456789";
		int permutationNumber = 999999;
		String millionthPermutation = permutation(digits, permutationNumber);

		System.out.println(millionthPermutation);
	}

	private static String permutation(String digits, int permutationNumber) {
		List<String> perms = new ArrayList<>(Arrays.asList(digits.split("")));
		Collections.sort(perms);
		List<String> permutationList = new ArrayList<>(perms.size());

		for (String s : perms) {
			permutationList.add(s);
		}

		StringBuilder resultBuilder = new StringBuilder();

		for (int i = digits.length() - 1; i >= 0; i--) {
			int factorial = factorial(i);
			int index = permutationNumber / factorial;

			resultBuilder.append(permutationList.get(index));
			permutationList.remove(index);
			permutationNumber %= factorial;
		}
		return resultBuilder.toString();
	}

	private static int factorial(int n) {
		int result = 1;

		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		return result;
	}
}

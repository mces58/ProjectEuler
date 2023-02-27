import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
@author: mces58

Problem 21
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.

Answer: 31626
*/

public class Main {

	// Keep a map of the sums of divisors for all numbers seen so far
	static Map<Integer, Integer> divisorSums = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		HashSet<Integer> amicables = new HashSet<Integer>();
		int amicableSum = 0;

		for (int i = 1; i < 10000; i++) {
			if (amicables.contains(i)) {
				continue;
			}
			int b = d(i);
			if (d(b) == i && b > i) {
				amicables.add(i);
				amicables.add(b);
				amicableSum += i + b;
			}
		}
		System.out.println(amicableSum);
	}

	// Calculate the sum of proper divisors of n
	public static int d(int n) {
		if (divisorSums.containsKey(n)) {
			return divisorSums.get(n);
		}

		int sum = 1;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				sum += i;
				if (i != n / i) {
					sum += n / i;
				}
			}
		}
		divisorSums.put(n, sum);
		return sum;
	}
}

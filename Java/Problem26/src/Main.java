import java.util.HashMap;

/*
@author: mces58

Problem 26
A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

    1/2	= 	0.5
    1/3	= 	0.(3)
    1/4	= 	0.25
    1/5	= 	0.2
    1/6	= 	0.1(6)
    1/7	= 	0.(142857)
    1/8	= 	0.125
    1/9	= 	0.(1)
    1/10	= 	0.1

Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.

Answer: 983
*/

public class Main {
	public static void main(String[] args) {
		int maxLength = 0;
		int maxDenominator = 0;

		for (int d = 2; d <= 1000; d++) {
			int cycleLength = recurringLength(d);

			if (cycleLength > maxLength) {
				maxLength = cycleLength;
				maxDenominator = d;
			}
		}
		System.out.println(maxDenominator);
	}

	public static int recurringLength(int n) {
		// Returns the length of the recurring cycle in the decimal representation of 1/n.
		HashMap<Integer, Integer> remainders = new HashMap<>();
		int remainder = 1;
		int position = 0;

		while (!remainders.containsKey(remainder)) {
			remainders.put(remainder, position);
			remainder = (remainder * 10) % n;
			position++;
		}
		if (remainder == 0) {
			return 0; // no recurring cycle
		} else {
			return position - remainders.get(remainder);
		}
	}

}

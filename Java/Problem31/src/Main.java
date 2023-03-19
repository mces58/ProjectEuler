import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/*
@author: mces58

Problem 31
In the United Kingdom the currency is made up of pound (£) and pence (p). There are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
It is possible to make £2 in the following way:

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?

Answer: 73682
*/

public class Main {
	public static void main(String[] args) {
		int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 }; // list of coin denominations
		int target = 200; // target amount of money

		int[] ways = new int[target + 1]; // create dynamic programming table
		ways[0] = 1;

		for (int coin : coins) {
			for (int i = coin; i <= target; i++) {
				ways[i] += ways[i - coin]; // update table with number of ways to reach i
			}
		}

		// set console encoding to UTF-8
		PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);

		out.println("Number of ways to make 2 £: " + ways[target]);
	}
}

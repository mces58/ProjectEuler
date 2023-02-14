/*
@author: mces58

Problem 9
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.

Answer: 31875000
*/

public class Main {
	public static void main(String[] args) {
		for (int a = 1; a < 1000; a++) {
			for (int b = a + 1; b < 1000; b++) {
				int c = 1000 - a - b;
				if (c > b) {
					if (a * a + b * b == c * c) {
						System.out.println(a * b * c);
						return;
					}
				}
			}
		}
	}
}

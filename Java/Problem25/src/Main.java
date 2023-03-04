import java.math.BigInteger;

/*
@author: mces58

Problem 25
The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the index of the first term in the Fibonacci sequence to contain 1000 digits?

Answer: 4782
*/

public class Main {
	public static void main(String[] args) {
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		int index = 2;

		while (true) {
			BigInteger c = a.add(b);
			a = b;
			b = c;
			index++;

			if (c.toString().length() == 1000) {
				System.out.println(index);
				System.out.println(c);
				break;
			}
		}
	}
}

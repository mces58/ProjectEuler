/*
@author: mces58

Problem 53
There are exactly ten ways of selecting three from five, 12345:
    123, 124, 125, 134, 135, 145, 234, 235, 245, and 345

In combinatorics, we use the notation, C(5, 3) = 10.
In general, C(n, r) = n! / r!(n -r)!, where r ≤ n, n! = n x (n - 1) x ... x 3 x 2 x 1, and 0! = 1.
It is not until n = 23, that a value exceeds one-million: C(23, 10) = 1144066.

How many, not necessarily distinct, values of C(n, r) for 1 ≤ n ≤ 100, are greater than one-million?

Answer: 4075
*/

public class Main {
  public static void main(String[] args) {
    int count = 0;
    int threshold = 1_000_000;

    for (int n = 1; n <= 100; n++) {
      for (int r = 0; r <= n; r++) {
        if (countLargeCombinations(n, r, threshold)) {
          count++;
        }
      }
    }

    System.out.println("The number of combinations greater than " + threshold + " is: " + count);
  }

  public static boolean countLargeCombinations(int n, int r, int limit) {
    if (r > n / 2) {
      r = n - r; // Use symmetry property C(n, r) == C(n, n-r)
    }

    long combination = 1; // Represents C(n, r)
    for (int i = 1; i <= r; i++) {
      combination = combination * (n - i + 1) / i;

      if (combination > limit) {
        return true;
      }
    }

    return false;
  }
}

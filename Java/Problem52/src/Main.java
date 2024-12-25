import java.util.Arrays;

/*
@author: mces58

Problem 52
It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.

Answer: 142857
*/

public class Main {
  public static void main(String[] args) {
    int result = findSmallestPermutedMultiple();
    System.out.println("Result: " + result);
  }

  public static boolean hasSameDigits(int n) {
    char[] sortedDigits = Integer.toString(n).toCharArray();
    Arrays.sort(sortedDigits);

    for (int multiplier = 2; multiplier <= 6; multiplier++) {
      char[] currentDigits = Integer.toString(n * multiplier).toCharArray();
      Arrays.sort(currentDigits);

      if (!Arrays.equals(sortedDigits, currentDigits)) {
        return false;
      }
    }

    return true;
  }

  public static int findSmallestPermutedMultiple() {
    int n = 1;
    while (true) {
      if (hasSameDigits(n)) {
        return n;
      }
      n++;
    }
  }
}

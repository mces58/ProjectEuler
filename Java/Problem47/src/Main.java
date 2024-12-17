import java.util.HashSet;
import java.util.Set;

/*
@author: mces58

Problem 47
The first two consecutive numbers to have two distinct prime factors are:
              14 = 2 x 7
              15 = 3 x 5

The first three consecutive numbers to have three distinct prime factors are
              644 = 2^2 x 7 x 23
              645 = 3 x 5 x 43
              646 = 2 x 17 x 19

Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?

Answer: 134043
*/

public class Main {
  public static void main(String[] args) {
    int result = findConsecutiveNumbers(4, 4);
    System.out.println("Result: " + result);
  }

  public static int primeFactorsCount(int n) {
    Set<Integer> factors = new HashSet<>();

    while (n % 2 == 0) {
      factors.add(2);
      n /= 2;
    }

    for (int i = 3; i <= Math.sqrt(n); i += 2) {
      while (n % i == 0) {
        factors.add(i);
        n /= i;
      }
    }

    if (n > 2) {
      factors.add(n);
    }

    return factors.size();
  }

  public static int findConsecutiveNumbers(int targetFactors, int consecutiveCount) {
    int consecutive = 0;
    int num = 2;

    while (true) {
      if (primeFactorsCount(num) == targetFactors) {
        consecutive++;
        if (consecutive == consecutiveCount) {
          return num - consecutiveCount + 1;
        }
      } else {
        consecutive = 0;
      }
      num++;
    }
  }
}

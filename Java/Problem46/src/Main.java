import java.util.ArrayList;
import java.util.List;

/*
@author: mces58

Problem 46
It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.
      9 = 7 + 2×1^2
      15 = 7 + 2×2^2
      21 = 3 + 2×3^2
      25 = 7 + 2×3^2
      27 = 19 + 2×2^2
      33 = 31 + 2×1^2

It turns out that the conjecture was false.
What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?

Answer: 5777
 */

public class Main {
  public static void main(String[] args) {
    int result = findSmallestCounterexample();
    System.out.println("The first number where the hypothesis is wrong is: " + result);
  }

  public static boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean canBeExpressed(int n, List<Integer> primes) {
    for (int p : primes) {
      if (p >= n) {
        break;
      }
      int kSquared = (n - p) / 2;
      int k = (int) Math.sqrt(kSquared);
      if (k * k == kSquared) {
        return true;
      }
    }
    return false;
  }

  public static int findSmallestCounterexample() {
    List<Integer> primes = new ArrayList<>();
    int n = 3;

    while (true) {
      if (isPrime(n)) {
        primes.add(n);
      } else {
        if (!canBeExpressed(n, primes)) {
          return n;
        }
      }
      n += 2;
    }
  }
}

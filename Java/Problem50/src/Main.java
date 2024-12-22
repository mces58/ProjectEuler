import java.util.ArrayList;
import java.util.List;

/*
@author: mces58

Problem 50
The prime 41, can be written as the sum of six consecutive primes:
                  41 = 2 + 3 + 5 + 7 + 11 + 13.
This is the longest sum of consecutive primes that adds to a prime below one-hundred.
The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?

Answer: 997651
*/

public class Main {
  public static void main(String[] args) {
    int limit = 1000000;
    int[] result = findLargestPrimeSum(limit);
    System.out
        .println("The largest prime number under " + limit + ": " + result[0] + ", sequence length: " + result[1]);
  }

  private static boolean isPrime(int n) {
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

  private static List<Integer> generatePrimes(int limit) {
    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i < limit; i++) {
      if (isPrime(i)) {
        primes.add(i);
      }
    }
    return primes;
  }

  private static int[] findLargestPrimeSum(int limit) {
    List<Integer> primes = generatePrimes(limit);
    int maxLength = 0;
    int maxPrime = 0;

    for (int i = 0; i < primes.size(); i++) {
      for (int j = i + maxLength; j < primes.size(); j++) {
        int total = 0;
        for (int k = i; k < j; k++) {
          total += primes.get(k);
        }
        if (total > limit) {
          break;
        }
        if (primes.contains(total)) {
          maxLength = j - i;
          maxPrime = total;
        }
      }
    }
    return new int[] { maxPrime, maxLength };
  }
}

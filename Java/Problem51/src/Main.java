import java.util.*;

/*
@author: mces58

Problem 51
By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten 
generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this 
family, is the smallest prime with this property.

Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.

Answer: 121313
*/

public class Main {
  public static void main(String[] args) {
    System.out.println("Smallest prime number: " + findSmallestPrimeWithReplacements());
  }

  public static List<Integer> generatePrimes(int limit) {
    boolean[] sieve = new boolean[limit];
    Arrays.fill(sieve, true);
    sieve[0] = sieve[1] = false;

    for (int i = 2; i * i < limit; i++) {
      if (sieve[i]) {
        for (int multiple = i * i; multiple < limit; multiple += i) {
          sieve[multiple] = false;
        }
      }
    }

    List<Integer> primes = new ArrayList<>();
    for (int i = 0; i < limit; i++) {
      if (sieve[i]) {
        primes.add(i);
      }
    }
    return primes;
  }

  public static int findSmallestPrimeWithReplacements() {
    int limit = 1_000_000;
    Set<Integer> primes = new HashSet<>(generatePrimes(limit));

    for (int prime : primes) {
      String primeStr = String.valueOf(prime);
      int length = primeStr.length();

      for (int numDigits = 1; numDigits < length; numDigits++) {
        List<List<Integer>> combinations = generateCombinations(length, numDigits);

        for (List<Integer> indices : combinations) {
          List<Integer> replacements = new ArrayList<>();

          for (char digit = '0'; digit <= '9'; digit++) {
            char[] candidate = primeStr.toCharArray();
            for (int idx : indices) {
              candidate[idx] = digit;
            }
            int newNumber = Integer.parseInt(new String(candidate));

            if (primes.contains(newNumber) && String.valueOf(newNumber).length() == length) {
              replacements.add(newNumber);
            }
          }

          if (replacements.size() >= 8) {
            return Collections.min(replacements);
          }
        }
      }
    }
    return -1;
  }

  public static List<List<Integer>> generateCombinations(int n, int r) {
    List<List<Integer>> combinations = new ArrayList<>();
    combine(combinations, new ArrayList<>(), 0, n, r);
    return combinations;
  }

  private static void combine(List<List<Integer>> combinations, List<Integer> current, int start, int n, int r) {
    if (current.size() == r) {
      combinations.add(new ArrayList<>(current));
      return;
    }
    for (int i = start; i < n; i++) {
      current.add(i);
      combine(combinations, current, i + 1, n, r);
      current.remove(current.size() - 1);
    }
  }
}

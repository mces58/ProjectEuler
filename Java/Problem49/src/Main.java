import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
@author: mces58

Problem 49
The arithmetic sequence, 1487, 4817, 8147, n which each of the terms increases by 3330, is unusual in two ways: 
(i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?

Answer: 296962999629
*/

public class Main {
  public static void main(String[] args) {
    System.out.println(findPrimePermutations());
  }

  public static String findPrimePermutations() {
    List<Integer> primes = getFourDigitPrimes();
    Set<Integer> primeSet = new HashSet<>(primes);

    for (int prime : primes) {
      Set<Integer> perms = getPermutations(prime);
      List<Integer> primePerms = new ArrayList<>();

      for (int perm : perms) {
        if (primeSet.contains(perm) && perm >= 1000) {
          primePerms.add(perm);
        }
      }
      Collections.sort(primePerms);

      for (int i = 0; i < primePerms.size(); i++) {
        for (int j = i + 1; j < primePerms.size(); j++) {
          int diff = primePerms.get(j) - primePerms.get(i);
          int third = primePerms.get(j) + diff;
          if (primePerms.contains(third) && primePerms.get(i) != 1487) {
            return "" + primePerms.get(i) + primePerms.get(j) + third;
          }
        }
      }
    }
    return null;
  }

  private static List<Integer> getFourDigitPrimes() {
    List<Integer> primes = new ArrayList<>();
    for (int i = 1000; i < 10000; i++) {
      if (isPrime(i)) {
        primes.add(i);
      }
    }
    return primes;
  }

  private static boolean isPrime(int n) {
    if (n < 2)
      return false;
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0)
        return false;
    }
    return true;
  }

  private static Set<Integer> getPermutations(int num) {
    Set<Integer> perms = new HashSet<>();
    permute(Integer.toString(num).toCharArray(), 0, perms);
    return perms;
  }

  private static void permute(char[] chars, int index, Set<Integer> perms) {
    if (index == chars.length) {
      perms.add(Integer.parseInt(new String(chars)));
      return;
    }
    for (int i = index; i < chars.length; i++) {
      swap(chars, i, index);
      permute(chars, index + 1, perms);
      swap(chars, i, index);
    }
  }

  private static void swap(char[] chars, int i, int j) {
    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
  }
}

/*
@author: mces58

Problem 48
The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.

Answer: 9110846700
*/

public class Main {
  public static void main(String[] args) {
    int n = 1000;
    String last10Digits = findLastTenDigits(n);
    System.out.println("Last ten digits: " + last10Digits);
  }

  public static String findLastTenDigits(int n) {
    long mod = 10_000_000_000L;
    long selfPowersSum = 0;

    for (int i = 1; i <= n; i++) {
      long currentPower = 1;

      for (int j = 1; j <= i; j++) {
        currentPower = (currentPower * i) % mod;
      }

      selfPowersSum = (selfPowersSum + currentPower) % mod;
    }

    return String.format("%010d", selfPowersSum);
  }
}

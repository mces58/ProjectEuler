"""
@author: mces58

Problem 10
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
Find the sum of all the primes below two million.

Answer: 142913828922
"""


def sumOfPrimes(n):
    sieve = [True] * n
    sieve[0] = False  # 1 is not prime
    i = 2
    while i * i <= n:
        if sieve[i - 1]:
            # Mark all multiples of i as composite
            for j in range(i * i, n + 1, i):
                sieve[j - 1] = False
        i += 1

    # Sum all primes
    total = 0
    for i in range(1, n):
        if sieve[i]:
            total += i + 1  # Adjust for 0-based index

    return total


print(sumOfPrimes(2000000))

"""
@author: mces58

Problem 41
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. 
For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?

Answer: 7652413
"""

from itertools import permutations
import math


def isPrime(n):
    if n <= 1:
        return False
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    for i in range(3, int(math.sqrt(n)) + 1, 2):
        if n % i == 0:
            return False
    return True


def largestPandigitalPrime():
    for n in range(9, 0, -1):
        digits = "".join(str(i) for i in range(1, n + 1))
        pandigitalNumbers = sorted(
            ["".join(p) for p in permutations(digits)], reverse=True
        )
        for numStr in pandigitalNumbers:
            num = int(numStr)
            if isPrime(num):
                return num
    return None


print(largestPandigitalPrime())

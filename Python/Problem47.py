""" 
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
"""

from math import sqrt


def primeFactorsCount(n):
    factors = set()
    while n % 2 == 0:
        factors.add(2)
        n //= 2
    for i in range(3, int(sqrt(n)) + 1, 2):
        while n % i == 0:
            factors.add(i)
            n //= i
    if n > 2:
        factors.add(n)
    return len(factors)


def findConsecutiveNumbers(targetFactors, consecutiveCount):
    consecutive = 0
    num = 2

    while True:
        if primeFactorsCount(num) == targetFactors:
            consecutive += 1
            if consecutive == consecutiveCount:
                return num - consecutiveCount + 1
        else:
            consecutive = 0
        num += 1


result = findConsecutiveNumbers(targetFactors=4, consecutiveCount=4)
print("Result:", result)

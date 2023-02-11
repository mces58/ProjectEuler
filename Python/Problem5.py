"""
@author: mces58

Problem 5
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

Answer : 232792560
"""

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def lcm(a, b):
    return a * b // gcd(a, b)

def lcmOfRange(n):
    lcmVal = 1
    for i in range(1, n + 1):
        lcmVal = lcm(lcmVal, i)
    return lcmVal

print(lcmOfRange(20))

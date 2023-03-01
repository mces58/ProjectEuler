"""
@author: mces58

Problem 23
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

Answer: 4179871
"""


# This function generates a list of divisors of a given number and returns it.
def getDivisors(n):
    divisors = []
    for i in range(1, int(n/2)+1):
        if n % i == 0:
            divisors.append(i)
    return divisors


# This function calculates the sum of divisors of a given number and returns it.
def getDivisorSum(n):
    return sum(getDivisors(n))


# This function checks if a given number is a perfect number.
def isPerfect(n):
    return getDivisorSum(n) == n


# This function checks if a given number is an abundant number.
def isAbundant(n):
    return getDivisorSum(n) > n


# This function checks if a given number is a deficient number.
def isDeficient(n):
    return getDivisorSum(n) < n


abundantNumbers = []

for i in range(1, 28124):
    if isAbundant(i):
        abundantNumbers.append(i)

abundantSums = set()

for i in abundantNumbers:
    for j in abundantNumbers:
        if i + j > 28123:
            break
        abundantSums.add(i + j)

nonAbundantSums = set(range(1, 28124)) - abundantSums

print(sum(nonAbundantSums))

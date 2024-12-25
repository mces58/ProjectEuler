"""
@author: mces58

Problem 44
Pentagonal numbers are generated by the formula, Pn=n(3n−1)/2. The first ten pentagonal numbers are:
                    1, 5, 12, 22, 35, 51, 70, 92, 117, 145,...

It can be seen that P4 + P7 = 22 + 70 = 92 = P8. However, their difference, 70 − 22 = 48, is not pentagonal.
Find the pair of pentagonal numbers, Pj and Pk, for which their sum and difference are pentagonal and D = |Pk − Pj| is minimised; what is the value of D?

Answer: 5482660
"""

import math


def pentagonNumber(n):
    return n * (3 * n - 1) // 2


def isPentagonNumber(x):
    if x <= 0:
        return False
    test = (math.sqrt(24 * x + 1) + 1) / 6
    return test.is_integer()


def findMinimalPentagonDifference():
    pentagonNumbers = []
    n = 1

    while True:
        pn = pentagonNumber(n)
        pentagonNumbers.append(pn)

        for pj in pentagonNumbers[:-1]:
            pk = pn
            if isPentagonNumber(pk - pj) and isPentagonNumber(pk + pj):
                return pk - pj

        n += 1


result = findMinimalPentagonDifference()
print("Minimal difference of pentagonal numbers:", result)
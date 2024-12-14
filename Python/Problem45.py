"""
@author: mces58

Problem 45
Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:
    Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
    Pentagonal	 	Pn=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
    Hexagonal	 	Hn=n(2n−1)	 	1, 6, 15, 28, 45, ...

It can be verified that T285 = P165 = H143 = 40755.

Find the next triangle number that is also pentagonal and hexagonal.

Answer: 1533776805
"""

import math


def isPentagonal(num):
    n = (math.sqrt(24 * num + 1) + 1) / 6
    return n.is_integer()


def isHexagonal(num):
    n = (math.sqrt(8 * num + 1) + 1) / 4
    return n.is_integer()


def findNextTriPentHex():
    n = 286

    while True:
        triangle = n * (n + 1) // 2
        if isPentagonal(triangle) and isHexagonal(triangle):
            return triangle
        n += 1


result = findNextTriPentHex()
print("The next triangular, pentagonal, and hexagonal number is:", result)

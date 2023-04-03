"""
@author: mces58

Problem 34
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: As 1! = 1 and 2! = 2 are not sums they are not included.

Answer: 40730
"""

import math

# Create a dictionary of factorials for each digit from 0 to 9
# 0! = 1, 1! = 1, 2! = 2, ..., 9! = 362880
factorials = {str(i): math.factorial(i) for i in range(10)}


# Check if the sum of factorials of the digits of a number is equal to the number itself
def isFactorialSum(num):
    return num == sum(factorials[digit] for digit in str(num))


# Find the sum of all numbers which are equal to the sum of the factorials of their digits
def findSumOfFactorialNumbers():
    # The upper bound is set to 7 * 9! = 2540160 as any number greater than this will not satisfy the condition
    upperBound = 2540160
    total = sum(num for num in range(10, upperBound+1) if isFactorialSum(num))
    return total


print(findSumOfFactorialNumbers())

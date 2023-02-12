"""
@author: mces58

Problem 6
The sum of the squares of the first ten natural numbers is,
1^2 + 2^2 + ... + 10^2 = 385

The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)^2 = 3025

Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is .
3025 - 385 = 2640

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

Answer:  25164150
"""

def sumOfSquares(n):
    return sum([i**2 for i in range(1, n+1)])

def squareOfSum(n):
    return sum(range(1, n+1))**2

def difference(n):
    return squareOfSum(n) - sumOfSquares(n)

print(difference(100))

"""
@author: mces58

Problem 15
Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.

How many such routes are there through a 20×20 grid?

Answer: 137846528820
"""

# calculate factorial


def calculateFact(number):
    factorial = 1
    for i in range(1, number + 1):
        factorial *= i
    return factorial


# calculate iterative permutation

result = calculateFact(40) / (calculateFact(20) * calculateFact(20))

print(int(result))

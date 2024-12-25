""" 
@author: mces58

Problem 52
It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.

Answer: 142857
"""


def hasSameDigits(n):
    sortedDigits = sorted(str(n))
    for multiplier in range(2, 7):
        if sorted(str(n * multiplier)) != sortedDigits:
            return False
    return True


def findSmallestPermutedMultiple():
    n = 1
    while True:
        if hasSameDigits(n):
            return n
        n += 1


result = findSmallestPermutedMultiple()
print("Result:", result)

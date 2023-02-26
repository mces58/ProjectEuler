"""
@author: mces58

Problem 20
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!

Answer: 648
"""

# calculate the factorial of 100


def calculateFact(number):
    factorial = 1

    for i in range(1, number + 1):
        factorial *= i
    return factorial


result = calculateFact(100)

sum = 0

# convert the factorial to a string and sum its digits
for i in str(result):
    sum += int(i)

print(sum)

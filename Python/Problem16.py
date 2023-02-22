"""
@author: mces58

Problem 16
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?

Answer: 1366
"""

number = 2**1000
sum = 0

for i in str(number):
    sum += int(i)

print(sum)

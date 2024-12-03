"""
@author: mces58

Problem 40
An irrational decimal fraction is created by concatenating the positive integers:
                        0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.
If dn represents the nth digit of the fractional part, find the value of the following expression.

d1×d10×d100×d1000×d10000×d100000​

Answer: 840
"""


def findDigitAtPosition(position):
    length = 1
    count = 9
    start = 1

    while position > length * count:
        position -= length * count
        length += 1
        count *= 10
        start *= 10

    number = start + (position - 1) // length
    digit = str(number)[(position - 1) % length]

    return int(digit)


def solve():
    product = 1
    positions = [1, 10, 100, 1000, 10000, 100000]

    for pos in positions:
        product *= findDigitAtPosition(pos)

    return product


print(solve())

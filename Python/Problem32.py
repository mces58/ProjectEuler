"""
@author: mces58

Problem 32
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.

Answer: 45228
"""


def isPandigital(n, s=9):
    n = str(n)
    # Check if the length of the string is equal to s (default is 9)
    # and if the string does not contain any of the digits 1 through s exactly once
    return len(n) == s and not '1234567890'[:s].strip(n)


panDigital = set()
for i in range(1, 2000):
    for j in range(1, 100):
        product = i * j
        pandigitalStr = str(i) + str(j) + str(product)
        # Check if the length of the concatenated string is equal to 9 and
        # if the concatenated string is pandigital using the is_pandigital function
        if len(pandigitalStr) == 9 and isPandigital(pandigitalStr):
            panDigital.add(product)

print(sum(panDigital))

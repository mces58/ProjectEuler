"""
@author: mces58

Problem 33
The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.

Answer: 100
"""

import math

# Finds the common digit between the numerator and denominator of a fraction.


def findCommonDigit(numerator, denominator):
    numeratorDigits = list(str(numerator))
    denominatorDigits = list(str(denominator))
    commonDigit = list(set(numeratorDigits) & set(denominatorDigits))

    return int(commonDigit[0]) if commonDigit else None


# Simplifies a fraction by removing the common digit from both the numerator and denominator.


def simplifyFraction(numerator, denominator, commonDigit):
    numeratorDigits = list(str(numerator))
    denominatorDigits = list(str(denominator))
    numeratorDigits.remove(str(commonDigit))
    denominatorDigits.remove(str(commonDigit))
    newNumerator = int(numeratorDigits[0])
    newDenominator = int(denominatorDigits[0])

    return newNumerator, newDenominator


# Checks if a fraction satisfies the curious fraction property.


def isCuriousFraction(numerator, denominator):

    commonDigit = findCommonDigit(numerator, denominator)
    if not commonDigit:
        return False
    newNumerator, newDenominator = simplifyFraction(
        numerator, denominator, commonDigit)
    if newDenominator == 0:
        return False

    return numerator / denominator == newNumerator / newDenominator


productNumerator = 1
productDenominator = 1

for numerator in range(10, 100):
    for denominator in range(numerator+1, 100):
        if isCuriousFraction(numerator, denominator):
            commonDigit = findCommonDigit(numerator, denominator)
            newNumerator, newDenominator = simplifyFraction(
                numerator, denominator, commonDigit)
            productNumerator *= newNumerator
            productDenominator *= newDenominator

gcd = math.gcd(productNumerator, productDenominator)
smallestProduct = productDenominator // gcd

print(smallestProduct)

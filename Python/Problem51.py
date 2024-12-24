""" 
@author: mces58

Problem 51
By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten 
generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this 
family, is the smallest prime with this property.

Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.

Answer: 121313
"""

from itertools import combinations


def generatePrimes(limit):
    sieve = [True] * limit
    sieve[0] = sieve[1] = False
    for i in range(2, int(limit**0.5) + 1):
        if sieve[i]:
            for multiple in range(i * i, limit, i):
                sieve[multiple] = False
    return [num for num, isPrime in enumerate(sieve) if isPrime]


def findSmallestPrimeWithReplacements():
    limit = 10**6
    primes = set(generatePrimes(limit))

    for prime in primes:
        primeStr = str(prime)
        length = len(primeStr)

        for numDigits in range(1, length):
            for indices in combinations(range(length), numDigits):
                replacements = []

                for digit in "0123456789":
                    candidate = list(primeStr)
                    for idx in indices:
                        candidate[idx] = digit
                    newNumber = int("".join(candidate))

                    if newNumber in primes and len(str(newNumber)) == length:
                        replacements.append(newNumber)

                if len(replacements) >= 8:
                    return min(replacements)


result = findSmallestPrimeWithReplacements()
print("Smallest prime number:", result)

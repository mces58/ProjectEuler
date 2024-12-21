""" 
@author: mces58

Problem 49
The arithmetic sequence, 1487, 4817, 8147, n which each of the terms increases by 3330, is unusual in two ways: 
(i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?

Answer: 296962999629
"""

from itertools import permutations
from sympy import isprime


def findPrimePermutations():
    primes = [n for n in range(1000, 10000) if isprime(n)]
    primeSet = set(primes)

    for prime in primes:
        perms = set(int("".join(p)) for p in permutations(str(prime)))
        primePerms = sorted(p for p in perms if p in primeSet and p >= 1000)

        for i in range(len(primePerms)):
            for j in range(i + 1, len(primePerms)):
                diff = primePerms[j] - primePerms[i]
                third = primePerms[j] + diff
                if third in primePerms and third - primePerms[j] == diff:
                    if primePerms[i] != 1487:
                        return f"{primePerms[i]}{primePerms[j]}{third}"


result = findPrimePermutations()
print(result)

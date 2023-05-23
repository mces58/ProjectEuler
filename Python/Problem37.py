"""
@author: mces58

Problem 37
The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

Answer: 748317
"""


# Generate all primes below a given limits
def sieveOfEratosthenes(limit):
    primes = [True] * limit
    primes[0] = primes[1] = False
    for ind, val in enumerate(primes):
        if val is True:
            primes[ind*2::ind] = [False] * (((limit - 1)//ind) - 1)
    return [ind for ind, val in enumerate(primes) if val is True]


# Check if a number is truncatable from left and right
def isTruncatable(n):
    strN = str(n)
    return all(int(strN[i:]) in primes and int(strN[:i+1]) in primes for i in range(len(strN)))


# Generate all primes below 1 million
primes = set(sieveOfEratosthenes(1000000))

# Check if the primes are truncatable
truncatablePrimes = [p for p in primes if p > 10 and isTruncatable(p)]

# Compute the sum
result = sum(truncatablePrimes)
print(result)

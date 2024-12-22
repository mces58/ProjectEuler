""" 
@author: mces58

Problem 50
The prime 41, can be written as the sum of six consecutive primes:
                  41 = 2 + 3 + 5 + 7 + 11 + 13.
This is the longest sum of consecutive primes that adds to a prime below one-hundred.
The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?

Answer: 997651
"""


def isPrime(n):
    if n < 2:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True


def generatePrimes(limit):
    primes = []
    for num in range(2, limit):
        if isPrime(num):
            primes.append(num)
    return primes


def findLargestPrimeSum(limit):
    primes = generatePrimes(limit)
    maxLength = 0
    maxPrime = 0

    for i in range(len(primes)):
        for j in range(i + maxLength, len(primes)):
            total = sum(primes[i:j])
            if total > limit:
                break
            if total in primes:
                maxLength = j - i
                maxPrime = total

    return maxPrime, maxLength


limit = 1000000
result, length = findLargestPrimeSum(limit)
print(f"The largest prime number under {limit}: {result}, sequence length: {length}")

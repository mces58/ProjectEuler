""" 
@author: mces58

Problem 46
It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.
      9 = 7 + 2×1^2
      15 = 7 + 2×2^2
      21 = 3 + 2×3^2
      25 = 7 + 2×3^2
      27 = 19 + 2×2^2
      33 = 31 + 2×1^2

It turns out that the conjecture was false.
What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?

Answer: 5777
"""


def isPrime(n):
    if n < 2:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True


def canBeExpressed(n, primes):
    for p in primes:
        if p >= n:
            break
        kSquared = (n - p) / 2
        if kSquared == int(kSquared) and int(kSquared) ** 0.5 == int(
            int(kSquared) ** 0.5
        ):
            return True
    return False


def findSmallestCounterexample():
    primes = []
    n = 3
    while True:
        if isPrime(n):
            primes.append(n)
        else:
            if not canBeExpressed(n, primes):
                return n
        n += 2


result = findSmallestCounterexample()
print("The first number where the hypothesis is wrong is:", result)

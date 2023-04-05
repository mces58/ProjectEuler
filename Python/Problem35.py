"""
@author: mces58

Problem 35
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?

Answer: 55
"""

# Determines whether a number is prime or not
def isPrime(n):
    if n < 2:
        return False
    for i in range(2, int(n**0.5)+1):
        if n % i == 0:
            return False
    return True


# Returns the number obtained by rotating the digits of the input number
def rotate(n):
    return str(n)[1:] + str(n)[0]


# Determines whether a number is circular prime or not
def isCircularPrime(n):

    if not isPrime(n):
        return False
    rotated = rotate(n)
    while rotated != str(n):
        if not isPrime(int(rotated)):
            return False
        rotated = rotate(rotated)
    return True


count = 4  # 2, 3, 5, and 7 are already considered

for n in range(11, 1000000, 2):
    if '0' in str(n) or '2' in str(n) or '4' in str(n) or '5' in str(n) or '6' in str(n) or '8' in str(n):
        continue
    if isCircularPrime(n):
        count += 1

print(count)

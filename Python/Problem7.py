"""
@author: mces58

Problem 7
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?

Answer: 104743
"""

def isPrime(num):
    if num <= 1:
        return False
    for i in range(2, int(num**(0.5)) + 1):
        if num % i == 0:
            return False
    return True

def nthPrime(n):
    count = 0
    num = 2
    while count < n:
        if isPrime(num):
            count += 1
        num += 1
    return num - 1

print("The 10001st prime number is:", nthPrime(10001))

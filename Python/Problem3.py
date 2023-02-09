"""
@author: mces58

Problem 3
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?

Answer: 6857
"""
import math

number = 600851475143
maxPrime = 1

def isPrime(number):
    isPrime = True
    
    # A number is prime if it is not divisible by its square root.
    for i in range(2, int(math.sqrt(number) + 1)):
        if number % i == 0:
            isPrime = False
    
    return isPrime

for i in range(2, int(math.sqrt(number))):
    if number % i == 0 and isPrime(i):
        maxPrime = i
        
print("Answer: " + str(maxPrime))
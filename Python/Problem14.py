"""
@author: mces58

Problem 14
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.

Answer: 837799
"""
import time

start = time.time()

# The cache stores the lengths of previously calculated Collatz sequences.
cache = {1: 1}

# This function calculates the length of a number's Collatz sequence


def collatzSequence(n):
    # If we have a result in the cache, we return the value from the cache.
    if n in cache:
        return cache[n]

     # Otherwise, we calculate the length of the Collatz sequence.
    length = 1
    if n % 2 == 0:
        length += collatzSequence(n // 2)  # if n is even, compute n/2
    else:
        length += collatzSequence(3*n + 1)  # if n is odd, compute 3n+1
    cache[n] = length
    return length


counter = 0
maxLength = 0

# We loop through all numbers from 1 to 1 million to find the longest sequence
for i in range(1, 1000000):
    length = collatzSequence(i)
    if length > counter:
        counter = length
        maxLength = i

print(maxLength)
print("Time taken: ", time.time() - start)

""" 
@author: mces58

Problem 53
There are exactly ten ways of selecting three from five, 12345:
    123, 124, 125, 134, 135, 145, 234, 235, 245, and 345

In combinatorics, we use the notation, C(5, 3) = 10.
In general, C(n, r) = n! / r!(n -r)!, where r ≤ n, n! = n x (n - 1) x ... x 3 x 2 x 1, and 0! = 1.
It is not until n = 23, that a value exceeds one-million: C(23, 10) = 1144066.

How many, not necessarily distinct, values of C(n, r) for 1 ≤ n ≤ 100, are greater than one-million?

Answer: 4075
"""


def countLargeCombinations(limit, threshold):
    count = 0

    for n in range(1, limit + 1):
        c = 1  # C(n, 0) is always 1
        for r in range(1, n + 1):
            c = c * (n - r + 1) // r  # Compute C(n, r) iteratively
            if c > threshold:
                count += 1

    return count


limit = 100
threshold = 10**6
result = countLargeCombinations(limit, threshold)
print(f"The number of combinations greater than {threshold} is: {result}")

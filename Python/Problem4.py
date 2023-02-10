"""
@author:mces58

Problem 4
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.

Answer: 906609
"""

def is_palindrome(n):
    return str(n) == str(n)[::-1]

def largest_palindrome():
    largest_palindrome = 0
    for i in range(999, 99, -1):
        for j in range(999, 99, -1):
            product = i * j
            if is_palindrome(product) and product > largest_palindrome:
                largest_palindrome = product
    return largest_palindrome

print(largest_palindrome())

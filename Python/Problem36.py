"""
@author: mces58

Problem 36
The decimal number, 585 = (1001001001)2 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)

Answer: 872187
"""

# Function to check if a string is a palindrome
def isPalindrome(s):
    return s == s[::-1]


# Function to find the sum of double-base palindromes below the given limit
def doubleBasePalindromes(limit):
    total = 0
    for number in range(1, limit):
        # Convert the number to its decimal and binary string representations
        decimalRepresentation = str(number)
        binaryRepresentation = bin(number)[2:]

        # Check if both representations are palindromes
        if isPalindrome(decimalRepresentation) and isPalindrome(binaryRepresentation):
            total += number
    return total


limit = 1000000
result = doubleBasePalindromes(limit)
print(result)

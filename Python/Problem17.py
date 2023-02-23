"""
@author: mces58

Problem 17
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.

Answer: 21124
"""

# This dictionary maps numbers to their word forms, which we will use to calculate the total letter count
numberWord = {
    0: '',
    1: 'one',
    2: 'two',
    3: 'three',
    4: 'four',
    5: 'five',
    6: 'six',
    7: 'seven',
    8: 'eight',
    9: 'nine',
    10: 'ten',
    11: 'eleven',
    12: 'twelve',
    13: 'thirteen',
    14: 'fourteen',
    15: 'fifteen',
    16: 'sixteen',
    17: 'seventeen',
    18: 'eighteen',
    19: 'nineteen',
    20: 'twenty',
    30: 'thirty',
    40: 'forty',
    50: 'fifty',
    60: 'sixty',
    70: 'seventy',
    80: 'eighty',
    90: 'ninety',
    100: 'hundred',
    1000: 'onethousand'
}

# This function calculates the number of letters in the word form of a given number


def numberLetters(num):
    if num == 1000:
        return len(numberWord[num])

    # Initialize variables to represent the ones, tens, and hundreds digits of the number
    ones = num % 10
    tens = (num // 10) % 10
    hundreds = (num // 100) % 10

    # Calculate the number of letters in the word form of the number
    letterCount = 0
    if hundreds > 0:
        letterCount += len(numberWord[hundreds]) + len(numberWord[100])
        if tens > 0 or ones > 0:
            letterCount += 3  # add the number of letters in 'and'
    if tens == 1:
        letterCount += len(numberWord[tens*10 + ones])
    else:
        letterCount += len(numberWord[tens*10]) + len(numberWord[ones])
    return letterCount


# Calculate the total number of letters in the word forms of the numbers from 1 to 1000
totalLetters = 0
for i in range(1, 1001):
    totalLetters += numberLetters(i)

print(totalLetters)

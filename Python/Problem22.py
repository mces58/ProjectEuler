"""
@author: mces58

Problem 22
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?

Answer: 871198282
"""

import string

# read the file and split the names
with open("names.txt", "r") as file:
    names = file.read().replace('"', '').split(",")

# sort the names in alphabetical order
list.sort(names)

# calculate the value of each letter
dict = dict()
alphabet = string.ascii_uppercase
letterValue = 1

for letter in alphabet:
    dict[letter] = letterValue
    letterValue += 1

# calculate the score for each name and add it to the total score
totalScore = 0
index = 1

for name in names:
    nameScore = 0
    for letter in name:
        nameScore += dict[letter]

    totalScore += nameScore * index
    index += 1

print(totalScore)

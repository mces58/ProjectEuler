"""
@author: mces58

Problem 31
In the United Kingdom the currency is made up of pound (£) and pence (p). There are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
It is possible to make £2 in the following way:

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?

Answer: 73682
"""

coins = [1, 2, 5, 10, 20, 50, 100, 200]  # list of coin denominations
target = 200  # target amount of money

ways = [1] + [0]*target  # create dynamic programming table

for coin in coins:
    for i in range(coin, target+1):
        ways[i] += ways[i-coin]  # update table with number of ways to reach i

print("Number of ways to make 2 £:", ways[target])

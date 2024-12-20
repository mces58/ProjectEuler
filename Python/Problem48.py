""" 
@author: mces58

Problem 48
The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.

Answer: 9110846700
"""


def findLastTenDigits(n: int) -> str:
    selfPowersSum = sum(i**i for i in range(1, n + 1))

    return str(selfPowersSum)[-10:]


n = 1000
lastTenDigits = findLastTenDigits(n)
print("Last ten digits: ", lastTenDigits)

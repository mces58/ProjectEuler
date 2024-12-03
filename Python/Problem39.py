"""
@author: mces58

Problem 39
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?

Answer: 840
"""

def countRightAngleTriangles(p):
    count = 0
    for a in range(1, p//3 + 1):
        for b in range(a, (p-a)//2 + 1):
            c = p - a - b
            if a**2 + b**2 == c**2:
                count += 1
    return count

maxSolutions = 0
maxP = 0

for p in range(1, 1001):
    solutions = countRightAngleTriangles(p)
    if solutions > maxSolutions:
        maxSolutions = solutions
        maxP = p

print("p value with the most solutions:", maxP)
print("Number of solutions:", maxSolutions)


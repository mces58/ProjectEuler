/*
@author: mces58

Problem 39
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?

Answer: 840
*/

public class Main {
    public static void main(String[] args) {
        int maxSolutions = 0;
        int maxP = 0;

        for (int p = 1; p <= 1000; p++) {
            int solutions = countRightAngleTriangles(p);
            if (solutions > maxSolutions) {
                maxSolutions = solutions;
                maxP = p;
            }
        }

        System.out.println("p value with the most solutions: " + maxP);
        System.out.println("Number of solutions: " + maxSolutions);
    }

    public static int countRightAngleTriangles(int p) {
        int count = 0;
        for (int a = 1; a <= p / 3; a++) {
            for (int b = a; b <= (p - a) / 2; b++) {
                int c = p - a - b;
                if (a * a + b * b == c * c) {
                    count++;
                }
            }
        }
        return count;
    }
}

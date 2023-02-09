/*
@author: mces58

Problem 3
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?

Answer: 6857
*/

public class Main {
	public static void main(String[] args) {
		System.out.println("Answer: " + maxPrime(600851475143L));
	}

	public static int maxPrime(long number) {
		int i = 2;
		while (i * i <= number) {
			if (number % i == 0) {
				number /= i;
				i = 2;
			} else {
				i++;
			}
		}
		return (int) number;
	}
}

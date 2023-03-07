/*
@author: mces58

Problem 28
Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?

Answer: 669171001
*/

public class Main {
	public static void main(String[] args) {
		// The size of the matrix
		int n = 1001;

		// Initialize the matrix with zeros
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = 0;
			}
		}

		// Starting direction
		String direction = "right";

		// Starting row index
		int x = 500;

		// Starting column index
		int y = 500;

		// Set the center element to 1
		matrix[x][y] = 1;

		// Starting number to fill the matrix
		int number = 2;

		// Loop until the matrix is filled
		while (number < 1001 * 1001) {

			// Move to the right as long as there is space
			while (direction.equals("right") && y < 1000) {
				// Fill the next element with the current number
				matrix[x][y + 1] = number;
				number++; // Increment the current number
				y++; // Move one step to the right

				// If the next element in the downward direction is empty, change direction to "down"
				if (matrix[x + 1][y] == 0) {
					direction = "down";
					break;
				}
			}

			while (direction.equals("down")) {
				matrix[x + 1][y] = number;
				number++;
				x++;

				if (matrix[x][y - 1] == 0) {
					direction = "left";
					break;
				}
			}

			while (direction.equals("left")) {
				matrix[x][y - 1] = number;
				number++;
				y--;

				if (matrix[x - 1][y] == 0) {
					direction = "up";
					break;
				}
			}

			while (direction.equals("up")) {
				matrix[x - 1][y] = number;
				number++;
				x--;

				if (matrix[x][y + 1] == 0) {
					direction = "right";
					break;
				}
			}
		}

		int total = 0;
		for (int i = 0; i < n; i++) {
			total += matrix[i][i]; // Add elements on the main diagonal
			total += matrix[1000 - i][i]; // Add elements on the opposite diagonal
		}

		total -= matrix[500][500]; // Subtract the center element
		System.out.println(total);
	}
}

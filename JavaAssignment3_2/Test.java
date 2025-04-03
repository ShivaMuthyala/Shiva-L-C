package JavaAssignment3_2;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Sum of 5 and 10 (int): " + Adder.add(5, 10));
		System.out.println("Sum of 5.5 and 10.2 (double): " + Adder.add(5.5, 10.2));

		System.out.print("Enter a number to compute factorial: ");
		int number = scanner.nextInt();
		System.out.println("Factorial: " + Factorial.factorial(number));

		System.out.print("Enter size of array: ");
		int size = scanner.nextInt();
		int[] numbers = new int[size];
		System.out.println("Enter " + size + " elements:");
		for (int i = 0; i < size; i++) {
			numbers[i] = scanner.nextInt();
		}
		ArrayOperations.processArray(numbers);

		System.out.print("Enter number of rows and columns for matrix: ");
		int rowCount = scanner.nextInt();
		int colCount = scanner.nextInt();
		int[][] matrix = new int[rowCount][colCount];
		System.out.println("Enter elements of matrix:");
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		MatrixOperations.transpose(matrix, rowCount, colCount);

		scanner.close();
	}
}

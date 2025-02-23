package JavaAssignment3_2;

import java.util.Arrays;

public class MatrixOperations {
	public static void transpose(int[][] matrix, int rowCount, int colCount) {
		System.out.println("Given matrix:");
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
		int[][] transpose = new int[colCount][rowCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				transpose[j][i] = matrix[i][j];
			}
		}

		System.out.println("Transpose of the matrix:");
		for (int[] row : transpose) {
			System.out.println(Arrays.toString(row));
		}
	}
}

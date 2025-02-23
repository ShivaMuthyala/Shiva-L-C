package JavaAssignment3_2;

import java.util.Arrays;

public class ArrayOperations {

	public static void processArray(int[] numbers) {
		int max = numbers[0], min = numbers[0], sum = 0;
		for (int number : numbers) {
			if (number > max)
				max = number;
			if (number < min)
				min = number;
			sum += number;
		}
		double average = (double) sum / numbers.length;
		Arrays.sort(numbers);

		System.out.println("Largest: " + max);
		System.out.println("Smallest: " + min);
		System.out.println("Average: " + average);
		System.out.println("Sorted Array: " + Arrays.toString(numbers));
	}
}

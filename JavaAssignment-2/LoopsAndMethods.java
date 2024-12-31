package moodleAssignment_3;

import java.util.Scanner;

public class LoopsAndMethods {

	public static void evenNumbers(int number) {
		System.out.println("The even numbers between 1 and " + number + " are:");
		for (int num = 1; num <= number; num++)
			if (num % 2 == 0) {
				if ((num == number - 1 || num == number - 2)) { // added a check for pasting all the numbers in one line
																// and move to next line to execute next method
					System.out.println(num + " ");
				} else {
					System.out.print(num + " ");
				}
			}
	}

	public static void sumOfNaturalNumbers(int number) {
		int count = 1;
		int sum = 0;
		while (count <= number) {
			sum += count; // Add the current count to the sum
			count++; // Increment the count by 1
		}
		System.out.println("Sum of the natural number from 1 to " + number + " is " + sum);
	}

	public static double calculateArea(double radius) {
		return Math.PI * Math.pow(radius, radius);
	}

	public static double calculateArea(double length, double width) {
		return length * width;
	}

	public static void main(String[] args) {
		int input;
		double radius, length, width;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number to display all even numbers up to that number:");

		do { // do while loop for the input validation for even numbers and sum of natural
				// numbers
			input = scanner.nextInt();
			if (input <= 0) {
				System.out.println("Please enter a positive number greater than 0.");
			} else {
				evenNumbers(input);
				sumOfNaturalNumbers(input);
			}
		} while (input <= 0);

		System.out.println("------------------------------------");
		System.out.println("Please enter radius to calculate area of the circle");

		do { // do while loop for the input validation for radius
			radius = scanner.nextDouble();
			if (radius <= 0) {
				System.out.println("Please enter a positive number greater than 0.");
			} else {
				System.out.println("The area of the cirlce is " + calculateArea(radius));
			}
		} while (radius <= 0);

		System.out.println("------------------------------------");
		System.out.println("Please enter lenght and width to calculate area of the rectangle");

		do { // do while loop for the input validation for length and width
			length = scanner.nextDouble();
			width = scanner.nextDouble();
			if ((length <= 0) && (width <= 0)) {
				System.out.println("Please enter a positive number greater than 0.");
			} else {
				System.out.println("The area of the rectangle is " + calculateArea(length, width));
			}
		} while ((length <= 0) && (width <= 0));

		scanner.close();
	}
}

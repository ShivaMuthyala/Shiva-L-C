package ProceduralModel;

import java.util.Scanner;

public class Calculator {

	public static double add(double a, double b) {
		return a + b;
	}

	public static double subtract(double a, double b) {
		return a - b;
	}

	public static double multiply(double a, double b) {
		return a * b;
	}

	public static double squareRoot(double a) {
		double guess = 0;
		double increament = 0.01;
		while (guess * guess <= a) {
			guess += increament;
		}
		return guess - increament;

	}

	public static double factorial(double a) {
		if (a < 0) {
			System.out.println("Factorial of negative numbers is undefined.");
		}

		int result = 1;
		for (int i = 1; i <= a; i++) {
			result *= i;
		}
		return result;
	}

	public static double power(double base, double exponent) {
		double result = 1;
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please select an operation:\n" + "1. Addition\n" + "2. Subtraction\n" + "3. Multiply\n"
				+ "4. Square Root\n" + "5. Factorial\n" + "6.Power");
		int selection = scanner.nextInt();
		double input1, input2 = 0;
		if (selection == 4 || selection == 5) {
			System.out.println("Please enter a number to calculate");
			input1 = scanner.nextDouble();
		} else {
			System.out.println("Please enter 2 number to calculate");
			input1 = scanner.nextInt();
			input2 = scanner.nextInt();
		}

		switch (selection) {
		case 1:
			System.out.println(add(input1, input2));
			break;
		case 2:
			System.out.println(subtract(input1, input2));
			break;
		case 3:
			System.out.println(multiply(input1, input2));
			break;
		case 4:
			System.out.println(String.format("%.2f", squareRoot(input1)));
			break;
		case 5:
			System.out.println(factorial(input1));
			break;
		case 6:
			System.out.println(power(input1, input2));
		default:
			System.out.println("Invalid input");
		}

		scanner.close();
	}
}

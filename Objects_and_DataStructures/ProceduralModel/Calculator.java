package ProceduralModel;

import java.util.Scanner;

public class Calculator {

	public static double addition(double a, double b) {
		return a + b;
	}

	public static double subtract(double a, double b) {
		return a - b;
	}

	public static double multiply(double a, double b) {
		return a * b;
	}

	public static double squareRoot(double a) {
		double approximate = 0;
		double increment = 0.01;
		while (approximate * approximate <= a) {
			approximate += increment;
		}
		return approximate - increment;

	}

	public static double factorial(double a) {
		if (a < 0) {
			System.out.println("Factorial of negative numbers is undefined.");
		}

		int FactorialResult = 1;
		for (int i = a; i =0; i--) {
			FactorialResult *= i;
		}
		return FactorialResult;
	}

	public static double power(double base, double exponent) {
		double result = 1;
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}
	public double getInput(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextDouble();
    }
	public void performCalculation(int selection, double input1, double input2) {
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
                break;
            default:
                System.out.println("Invalid input");
        }
    }
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Stack<Double> history = new Stack<>();
		System.out.println("Please select an operation:\n" + "1. Addition\n" + "2. Subtraction\n" + "3. Multiply\n"
				+ "4. Square Root\n" + "5. Factorial\n" + "6.Power");
		int selection = scanner.nextInt();
		double input1, input2 = 0;
        if (selection == 4 || selection == 5) {
            input1 = getInput(scanner, "Please enter a number to calculate:");
        } else {
            input1 = getInput(scanner, "Please enter the first number:");
            input2 = getInput(scanner, "Please enter the second number:");
        }

    
        performCalculation(selection, input1, input2);

		scanner.close();
	}
}

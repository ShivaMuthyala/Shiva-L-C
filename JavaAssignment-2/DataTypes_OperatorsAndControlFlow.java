import java.util.Scanner;

public class DataTypes_OperatorsAndControlFlow {

	// Class-level variables to store data
	// These variables are declared as static so they can be accessed in all static methods.
	static int integerValue;
	static char characterInput;
	static float floatInput;
	static boolean booleanInput;
	static double doubleInput;

	// Method to initialize the variables
	public static void inputVariables() {
		// Assign values to class-level variables
		integerValue = 20;
		characterInput = 's';
		floatInput = 10.5f;
		booleanInput = true;
		doubleInput = 26.65;

	}

	// Method to perform arithmetic operations using int and float variables
	public static void arithmeticOperations() {
		// Perform addition, subtraction, and multiplication
		float addition = integerValue + floatInput;
		float subtraction = integerValue - floatInput;
		float multiplication = integerValue * floatInput;

		// Display the results of arithmetic operations
		System.out.println("\nArithmetic Operations:");
		System.out.println("Addition of int and float: " + addition);
		System.out.println("Subtraction of int and float: " + subtraction);
		System.out.println("Multiplication of int and float: " + multiplication);
	}

	// Method to check if a number is positive, negative, or zero
	public static void numberCheck(int number) {
		// Use if-else statements to determine the type of the number
		if (number > 0) {
			System.out.println(number + " is a positive number.");
		} else if (number < 0) {
			System.out.println(number + " is a negative number.");
		} else {
			System.out.println(number + " is zero.");
		}
	}

	// Method to check the day of the week based on a number (1-7)
	public static void weekCheck(int weekCheckNumber) {
		// Use a switch statement to map the number to a day of the week
		switch (weekCheckNumber) {
		case 1:
			System.out.println("Sunday");
			break;
		case 2:
			System.out.println("Monday");
			break;
		case 3:
			System.out.println("Tuesday");
			break;
		case 4:
			System.out.println("Wednesday");
			break;
		case 5:
			System.out.println("Thursday");
			break;
		case 6:
			System.out.println("Friday");
			break;
		case 7:
			System.out.println("Saturday");
			break;
		default:
			System.out.println("Invalid input.");
			break;
		}
	}

	// Main method to run the program
	public static void main(String[] args) {
		// Initialize variables
		inputVariables();

		// Perform arithmetic operations
		arithmeticOperations();

		// Check if numbers are positive, negative, or zero
		System.out.println("\nChecking numbers:");
		numberCheck(15); // Check positive number
		numberCheck(integerValue); // Check the value of integerValue
		numberCheck(-27); // Check negative number
		numberCheck(0); // Check zero

		// Check the day of the week based on user input
		Scanner scanner = new Scanner(System.in);
		int input;
		System.out.println("Please enter a number between 1 and 7 to check the day of the week:");

		// Continuously ask for input until the user enters a valid number
		do {
			input = scanner.nextInt();

			// Check if the input is a valid number between 1 and 7
			if (input < 1 || input > 7) {
				System.out.println("Invalid input. Please enter a number between 1 and 7.");
			}

		} while (input < 1 || input > 7);

		// Once valid input is entered, display the corresponding day of the week
		weekCheck(input);

		// Close the scanner after the loop ends to prevent resource leakage
		scanner.close();
	}
}

package ObjectModel;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);


		System.out.println("Select an operation:\n" + "1. Addition\n" + "2. Substraction\n" + "3. Multiplication\n"
				+ "4. Square Root\n" + "5. Factorial\n" + "6. Power");

		int choice = scanner.nextInt();
		double num1, num2 = 0;
		BinaryOperation binaryoperation= null;
		UnaryOperation unaryoperation = null;
		switch (choice) {
		case 1:
			binaryoperation = new Add();
			System.out.println("Enter two numbers:");
			num1 = scanner.nextDouble();
			num2 = scanner.nextDouble();
			System.out.println(binaryoperation.calculate(num1, num2));
			break;

		case 2:
			binaryoperation = new Multiply();
			System.out.println("Enter two numbers:");
			num1 = scanner.nextDouble();
			num2 = scanner.nextDouble();
			System.out.println(binaryoperation.calculate(num1, num2));
			break;

		case 3:
			binaryoperation = new Substract();
			System.out.println("Enter two numbers:");
			num1 = scanner.nextDouble();
			num2 = scanner.nextDouble();
			System.out.println(binaryoperation.calculate(num1, num2));
			break;

		case 4:
			unaryoperation = new SquareRoot();
			System.out.println("Enter a number:");
			num1 = scanner.nextDouble();
			System.out.println(unaryoperation.calculate(num1));
			break;

		case 5:
			unaryoperation = new Factorial();
			System.out.println("Enter a number:");
			num1 = scanner.nextDouble();
			System.out.println(unaryoperation.calculate(num1));
			break;

		case 6:
			binaryoperation = new Power();
			System.out.println("Enter two numbers:");
			num1 = scanner.nextDouble();
			num2 = scanner.nextDouble();
			System.out.println(binaryoperation.calculate(num1, num2));
			break;
		default:
			System.out.println("Invalid input.");
		}

		scanner.close();
	}
}

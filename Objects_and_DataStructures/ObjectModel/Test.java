package ObjectModel;

import java.util.Scanner;

public class Test {
	private static double getSingleInput(Scanner scanner) {
        System.out.println("Enter a number:");
        return scanner.nextDouble();
    }

    private static double[] getTwoInputs(Scanner scanner) {
        System.out.println("Enter two numbers:");
        return new double[]{scanner.nextDouble(), scanner.nextDouble()};
    }
	public static void performOperation(int choice, Scanner scanner) {
        BinaryOperation binaryOperation = null;
        UnaryOperation unaryOperation = null;

        switch (choice) {
            case 1:
                binaryOperation = new Addition();
                break;
            case 2:
                binaryOperation = new Subtract();
                break;
            case 3:
                binaryOperation = new Multiply();
                break;
            case 4:
                unaryOperation = new SquareRoot();
                break;
            case 5:
                unaryOperation = new Factorial();
                break;
            case 6:
                binaryOperation = new Power();
                break;
            default:
                System.out.println("Invalid input.");
                return;
        }

        if (binaryOperation != null) {
            double[] inputs = getTwoInputs(scanner);
            System.out.println(binaryOperation.calculate(inputs[0], inputs[1]));
        } else if (unaryOperation != null) {
            double input = getSingleInput(scanner);
            System.out.println(unaryOperation.calculate(input));
        }
    }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);


		System.out.println("Select an operation:\n" + "1. Addition\n" + "2. Subtraction\n" + "3. Multiplication\n"
				+ "4. Square Root\n" + "5. Factorial\n" + "6. Power");

		int choice = scanner.nextInt();
		performOperation(choice, scanner);

        scanner.close();
	}
}

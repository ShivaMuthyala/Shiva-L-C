import java.util.Scanner;

public class RecursionAndTypeCasting {
	public static int factorial(int number) {
		
		if (number == 0 || number == 1) {
			return 1;
		}
		return number * factorial(number - 1);
	}
	public static int fibonacciSeries(int number) {
		if (number == 0) {
            return 0; 
        } else if (number == 1) {
            return 1;
        }
        return fibonacciSeries(number - 1) + fibonacciSeries(number - 2);
	}
	public static void implicitCasting() {
		int intValue = 54;
		float floatValue = intValue;
		System.out.println("implicit casting");
		System.out.println("The int value is "+ intValue);
		System.out.println("The float value of the int value "+intValue+"by implicit type casting is "+floatValue);
	}
	public static void explicitCasting() {
		double doubleValue = 54.32;
		int intCastedValue = (int)doubleValue; 
		System.out.println("explicit casting");
		System.out.println("The double value is "+ doubleValue);
		System.out.println("The int value of the double value  "+doubleValue+"by explicit type casting is "+intCastedValue);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int factorialNumber, fibonacciNumber;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number to calculate factoraial");
	do {
		factorialNumber = scanner.nextInt();
		if (factorialNumber<0) {
			System.out.println("Please enter a positive number greater than 0");
		} else {
			System.out.println("The factorial of "+factorialNumber+" is "+factorial(factorialNumber));
		}
	} while (factorialNumber<0);
	System.out.println("------------------------------------");
	
	
	System.out.println("Please enter a number to calculate the nth fibonacci number");
	do {
		fibonacciNumber = scanner.nextInt();
		if (fibonacciNumber<0) {
			System.out.println("Please enter a positive number greater than 0");
		} else {
			System.out.println("The factorial of "+fibonacciNumber+" is "+factorial(fibonacciNumber));
		}
	} while (fibonacciNumber<0);
	System.out.println("------------------------------------");
	
	
	implicitCasting();
	explicitCasting();
	scanner.close();
	
	}

}

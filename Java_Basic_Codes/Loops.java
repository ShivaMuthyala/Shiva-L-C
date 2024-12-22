package moodleassignment_2;
import java.util.Scanner;
public class Loops {
	static int startNumber = 1;
	private static void displayMultiplicationTable(int number) {
		int multiple;
		for (int startNumber = 1 ; startNumber <=10 ; startNumber++) {
			 multiple =startNumber*number;
			 System.out.println(number+"*"+startNumber+"="+multiple);
		}
	}
	private static void sumOfEvenNumbers(int number) {
		int sumOfEven =0;
		while (startNumber<number) {
			if (startNumber%2==0) {
				sumOfEven +=startNumber;
			}
			startNumber++;
		}
		System.out.println("sum of all even numbers between 1 and "+number+ "=" + sumOfEven);
	}
	private static void factorialNumber(int number) {
		long factorial = 1;    //given long for store bigger data
        if (number < 0) {
            System.out.println("Please enter a positive integer for factorial");
        } else {
            int multiplier = number; 
            do {
                factorial *= multiplier; 
                multiplier--; 
            } while (multiplier > 0);
         // Print the factorial
            System.out.println("The factorial of " + number + " is: " + factorial);
        }
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an an integer");
		int inputNumber = scanner.nextInt();
		if (inputNumber<0) {
			System.out.println("Please enter a positive integer");
		} else {
			//Multiplication table
			displayMultiplicationTable(inputNumber);
			
			//Sum of even numbers
			sumOfEvenNumbers(inputNumber);
			
			//fractional number
			factorialNumber(inputNumber);
		}
        scanner.close();
	}	

}

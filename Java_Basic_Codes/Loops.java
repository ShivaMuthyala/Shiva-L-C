package moodleassignment_2;

import java.util.Scanner;

public class Loops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an an integer");
		
		//multiplication table
		
		int number = scanner.nextInt();
		int multiple;
		for (int i = 1; i <=10 ; i++) {
			 multiple =i*number;
			 System.out.println(number+"*"+i+"="+multiple);
		}
		
		//Sum of even numbers
		int j=1;
		int sum =0;
		while (j<number) {
			if (j%2==0) {
				sum +=j;
			}
			j++;
		}
		System.out.println("sum of all even numbers between 1 and "+number+ "=" + sum);
		
		//fractional number
		long factorial = 1;
        if (number < 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            int i = number; 
            do {
                factorial *= i; 
                i--; 
            } while (i > 0);
        }

        // Print the factorial
        System.out.println("The factorial of " + number + " is: " + factorial);
	}

}

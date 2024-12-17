package moodleassignment_2;

public class Operators {
	//initializing as static so that i can be used in main function
	static int a= 5;
	static int b =2;
	static int d =8;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Arithmetic operator
		
	System.out.println("Addition of a and b = "+ (a+b));
	System.out.println("Substraction of a and b = "+ (a-b));
	System.out.println("multiplication of a and b = "+ (a*b));
	System.out.println("division of a and b = "+  (a/b));  //divison
	System.out.println("modulus of a and b = "+  (a%b));   //remainder
	
	//Rational operators 
	
	if (a>b) {
		System.out.println("a is greater than b");
	}
	else if (a<b) {
		System.out.println("b is greater than a");
	} else {
System.out.println("a is equal to b");
	}
	
	//Logical operators for positive integers
	
	int c =a%2;
	//usage of and operator
	if ((a>1) && (c==0)) {          
		System.out.println("a is a even number");
	}
	//usage of or and not operator
	else if ((a>1) || !(c==0)) {     
		System.out.println("a is an odd number");
	} else {
        System.out.println("a is not an positive integer");
	}
	//Assignment operator
	int sum =0;
	//sum of 1 to 10 digits
	for (int i = 1; i <= 10; i++) {
        sum += i; // Add i to sum
    }
	System.out.println("sum of 1 to 10 is "+ sum);
	}
}

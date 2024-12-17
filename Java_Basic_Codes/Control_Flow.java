package moodleassignment_2;

import java.util.Scanner;

public class Control_Flow {

	static char Grade;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner = new Scanner(System.in);
System.out.println("Enter an your marks");
int marks = scanner.nextInt();
if (marks>=90) {
	Grade = 'A';
} 
else if ((marks>=75) && (marks<90)) {
	Grade = 'B';
}
else if ((marks>=50) && (marks<75)) {
	Grade = 'C';
}
else {
	Grade = 'F';
}
System.out.println("Grade of the student is "+ Grade);

//message for grade
switch (Grade) {
case ('A'):
	System.out.println("A: Excellent");
	break;
case ('B'):
	System.out.println("B: Goodjob");
break;
case ('C'):
	System.out.println("C: Average");
break;
case ('F'):
	System.out.println("F: Fail");
	break;
}
scanner.close();
}
	}

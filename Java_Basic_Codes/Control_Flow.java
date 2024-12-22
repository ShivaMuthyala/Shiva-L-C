import java.util.Scanner;

public class Control_Flow {

	static char Grade;
	private static void gradeForStudent(int number) {
		if (number>=90) {
			Grade = 'A';
		} 
		else if ((number>=75) && (number<90)) {
			Grade = 'B';
		}
		else if ((number>=50) && (number<75)) {
			Grade = 'C';
		}
		else {
			Grade = 'F';
		}
		System.out.println("Grade of the student is "+ Grade);
	}
	private static void messageForStudent(int number) {
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
	}
	
	
public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner = new Scanner(System.in);
System.out.println("Enter an your marks");
int marks = scanner.nextInt();

gradeForStudent(marks);
messageForStudent(marks);
}
}
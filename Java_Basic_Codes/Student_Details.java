package moodleassignment_2;

public class Student_Details {

	String StudentName = "Shiva";
	int RollNumber = 496;
	char Grade = 'A';
	
	int subject1_Marks = 89;
	int subject2_Marks = 92;
	int subject3_Marks = 80;
	
	final int maxMarksPerSubject = 100; //used final because it cannot be changed
	final int totalSubjects = 3;
	
	int totalMarks = subject1_Marks + subject2_Marks + subject3_Marks;
	
	double percentage = ((double) totalMarks/ (totalSubjects * maxMarksPerSubject)) * 100;
	
	public static void main(String[] args) {
	StudentDetails student = new StudentDetails();
	System.out.println("Total marks "+ student.totalMarks);
	System.out.println("percentage "+student.percentage);
}
}
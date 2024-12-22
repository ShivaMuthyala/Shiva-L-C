package moodleassignment_2;

public class StudentDetails {

    String studentName = "Shiva";
    int rollNumber = 496;
    char grade = 'A';

    int subject1Marks = 89;
    int subject2Marks = 92;
    int subject3Marks = 80;

    final int maxMarksPerSubject = 100; // Maximum marks per subject
    final int totalSubjects = 3;       // Total number of subjects

    public int calculateTotalMarks() {
        return subject1Marks + subject2Marks + subject3Marks;
    }

    public double calculatePercentage() {
        return ((double) calculateTotalMarks() / (totalSubjects * maxMarksPerSubject)) * 100;
    }

    public void displayStudentDetails() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
        System.out.println("Total Marks: " + calculateTotalMarks());
        System.out.println("Percentage: " + calculatePercentage() + "%");
    }

    public static void main(String[] args) {
        StudentDetails student = new StudentDetails();

        student.displayStudentDetails();
    }
}

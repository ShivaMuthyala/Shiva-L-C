package Collections;

import java.util.*;

public class StudentManagement {
	private final Scanner scanner = new Scanner(System.in);
	private final StudentManager studentManager = new StudentManager();

	public void start() {
		studentManager.addSampleStudents();
		boolean running = true;

		while (running) {
			printMenu();
			int choice = getChoice();
			switch (choice) {
			case 1:
				handleAddStudent();
				break;
			case 2:
				displayAllStudents();
				break;
			case 3:
				displayStudentsGroupedByClass();
				break;
			case 4:
				displayUniqueSubjects();
				break;
			case 5:
				searchBySubject();
				break;
			case 6:
				handleCounselingQueueAdd();
				break;
			case 7:
				displayCounselingQueue();
				break;
			case 8:
				running = false;
				System.out.println("Exiting....");
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}
	}

	private void printMenu() {
		System.out.println("--- Student Management Menu ---");
		System.out.println("1. Add Student");
		System.out.println("2. Display All Students");
		System.out.println("3. Group Students by Class");
		System.out.println("4. Display Unique Subjects");
		System.out.println("5. Search Students by Subject");
		System.out.println("6. Add Student to Counseling Queue");
		System.out.println("7. Display Counseling Queue");
		System.out.println("8. Exit");
		System.out.print("Enter your choice: ");
	}

	private int getChoice() {
		try {
			return Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			return -1;
		}
	}

	private void handleAddStudent() {
		try {
			System.out.print("Enter ID: ");
			int id = Integer.parseInt(scanner.nextLine());

			System.out.print("Enter Name: ");
			String name = scanner.nextLine();

			System.out.print("Enter Class Name (e.g., 10A): ");
			String className = scanner.nextLine();

			System.out.print("Enter Subjects (comma separated): ");
			String[] subjectArray = scanner.nextLine().split(",");
			List<String> subjects = Arrays.asList(subjectArray);

			Student student = new Student(id, name, className, subjects);
			studentManager.addStudent(student);
			System.out.println("Student added.");
		} catch (Exception e) {
			System.out.println("Invalid input. Please try again.");
		}
	}

	private void displayAllStudents() {
		List<Student> students = studentManager.getAllStudents();
		if (students.isEmpty()) {
			System.out.println("No students found.");
			return;
		}
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void displayStudentsGroupedByClass() {
		Map<String, List<Student>> grouped = studentManager.groupByClass();
		for (String className : grouped.keySet()) {
			System.out.println("\nClass: " + className);
			for (Student student : grouped.get(className)) {
				System.out.println(student);
			}
		}
	}

	private void displayUniqueSubjects() {
		Set<String> subjects = studentManager.getAllUniqueSubjects();
		System.out.println("Unique Subjects:");
		for (String subject : subjects) {
			System.out.println(subject);
		}
	}

	private void searchBySubject() {
		System.out.print("Enter subject to search: ");
		String subject = scanner.nextLine();
		List<Student> found = studentManager.searchStudentsBySubject(subject);
		if (found.isEmpty()) {
			System.out.println("No students found for subject: " + subject);
		} else {
			for (Student student : found) {
				System.out.println(student);
			}
		}
	}

	private void handleCounselingQueueAdd() {
		System.out.print("Enter student name for counseling: ");
		String name = scanner.nextLine();
		studentManager.addToCounselingQueue(name);
		System.out.println("Added to counseling queue.");
	}

	private void displayCounselingQueue() {
		Queue<String> queue = studentManager.getCounselingQueue();
		if (queue.isEmpty()) {
			System.out.println("No students in counseling queue.");
		} else {
			System.out.println("Counseling Queue:");
			for (String name : queue) {
				System.out.println(name);
			}
		}
	}

	public static void main(String[] args) {
		new StudentManagement().start();
	}

}

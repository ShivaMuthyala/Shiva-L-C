import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoList {
	private static final List<String> task = new ArrayList<>();
	private static final List<Boolean> status = new ArrayList<>();
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println("\n1. Add Task");
			System.out.println("2. Remove Task");
			System.out.println("3. Mark Task as Done");
			System.out.println("4. List Tasks");
			System.out.println("5. Exit");
			System.out.print("> ");

			int option = readOption();

			switch (option) {
			case 1:
				addTask();
				break;
			case 2:
				removeTask();
				break;
			case 3:
				markTaskDone();
				break;
			case 4:
				listTasks();
				break;
			case 5:
				System.out.println("Goodbye!");
				scanner.close();
				return;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}

	private static int readOption() {
		while (true) {
			try {
				int option = Integer.parseInt(scanner.nextLine());
				if (option >= 1 && option <= 5) {
					return option;
				} else {
					System.out.print("Invalid option. Please enter a number between 1 and 5: ");
				}
			} catch (NumberFormatException e) {
				System.out.print("Invalid input. Please enter a number: ");
			}
		}
	}

	private static void addTask() {
		System.out.print("Enter task description: ");
		String description = scanner.nextLine().trim();
		if (!description.isEmpty()) {
			task.add(description);
			status.add(false);
		} else {
			System.out.println("Task cannot be empty.");
		}
	}

	private static void removeTask() {
		if (task.isEmpty()) {
			System.out.println("No tasks to remove.");
			return;
		}

		listTasks();
		System.out.print("Enter task number to remove: ");
		int index = readTaskIndex();
		task.remove(index);
		status.remove(index);
	}

	private static void markTaskDone() {
		if (task.isEmpty()) {
			System.out.println("No tasks available.");
			return;
		}

		for (int i = 0; i < status.size(); i++) {
			if (!status.get(i)) {
				status.set(i, true);
		}

		System.out.println("All incomplete tasks have been marked as done.");
	}
	}

	private static void listTasks() {
		if (task.isEmpty()) {
			System.out.println("No tasks available.");
			return;
		}

		for (int i = 0; i < task.size(); i++) {
			String taskStatus = status.get(i) ? "[✔]" : "[ ]";
			System.out.printf("%d. %s %s%n", i + 1, taskStatus, task.get(i));
		}
	}

	private static int readTaskIndex() {
		while (true) {
			try {
				int index = Integer.parseInt(scanner.nextLine()) - 1;
				if (index >= 0 && index < task.size()) {
					return index;
				} else {
					System.out.print("Invalid task number. Try again: ");
				}
			} catch (NumberFormatException e) {
				System.out.print("Invalid input. Please enter a valid number: ");
			}
		}
	}
}

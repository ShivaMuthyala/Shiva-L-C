package JavaAssignment3_1;

public class PrintNumbers {
	public static void printNumbers() {
		for (int i = 0; i < User.age; i++) {
			System.out.println(i);
		}
	}

	public static void printEvenNumbers() {
		for (int i = 0; i < User.age; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}
}

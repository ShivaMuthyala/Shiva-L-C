package JavaAssignment3_1;

public class PrintNumbers {
	static int age = User.getAge();

	public static void printNumbersUpToAge() {

		for (int i = 0; i < age; i++) {
			System.out.println(i);
		}
	}

	public static void printEvenNumbersUpToAge() {
		int i = 0;
		while (i < age) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		}
	}
}

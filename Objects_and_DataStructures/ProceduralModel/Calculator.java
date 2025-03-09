package ProceduralModel;

public class Calculator {

	public static double add(double a, double b) {
		return a + b;
	}

	public static double subtract(double a, double b) {
		return a - b;
	}

	public static double multiply(double a, double b) {
		return a * b;
	}

	public static void calculate(String operation, double a, double b) {
		switch (operation) {
		case "add":
			System.out.println(add(a, b));
			break;
		case "subtract":
			System.out.println(subtract(a, b));
			break;
		case "multiply":
			System.out.println(multiply(a, b));
			break;
		}

	}

	public static void main(String[] args) {
		calculate("add", 5, 3);
		calculate("subtract", 10, 4);
		calculate("multiply", 6, 7);
	}
}

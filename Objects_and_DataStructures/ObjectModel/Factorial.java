package ObjectModel;

public class Factorial implements UnaryOperation {


	@Override
	public double calculate(double a) {
		if (a < 0) {
			throw new IllegalArgumentException("Factorial of negative numbers is undefined.");
		}

		int result = 1;
		for (int i = 1; i <= a; i++) {
			result *= i;
		}
		return result;
	}
}

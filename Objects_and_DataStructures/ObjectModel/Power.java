package ObjectModel;

public class Power implements BinaryOperation {

	@Override
	public double calculate(double a, double b) {
		double result = 1;
		for (int i = 0; i < b; i++) {
			result *= a;
		}
		return result;
	}

}

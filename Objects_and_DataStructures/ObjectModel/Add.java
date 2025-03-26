package ObjectModel;

public class Add implements BinaryOperation {

	@Override
	public double calculate(double a, double b) {
		return a + b;
	}

}

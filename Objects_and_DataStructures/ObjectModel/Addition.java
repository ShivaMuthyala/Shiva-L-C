package ObjectModel;

public class Addition implements BinaryOperation {

	@Override
	public double calculate(double a, double b) {
		return a + b;
	}

}

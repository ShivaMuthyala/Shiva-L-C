package ObjectModel;

public class SquareRoot implements UnaryOperation {
	@Override
	public double calculate(double a) {
		double guess = 0;
		double increament = 0.01;
		while (guess * guess <= a) {
			guess += increament;
		}
		return guess - increament;
	}

}

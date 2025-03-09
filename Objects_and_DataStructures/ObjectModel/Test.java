package ObjectModel;

public class Test {
public static void main(String[] args) {
	System.out.println(Calculator.calculate(new Add(), 5, 7));
	System.out.println(Calculator.calculate(new Substract(), 5, 7));
	System.out.println(Calculator.calculate(new Multiply(), 5, 7));
}
}

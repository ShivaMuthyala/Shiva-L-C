package JavaAssignment3;

public class Manager extends Employee {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Manager(String name, String id, int salary) {
		super(name, id, salary);
	}

	@Override
	public double calculateBonus() {

		return super.calculateBonus() + 5000;
	}
}

package JavaAssignment3;

import java.io.IOException;
import java.io.Serializable;

public class Employee implements Payable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String id;
	private int salary;

	public Employee(String name, String id, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String displayEmployeeDetails() {
		String details = "Employee ID: " + id + "\n" + "Name: " + name + "\n" + "Salary: ₹" + salary + "\n" + "Bonus: ₹"
				+ calculateBonus() + "\n" + "Net Payable: ₹" + payable();
		return details;
	}

	public double calculateBonus() {
		return salary * 0.1;
	}

	@Override
	public double payable() {
		return salary + calculateBonus();
	}

	public void saveEmployeeDetailsToFile(String Filename) throws IOException {
		FileSaver.employeeDetailsSaver(Filename, displayEmployeeDetails());
	}

	@Override
	public String toString() { // added since java directly calls default Object reference
		return "Employee ID: " + id + "\nName: " + name + "\nSalary: ₹" + salary + "\nBonus: ₹" + calculateBonus()
				+ "\nNet Payable: ₹" + payable();
	}

}

package JavaAssignment3;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String fileName = "Shiva.txt";
		String serializedFileName = "Shiva Serialized.txt";
		Manager m = new Manager("Shiva", "WELL-1", 1543547);
		try {
			if (m.getSalary() < 0) {
				throw new Exception("Cannot populate information with negative salary");
			}
			m.displayEmployeeDetails();
			m.saveEmployeeDetailsToFile(fileName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		FileSaver.readEmployeeDetails(fileName);
		Serialize.serializeData(m, serializedFileName);
		Employee deserializedEmployee = Serialize.deserializedata(serializedFileName);
		deserializedEmployee.displayEmployeeDetails();
	}
}

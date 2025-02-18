package JavaAssignment3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialize {
	public static void serializeData(Employee emp, String fileName) throws IOException {
		FileOutputStream Fout = new FileOutputStream(fileName);
		ObjectOutputStream Oout = new ObjectOutputStream(Fout);
		Oout.writeObject(emp);
		Oout.close();
		Fout.close();
		System.out.println("Serialization completed");
	}

	public static Employee deserializedata(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream Fin = new FileInputStream(fileName);
		ObjectInputStream Oin = new ObjectInputStream(Fin);
		Employee emp = (Employee) Oin.readObject();
		Oin.close();
		Fin.close();
		System.out.println("The deserialized data from " + fileName + " is \n" + emp);
		return emp;
	}
}

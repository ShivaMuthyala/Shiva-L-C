package JavaAssignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileSaver {
	public static void employeeDetailsSaver(String filename, String data) throws IOException {
		File file = new File(filename);
		if (!file.exists()) {
			file.createNewFile();
		}

		try (FileOutputStream fos = new FileOutputStream(file)) {
			fos.write(data.getBytes());
			System.out.println("Data written to file: " + filename);
		}

	}

	public static void readEmployeeDetails(String filename) throws IOException {
		File file = new File(filename);
		if (!file.exists()) {
			System.out.println("File not found: " + filename);
			return;
		}
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;

		System.out.println("Reading file contents of " + filename + ":");
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}

		br.close();
	}
}

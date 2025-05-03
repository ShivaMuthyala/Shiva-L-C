package GeoLocation;

import java.io.IOException;
import java.util.Scanner;

public class GeoCodingApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a place: ");
		String place = scanner.nextLine();
		scanner.close();

		GeoCodingService geocodingService = new GeoCodingService();

		try {
			geocodingService.getCoordinatesForPlace(place);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}

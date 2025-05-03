package GeoLocation;

public class GeoLocation {
	private double latitude;
	private double longitude;

	public GeoLocation(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return "Latitude: " + latitude + ", Longitude: " + longitude;
	}
}

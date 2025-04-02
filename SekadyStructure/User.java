package sekadyStructure;

abstract class User {
	private String name;
	private String email;
	private String contactNumber;
	private String userType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	public void displayDetails() {
		System.out.println(getName());
		System.out.println(getEmail());
		System.out.println(getContactNumber());
	}
}

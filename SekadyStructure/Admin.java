package sekadyStructure;

public class Admin extends User {
	private Builder builder;
	private Title title;

	public Admin() {
		setName("Admin");
		setEmail("Admin@gamil.com");
		setContactNumber("0935735Admin");
		setUserType("Admin");

	}



	public void getBuilderDetails() {
		builder.displayDetails();
	}

	public void getTitleDetails() {
		title.displayDetails();
	}

}

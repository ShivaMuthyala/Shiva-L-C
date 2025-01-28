package sekadyStructure;

public class Admin extends User{
	private Builder builder;
	private Title title;
	public Admin() {
		setName("Admin");
		setEmail("Admin@gamil.com");
		setContactNumber("0935735Admin");
		setUserType("Admin");


	}
	public void displayAdminDetails() {
		System.out.println(getName());
		System.out.println(getEmail());
		System.out.println(getContactNumber());
	}
	
	public void getBuilderDetails() {
		builder.displayBuilderDetails();
	}
	public void getTitleDetails() {
		title.displayTitleDetails();
	}

	}


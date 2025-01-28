package sekadyStructure;

public class Builder extends User {

	private ConnectionRequest connectionrequest = new ConnectionRequest();
	Title title = new Title();

	public Builder() {
		setName("Builder");
		setEmail("Builder@gmail.com");
		setContactNumber("0935735Builder");
		setUserType("Builder");

	}

	public void displayBuilderDetails() {
		System.out.println(getName());
		System.out.println(getEmail());
		System.out.println(getContactNumber());
	}

	public void getTitleDetail() {

		if (connectionrequest.connectionBuilderToTitle == true && connectionrequest.connectionTitleToBuilder == true) {
			title.displayTitleDetails();
		} else {
			if (connectionrequest.connectionBuilderToTitle == false) {
				System.out.println("Builder has not created connection");
			} else {
				System.out.println("Title has not created connection");
			}
		}
	}

}

package sekadyStructure;

public class Title extends User {

	public Title() {
		setName("Shankar");
		setEmail("Title@gamil.com");
		setContactNumber("0935735Title");
		setUserType("Title");

	}

	public void displayTitleDetails() {
		System.out.println(getName());
		System.out.println(getEmail());
		System.out.println(getContactNumber());
		System.out.println(getUserType());
	}

	private ConnectionRequest connectionrequest = new ConnectionRequest();

	public void getBuildersDetail() {

		Builder b = new Builder();

		if (connectionrequest.connectionBuilderToTitle == true && connectionrequest.connectionTitleToBuilder == true) {
			b.displayBuilderDetails();
		} else {
			if (connectionrequest.connectionBuilderToTitle == false) {
				System.out.println("Builder has not created connection");
			} else {
				System.out.println("Title has not created connection");
			}
		}
	}

}

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

	

	public void getTitleDetail() {

		if (!connectionRequest.isBuilderConnectedToTitle) {
			System.out.println("Builder has not created connection");
			return;
		}
		if (!connectionRequest.isTitleConnectedToBuilder) {
			System.out.println("Title has not created connection");
			return;
		}
		title.displayDetails();
	}

}

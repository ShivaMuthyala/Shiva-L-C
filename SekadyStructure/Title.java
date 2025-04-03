package sekadyStructure;

public class Title extends User {

	public Title() {
		setName("Shankar");
		setEmail("Title@gamil.com");
		setContactNumber("0935735Title");
		setUserType("Title");

	}


	private ConnectionRequest connectionrequest = new ConnectionRequest();

	public void getBuildersDetail() {

		Builder builder = new Builder();
		if (!connectionRequest.isBuilderConnectedToTitle) {
			System.out.println("Builder has not created connection");
			return;
		}
		if (!connectionRequest.isTitleConnectedToBuilder) {
			System.out.println("Title has not created connection");
			return;
		}
		builder.displayDetails();
		
	}

}

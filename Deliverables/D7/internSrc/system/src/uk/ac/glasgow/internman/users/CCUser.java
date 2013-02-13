package uk.ac.glasgow.internman.users;

public class CCUser extends User {
	
	private final String userType = "coordinator";

	public CCUser(String ID, String password, String forename,
			String surname, String email) {
		
		super(ID, password, forename, surname, email);
	}
}
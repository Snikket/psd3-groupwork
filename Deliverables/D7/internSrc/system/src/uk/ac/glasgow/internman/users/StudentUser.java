package uk.ac.glasgow.internman.users;

import uk.ac.glasgow.internman.Internship;
import uk.ac.glasgow.internman.Student;

public class StudentUser extends User implements Student {
	
	private final String userType = "student";

	public StudentUser(String ID, String password, String forename,
			String surname, String email) {
		
		super(ID, password, forename, surname, email);
	}

	public Internship getInternship() {
		return null;
	}

	public String getSurname() {
		return this.getSurname();
	}

	public String getMatriculation() {
		return this.getID();
	}

	public String getForename() {
		return this.getForename();
	}

	public String getEmail() {
		return this.getEmail();
	}

	public Programme getProgramme() {
		return null;
	}
}
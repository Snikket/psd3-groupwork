package uk.ac.glasgow.internman.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uk.ac.glasgow.internman.Internship;
import uk.ac.glasgow.internman.Student;

public class StudentUser extends User implements Student {
	
	private List<Internship> internship = new ArrayList<Internship>();

	public StudentUser(String ID, String password, String forename,
			String surname, String email) {
		
		super(ID, password, forename, surname, email);
	}

	public String getUserType(){
		return "student";
	}	
	
	public List<Internship> getInternship() {
		return this.internship;
	}

	public String getSurname() {
		return super.getSurname();
	}

	public String getMatriculation() {
		return super.getID();
	}

	public String getForename() {
		return super.getForename();
	}

	public String getEmail() {
		return super.getEmail();
	}

	public Programme getProgramme() {
		return null;
	}
	
	//public void setInternship(Integer ID, Internship i){
	//	this.internship = i;
	//}
	
}
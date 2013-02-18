package uk.ac.glasgow.Utility;

import java.io.Serializable;

import uk.ac.glasgow.Utility.User;
import uk.ac.glasgow.internman.Student;
import uk.ac.glasgow.internman.Internship;
import uk.ac.glasgow.internman.InternshipImpl;


public class StudentImpl extends User implements Student, Serializable {
	static final long serialVersionUID = 2L;
   private String status;
   private String email;
   private String program;
   private Internship internship;
   
   public StudentImpl(String surname, String forename, String GUID, String password, String user_level, String status, String email, String program) {
	  super(surname, forename, GUID, password, user_level);
      this.status = status;
      this.email = email;
      this.program = program;
      this.internship = new InternshipImpl();
   }

   public String getStatus() {
      return status;
   }

	public String getEmail() {
		return email;
	}

	public String getProgramme() {
		return program;
	}
	
	public void setInternship(Internship internship) {
		this.internship = internship;  
	}
	
	public Internship getInternship() {
		return internship;
	}

}
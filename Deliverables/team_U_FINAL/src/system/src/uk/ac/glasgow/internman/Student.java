package uk.ac.glasgow.internman;

import uk.ac.glasgow.internman.Internship;

public interface Student {

	Internship getInternship();

	String getSurname();

	String getMatriculation();

	String getForename();

	String getEmail();

	String getProgramme();
	
	void setInternship(Internship internship);

}

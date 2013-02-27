package uk.ac.glasgow.internman;

import java.util.List;
import java.util.Map;

import uk.ac.glasgow.internman.Internship;

public interface Student {
	
	public enum Programme {
		ESE,SE,CS3H,CS3
	}

	List<Internship> getInternship();

	String getSurname();

	String getMatriculation();

	String getForename();

	String getEmail();

	Programme getProgramme();
}

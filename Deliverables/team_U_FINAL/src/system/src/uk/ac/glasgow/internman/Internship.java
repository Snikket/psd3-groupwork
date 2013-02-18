package uk.ac.glasgow.internman;

import uk.ac.glasgow.AdvertisementManagement.Role;
import uk.ac.glasgow.AdvertisementManagement.Employer;

public interface Internship {

	public enum InternshipStatus {
		APPLYING, WITHDRAWN, ACCEPTED, APPROVED
	}
	
	String getManager();

	String getManagerEmail();

	boolean isVisitComplete();

	Employer getEmployer();

	Role getRole();

	InternshipStatus getStatus();

	Visit getVisit();
	
	void setVisit(Visit visit);

}

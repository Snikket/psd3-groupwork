package uk.ac.glasgow.internman;

import java.io.Serializable;

import uk.ac.glasgow.AdvertisementManagement.Employer;
import uk.ac.glasgow.AdvertisementManagement.Role;

public class InternshipImpl implements Internship, Serializable {
	static final long serialVersionUID = 10L;
	
	String managerName;
	String managerEmail;
	Employer employer;
	Role role;
	InternshipStatus status;
	Visit visit;
	
	public InternshipImpl() {}
	
	public String getManager() {
		return managerName;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public boolean isVisitComplete() {
		return !(visit == null);
	}

	public Employer getEmployer() {
		return employer;
	}

	public Role getRole() {
		return role;
	}

	public InternshipStatus getStatus() {
		return status;
	}

	public Visit getVisit() {
		return visit;
	}
	
	public void setVisit(Visit visit) {
		this.visit = visit;
	}

}

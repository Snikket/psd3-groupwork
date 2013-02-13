package uk.ac.glasgow.internman.impl;

import java.util.Date;
import java.util.Map;

import uk.ac.glasgow.internman.Advertisement;
import uk.ac.glasgow.internman.Employer;
import uk.ac.glasgow.internman.Role;
import uk.ac.glasgow.internman.Advertisement.AdvertisementStatus;

public class Advert implements Advertisement {
	
	private static int IDCount = 0;
	
	private int ID;
	private Role roles = null;
	private Employer employer = null;
	private AdvertisementStatus status = null;
	private String details = null;
	private String comments = null;
	
	public Advert (String cD){
		this.details = cD;
		this.IDCount++;
		this.ID = this.IDCount;
		
	}
	
	public Integer getID() {
		return this.ID;
	}
	
	public Map<Integer, Role> getRoles(){
		return null;
	}

	public Employer getEmployer(){
		return this.employer;
	}

	public String getApplicationDetails(){
		return this.details;
	}

	public String getComments(){
		return this.comments;
	}

	public AdvertisementStatus getStatus(){
		return this.status;
	}
	
	//public void setStatus(AdvertisementStatus status){
	//	
	//}

	public Role addNewRole(String title, String location, Date start, Date end, String description, Double salary) {
		return null;
	}
}

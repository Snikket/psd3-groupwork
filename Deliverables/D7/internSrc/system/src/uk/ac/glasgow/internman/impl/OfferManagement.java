package uk.ac.glasgow.internman.impl;

import java.util.HashMap;
import java.util.Map;

import uk.ac.glasgow.internman.Internship.InternshipStatus;
import uk.ac.glasgow.internman.Employer;
import uk.ac.glasgow.internman.Role;
import uk.ac.glasgow.internman.stores.AdvertStore;
import uk.ac.glasgow.internman.stores.UserStore;
import uk.ac.glasgow.internman.stores.UserStoreImpl;
import uk.ac.glasgow.internman.users.EmployerUser;
import uk.ac.glasgow.internman.users.User;
import uk.ac.glasgow.internman.stores.OfferStore;

public class OfferManagement {
	
	private OfferStore OS;
	
	public OfferManagement(){
		
	}
	
	//public void acceptOffer(){
	//	OS.getOffer(ID).setStatus(InternshipStatus.ACCEPTED);
	//}
	
	public void approveAcceptedOffer(String matriculation){
		
	}
	
	
}

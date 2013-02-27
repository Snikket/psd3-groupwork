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
		this.OS = new OfferStore("offer_store.txt");
	}
	
	public Offer createOffer(Role role, String manager, String managerEmail, Employer employer){
		return new Offer(role, manager, managerEmail, employer);
	}
	
	public Offer getOffer(Integer ID){
		return OS.getOffer(ID);
	}
	
	public void acceptOffer(Integer ID){
		Offer offer = OS.getOffer(ID);
		offer.setStatus(InternshipStatus.ACCEPTED);
		this.storeOffer(offer);
	}
	
	public void approveAcceptedOffer(Integer ID){
		Offer offer = OS.getOffer(ID);
		offer.setStatus(InternshipStatus.APPROVED);
		this.storeOffer(offer);
	}
	
	public void storeOffer(Offer o){
		this.OS.addOffer(o);
	}
	
}

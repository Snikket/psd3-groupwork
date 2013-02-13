package uk.ac.glasgow.internman.impl;

import java.util.HashMap;
import java.util.Map;

import uk.ac.glasgow.internman.Advertisement.AdvertisementStatus;
import uk.ac.glasgow.internman.Employer;
import uk.ac.glasgow.internman.Role;
import uk.ac.glasgow.internman.stores.AdvertStore;
import uk.ac.glasgow.internman.stores.UserStore;
import uk.ac.glasgow.internman.stores.UserStoreImpl;
import uk.ac.glasgow.internman.users.EmployerUser;
import uk.ac.glasgow.internman.users.User;

public class AdvertManagement {
	
	private AdvertStore AD;
	
	public AdvertManagement(){
		
	}
	
	public Advert getAdvert(Integer ID){
		return AD.getAdvert(ID);
	}
	
	public Map getAdverts(String userType){
		
		Map<Integer, Advert> filteredAdverts = new HashMap<Integer,Advert>();
		
		for (Integer ID : AD.getAdverts().keySet()){
			if (userType == "GU" || userType == "Student" && AD.getAdvert(ID).getStatus() == AdvertisementStatus.PUBLISHED){
				filteredAdverts.put(ID,AD.getAdvert(ID));
			}
			if (userType == "CourseCoordinator"){
				filteredAdverts.put(ID, AD.getAdvert(ID));
			}
			else{
				System.out.print("AHHHHH");
			}				
		}		
		return filteredAdverts;
	}
	
	public Advert createAdvert(Map advertDetails){
		return null;
	}
	
	public void removeAdvert(Integer ID){
		AD.removeAdvert(ID);
	}
	
	public void storeAdvert(Advert a){
		AD.addAdvert(a);
	}
	
	public void publishAdvert(Integer ID, String comment){
		Advert advert = AD.getAdvert(ID);
		advert.setStatus(AdvertisementStatus.PUBLISHED);					
	}
	
	public Role selectRole(Integer ID, Integer roleIndex){
		return null;
	}	

}

package uk.ac.glasgow.Utility;
import java.util.Map;

import uk.ac.glasgow.AdvertisementManagement.Advertisement;
import uk.ac.glasgow.internman.Student;

public abstract interface UtilityAPI {
	
	boolean login (String username, String password);
	
	boolean logout ();
	
	boolean isLogged ();
	
	User getCurrentUser ();
        
        UserStore getStore();
	
	String userLevel ();
	
	Map<Integer, Advertisement> displayAdvertisementSummary();
	
	Map<String, Student> displayStudentSummary();
}

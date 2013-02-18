package uk.ac.glasgow.Utility;

import java.util.Map;
import uk.ac.glasgow.internman.Student;

public interface UserStore {
	
	/**
	 * Adds a new user to the store.
	 * @param surname
	 * @param GUID
	 * @param forename
	 * @param password
	 */
	public void addUser(
			User user);
		
	/**
	 * Returns a user specified by the GUID, if authentication is
	 * successful.
	 * 
	 * @param GUID
	 *            the user's GUID
	 * @param password
	 *            the user's password
	 * @return the user specified by the GUID, if the password
	 * matches that of
	 *         the user.
	 */
	public User getUser(String GUID, String password);
        
    public Map<String, User> getUsers();
    
    public Map<String, Student> getStudents();
	
}

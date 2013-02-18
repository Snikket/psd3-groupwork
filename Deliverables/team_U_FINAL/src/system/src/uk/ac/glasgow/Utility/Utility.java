package uk.ac.glasgow.Utility;

import java.util.Map;
import java.util.HashMap;

import uk.ac.glasgow.AdvertisementManagement.Advertisement;
import uk.ac.glasgow.internman.Student;
import uk.ac.glasgow.internman.Visit;

public class Utility implements UtilityAPI {
	private UserStore users = new UserStoreImpl("data/users.obj");
	private User current_user = null;

	public Utility() {
		//users.addUser(new User("storer", "tim", "tws", "1234", "coursecoordinator"));
		//users.addUser(new StudentImpl("Leikus", "Gediminas", "1005031l", "031l", "student", "n", "gediminas.leikus@gmail.com", "CS"));
	}
	
	public boolean login (String username, String password) {
		if (isLogged()) {
			return false;
		}
		current_user = users.getUser(username, password);
		if (isLogged()) {
			return true;
		}
		return false;
	}
	
	public boolean logout () {
		if (isLogged()) {
			return false;
		}
		current_user = null;
		return true;
	}
	
	public boolean isLogged () {
		if (current_user == null) {
			return false;
		}
		return true;
	}
	
	public User getCurrentUser() {
		if (isLogged()) {
                    return current_user;
		}
                return null;
		
	}
        
        public UserStore getStore(){
            return users;
        }
	
	public String userLevel () {
		if (isLogged()) {
			return current_user.getLevel();
		}
		return "guest";
	}
	
	public boolean setVisit(String matriculation, Visit visit) {
		Student student = displayStudentSummary().get(matriculation);
		if (student != null) {
			student.getInternship().setVisit(visit);
			return true;
		}
		return false;
	}
	
	public Map<Integer, Advertisement> displayAdvertisementSummary() {
		if (isLogged()) {
			Map<Integer, Advertisement> result = new HashMap<Integer, Advertisement>();
			return result;
		}
		return null;
	}
	
	public Map<String, Student> displayStudentSummary() {
		if ((isLogged())&&(current_user.getLevel().compareTo("coursecoordinator") == 0)) {
			return users.getStudents();
		}
		return null;
	}
}

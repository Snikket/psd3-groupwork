package uk.ac.glasgow.internman.impl;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import uk.ac.glasgow.internman.Advertisement;
import uk.ac.glasgow.internman.Employer;
import uk.ac.glasgow.internman.InternMan;
import uk.ac.glasgow.internman.Role;
import uk.ac.glasgow.internman.Student;
import uk.ac.glasgow.internman.UoGGrade;

import uk.ac.glasgow.internman.users.User;

/**
 * A stub class that implements the InternMan facade without providing any
 * actual functionality (except permitting logging in and out). The class should
 * be replaced by a real implementation once development begins.
 * 
 * @author Cowboy
 * 
 */
public class InternManStub implements InternMan {

	private UserManagement UM;
	//private AdvertStore adverts;
	private AdvertManagement AD;
	
	private User currentUser;
	
	public InternManStub(){
		this.UM = new UserManagement();
	}
	
	@Override
	public boolean login(String userName, String password) {
		
		if (UM.login(userName, password)){
			this.currentUser = UM.getUser(userName);
			return true;
		}
		else
			return false;
	}

	@Override
	public User getCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Advertisement> getAdvertisements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Student> getStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employer registerNewEmployer(String name, String emailAddress) {
		UM.registerNewEmployer(name, emailAddress);
		return null;
	}

	@Override
	public Advertisement createNewAdvertisement(String applicationDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Advertisement selectAdvertisement(Integer index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role selectRole(Integer advertisementIndex, Integer roleIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student selectStudent(String matriculation) {
		UM.getUser(matriculation);
		return null;
	}

	@Override
	public void publishAdvertisement(Integer advertisementIndex, String comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyAcceptedOffer(Role role, String managerName, String managerEmail) {
		
		System.out.println("Notification email sent to " + managerEmail);		
	}

	@Override
	public void approveAcceptedOffer(String matriculation) {
		
	}

	@Override
	public void assignAcademicVisitor(String matriculation, String visitorName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recordVisitAssessment(String matriculation, UoGGrade grade,
			String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employer getCurrentEmployer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role createNewSelfSourcedRole(String title, String location,
			Date start, Date end, String description, Double salary) {
		// TODO Auto-generated method stub
		return null;
	}
}

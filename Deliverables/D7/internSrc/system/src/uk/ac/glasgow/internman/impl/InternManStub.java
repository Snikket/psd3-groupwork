package uk.ac.glasgow.internman.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import uk.ac.glasgow.internman.Advertisement;
import uk.ac.glasgow.internman.Advertisement.AdvertisementStatus;
import uk.ac.glasgow.internman.Employer;
import uk.ac.glasgow.internman.InternMan;
import uk.ac.glasgow.internman.Internship;
import uk.ac.glasgow.internman.Internship.InternshipStatus;
import uk.ac.glasgow.internman.Role;
import uk.ac.glasgow.internman.Student;
import uk.ac.glasgow.internman.UoGGrade;

import uk.ac.glasgow.internman.users.*;

/**
 * A stub class that implements the InternMan facade without providing any
 * actual functionality (except permitting logging in and out). The class should
 * be replaced by a real implementation once development begins.
 * 
 * @author Cowboy
 * 
 */
public class InternManStub implements InternMan {

	// User Management Component
	private UserManagement UM;
	
	// Advert Management Component
	private AdvertManagement AM;
	
	// Offer Management Component
	private OfferManagement OM;
	
	// Current logged in user
	private User currentUser = null;
	
	// Current selected employer
	private Employer currentEmployer = null;
	
	public InternManStub(){
		this.UM = new UserManagement();
		this.AM = new AdvertManagement();
		this.OM = new OfferManagement();
	}
	
	@Override
	public boolean login(String userName, String password) {
		
		if (UM.login(userName, password)){
			this.currentUser = UM.getUser(userName);
			if (this.currentUser.getUserType() == "employer")
				this.currentEmployer = (Employer)this.currentUser;
			return true;
		}
		else
			return false;
	}

	@Override
	public User getCurrentUser() {
		return this.currentUser;
	}

	@Override
	public Map<Integer, Advertisement> getAdvertisements() {
		
		// create filter
		Map<String, String> filter = new HashMap<String,String>();
		
		// check usertype of current user & set filter accordingly
		User user = this.currentUser;
		String userType = user.getUserType();
		
		// set filter depending on usertype
		if (userType == "employer"){
			EmployerUser employer = (EmployerUser)user;
			filter.put("userType", "employer");
			filter.put("employerName", employer.getName());
		}
		
		if (userType == "student"){
			StudentUser student = (StudentUser)user;
			filter.put("userType", "student");
			filter.put("employerName", null);
		}
		
		if (userType == "coordinator"){
			CCUser coordinator = (CCUser)user;
			filter.put("userType", "coordinator");
			filter.put("employerName", null);
		}	
		
		return AM.getAdverts(filter);
	}

	@Override
	public Map<String, Student> getStudents() {
		
		return UM.getUsers("student");

	}

	@Override
	public Employer registerNewEmployer(String name, String emailAddress) {
		
		if (this.currentUser.getUserType() != "coordinator")
			return null;
		
		return UM.registerNewEmployer(name, emailAddress);
	}

	@Override
	public Advertisement createNewAdvertisement(String applicationDetails) {
		
		if (this.currentUser.getUserType() == "student")
			return null;
		
		if (this.currentUser.getUserType() == "employer"){
			return AM.createAdvert(applicationDetails, (EmployerUser)this.currentUser);
		}
			
		if (this.currentUser.getUserType() == "coordinator"){
			return AM.createAdvert(applicationDetails, null);
		}
		
		return null;
	}

	@Override
	public Advertisement selectAdvertisement(Integer index) {
		
		//get advert
		Advertisement advert = AM.getAdvert(index);
		// get advert's employer
		String empName = advert.getEmployer().getName();
		
		// get advert status
		AdvertisementStatus status = advert.getStatus();
		
		// get current user
		User user = this.currentUser;
		
		// get current user's type
		String userType = user.getUserType();
			
		if (userType == "employer"){
			Employer employer = (EmployerUser)user;
			if (employer.getName() != empName)
				return null;
		}
		
		if (userType == "student"){
			if (status != AdvertisementStatus.PUBLISHED)
				return null;
		}
		
		return AM.getAdvert(index);
	}

	@Override
	public Role selectRole(Integer advertisementIndex, Integer roleIndex) {
		
		Advert advert = AM.getAdvert(advertisementIndex);
		String empName = advert.getEmployer().getName();
		AdvertisementStatus status = advert.getStatus();
		
		// Set currently selected employer
		this.currentEmployer = advert.getEmployer();
		
		User user = this.currentUser;
		String userType = user.getUserType();
		
		if (userType == "student" && status != AdvertisementStatus.PUBLISHED){
			return null;
		}
		if (userType == "employer"){
			Employer employer = (EmployerUser)user;
			if (employer.getName() != empName){
				return null;
			}
		}	
		
		return AM.getAdvert(advertisementIndex).getRoles().get(roleIndex);
	}

	@Override
	public Student selectStudent(String matriculation) {
	
		if (this.currentUser.getUserType() != "coordinator")
			return null;
		
		StudentUser student = (StudentUser) UM.getUser(matriculation);
		
		return (Student)UM.getUser(matriculation);
	}

	@Override
	public void publishAdvertisement(Integer advertisementIndex, String comment) {
		
		if (this.currentUser.getUserType() != "coordinator")
			return;
		
		AM.publishAdvert(advertisementIndex, comment);
		System.out.println("Notification email sent to " 
		+ AM.getAdvert(advertisementIndex).getEmployer().getEmailAddress());
		
	}

	@Override
	public void notifyAcceptedOffer(Role role, String managerName, String managerEmail) {
		if (this.currentUser.getUserType() != "student")
			return;
		
		Offer offer = this.OM.createOffer(role, managerName, managerEmail, this.currentEmployer);
		this.OM.storeOffer(offer);
		this.OM.acceptOffer(offer.getID());
		
		StudentUser student = (StudentUser)this.currentUser;
		student.setInternship(offer);
		this.UM.storeUser(student);
		
		System.out.println("Notification email sent to " + managerEmail);		
	}

	@Override
	public void approveAcceptedOffer(String matriculation) {
		
		if (this.currentUser.getUserType() != "coordinator")
			return;
		
		StudentUser student = (StudentUser) UM.getUser(matriculation);		
		
		System.out.println(student.getInternship());
		
		if (student.getInternship().getStatus() != InternshipStatus.ACCEPTED)
			return;
		
		((Offer) student.getInternship()).setStatus(InternshipStatus.APPROVED);
		((Offer) student.getInternship()).getRole().setApproved(true);
		
		this.UM.storeUser(student);
		
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
		return this.currentEmployer;
	}

	@Override
	public Role createNewSelfSourcedRole(String title, String location,
			Date start, Date end, String description, Double salary) {
		// TODO Auto-generated method stub
		return null;
	}
}

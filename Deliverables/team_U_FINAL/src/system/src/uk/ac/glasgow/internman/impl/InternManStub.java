package uk.ac.glasgow.internman.impl;

import java.util.Date;
import java.util.Map;

import uk.ac.glasgow.AdvertisementManagement.Advertisement;
import uk.ac.glasgow.AdvertisementManagement.AdvertisementStoreImpl;
import uk.ac.glasgow.AdvertisementManagement.Employer;
import uk.ac.glasgow.internman.InternMan;
import uk.ac.glasgow.AdvertisementManagement.Role;
import uk.ac.glasgow.OfferManagement.Offer;
import uk.ac.glasgow.OfferManagement.OfferStoreImpl;
import uk.ac.glasgow.internman.Student;
import uk.ac.glasgow.internman.UoGGrade;
import uk.ac.glasgow.Utility.UtilityAPI;
import uk.ac.glasgow.Utility.Utility;
import uk.ac.glasgow.VisitManagement.VisitAPI;
import uk.ac.glasgow.VisitManagement.VisitAPIImpl;
import uk.ac.glasgow.Utility.User;
import uk.ac.glasgow.AdvertisementManagement.Internship;

/**
 * A stub class that implements the InternMan facade without providing any
 * actual functionality (except permitting logging in and out). The class should
 * be replaced by a real implementation once development begins.
 * 
 * @author Cowboy
 * 
 */
public class InternManStub implements InternMan {
	private UtilityAPI utilityComponent = new Utility();
	private VisitAPI visitComponent = new VisitAPIImpl();
	
	public InternManStub(){}   
	
	@Override
	public boolean login(String userName, String password) {
		return utilityComponent.login(userName, password);
	}

	@Override
	public User getCurrentUser() {
		return utilityComponent.getCurrentUser();
	}

	@Override
	public Map<Integer, Advertisement> getAdvertisements() {
		AdvertisementStoreImpl adStore = new AdvertisementStoreImpl("data/adverts.obj");
                return adStore.getAdverts();
	}

	@Override
	public Map<String, Student> getStudents() {
		return utilityComponent.displayStudentSummary();
	}

	@Override
	public Employer registerNewEmployer(String name, String emailAddress) {
            Employer e = new Employer(name, emailAddress, emailAddress, name);
            utilityComponent.getStore().addUser(new User(name, null, name, emailAddress, "Employer"));
            return e;
	}

	@Override
	public Advertisement createNewAdvertisement(String applicationDetails) {
		Advertisement adv = new Advertisement(applicationDetails); 
                
                return adv;
	}

	@Override
	public Advertisement selectAdvertisement(Integer index) {
		AdvertisementStoreImpl adStore = new AdvertisementStoreImpl("data/adverts.obj");
                return adStore.getAdvert(index);
	}

	@Override
	public Role selectRole(Integer advertisementIndex, Integer roleIndex) {
		AdvertisementStoreImpl adStore = new AdvertisementStoreImpl("data/adverts.obj");
                return adStore.getAdvert(advertisementIndex).getRoles().get(roleIndex);
	}

	@Override
	public Student selectStudent(String matriculation) {
		Map<String, Student> students = utilityComponent.displayStudentSummary();
		if (students == null) {
			return null;
		} 
		return students.get(matriculation);
	}

	@Override
	public void publishAdvertisement(Integer advertisementIndex, String comment) {
		Advertisement ad = selectAdvertisement(advertisementIndex);
                ad.setStatus(Advertisement.AdvertisementStatus.PUBLISHED);
                ad.setComments(comment);
		
	}

	@Override
	public void notifyAcceptedOffer(Role role, String managerName,
			String managerEmail) {
		System.out.println("Message sent to " + managerName + " at " + managerEmail);
		
	}

	@Override
	public void approveAcceptedOffer(String matriculation) {
	    OfferStoreImpl offers = new OfferStoreImpl("data/offers.obj");
            Offer offer = offers.getOffer(matriculation);
            offer.getInternship().setStatus(Internship.InternshipStatus.APPROVED);
		
	}

	@Override
	public void assignAcademicVisitor(String matriculation, String visitorName) {
		Map<String, Student> students = utilityComponent.displayStudentSummary();
		if (students == null) {
			return;
		}
		Student student = students.get(matriculation);
		if (student != null) {
			visitComponent.assignAcademicVisitor(student, visitorName, "");
		}
	}

	@Override
	public void recordVisitAssessment(String matriculation, UoGGrade grade,
			String description) {
		Map<String, Student> students = utilityComponent.displayStudentSummary();
		if (students == null) {
			return;
		}
		Student student = students.get(matriculation);
		if ((student != null)&&(student.getInternship().getVisit() != null)) {
			visitComponent.recordVisitAssessment(student, grade, description);
		}
	}

	@Override
	public Employer getCurrentEmployer() {
            if(utilityComponent.getCurrentUser().getLevel().equals("Employer")){
               return new Employer(utilityComponent.getCurrentUser().getMatriculation(), utilityComponent.getCurrentUser().getPassword(), utilityComponent.getCurrentUser().getPassword(), utilityComponent.getCurrentUser().getMatriculation());
            }
            else{
                return null;
            }
        }

	@Override
	public Role createNewSelfSourcedRole(String title, String location,
			Date start, Date end, String description, Double salary) {
		Role r = new Role(title, location, start, end , description, salary);
                return r;
	}
}

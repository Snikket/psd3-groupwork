package uk.ac.glasgow.internman.impl;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.glasgow.internman.Advertisement;
import uk.ac.glasgow.internman.Employer;
import uk.ac.glasgow.internman.Role;
import uk.ac.glasgow.internman.users.CCUser;
import uk.ac.glasgow.internman.users.EmployerUser;
import uk.ac.glasgow.internman.users.User;



public class InternManStubTest {
	private String username;
	private String password;
	private String ID;
	private String forename;
	private String surname;
	private String email;
	private String ccuser;
	private String ccpassword;
	InternManStub interfc;
	
	@Before
	public void setUp() throws Exception {
		username="user";
		password="pass";
		email="test@test.com";
		forename="Daniel";
		surname="Gonzales";
		ID="1000000";
		ccuser="tws";
		ccpassword="1234";
		interfc=new InternManStub();
	}
	
	@After
	public void tearDown() throws Exception 
	{
		username=null;
		password=null;
		interfc=null;
		email=null;
		forename=null;
		surname=null;
		ID=null;
		ccuser=null;
		ccpassword=null;
	}
	@Test
	public void loginTest(){
		assertTrue(interfc.login("tws", "1234"));
	}
	
	@Test
	public void getCurrentUserTest(){
		interfc.login("tws", "1234");
		assertTrue(interfc.getCurrentUser().getID()=="tws");
	}
	
	@Test
	public void RegisterNewEmployerTest() 
	{
		interfc.login("tws", "1234");
		Employer p= interfc.registerNewEmployer(username, email);
		Boolean result=(p instanceof Employer)&&(p.getEmailAddress().equals(email))&&(p.getName().equals(forename));
		assertTrue(result);
	}

	@Test
	public void createNewAdvertisementTest(){
		interfc.login("tws", "1234");
		Advertisement ad=interfc.createNewAdvertisement("Testing Data");
		assertTrue(ad!=null);
		
	}
	
	@Test
	public void selectAdvertisementTest(){
		interfc.login("tws", "1234");
		assertTrue(interfc.selectAdvertisement(1) instanceof Advertisement);
	}

	@Test
	public void selectRoleTest(){
		assertTrue(interfc.selectRole(1, 1) instanceof Role);
	}
	
	@Test
	public void selectStudentTest(){
		
	}

	@Test
	public void createNewSelfSourcedRoleTest(){
		String title="Test Engineer";
		String location="Glasgow";
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 6, 15); //year is as expected, month is zero based, date is as expected
		Date start=cal.getTime();
		cal.set(2013, 9, 15);
		Date end=cal.getTime();
		String description="Test description";
		Double salary=100.00;
		Role test=interfc.createNewSelfSourcedRole(title, location, start, end, description, salary);
		assertTrue(test instanceof Role);
		test=null;
	}
	
	/* @Test
	public void approveAcceptedOffer() {
		approveAcceptedOffer(student.getID());
	} */
	
	/*
	 * @Override
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
	public void publishAdvertisement(Integer advertisementIndex, String comment) {
		// TODO Auto-generated method stub
		
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
*/
	

}

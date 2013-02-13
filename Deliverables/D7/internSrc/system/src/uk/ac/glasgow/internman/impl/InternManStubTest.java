package uk.ac.glasgow.internman.impl;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.glasgow.internman.Advertisement;
import uk.ac.glasgow.internman.Employer;
import uk.ac.glasgow.internman.Role;
import uk.ac.glasgow.internman.Student;
import uk.ac.glasgow.internman.UoGGrade;
import uk.ac.glasgow.internman.users.User;

public class InternManStubTest {
	private String username;
	private String password;
	private String ID;
	private String forename;
	private String surname;
	private String email;
	InternManStub interfc;
	User student;
	
	@Before
	public void setUp() throws Exception {
		username="user";
		password="pass";
		email="test@test.com";
		forename="Daniel";
		surname="Gonzales";
		ID="1000000";
		//creating new student for testing
		student=new User(ID,password,forename, surname, email);
		interfc=new InternManStub();
	}
	
	@After
	public void tearDown() throws Exception 
	{
		username=null;
		password=null;
		interfc=null;
		student=null;
		email=null;
		forename=null;
		surname=null;
		ID=null;
	}
	//TODO Register new Student
	
	@Test
	public void RegisterNewEmployerTest() 
	{
		Employer p= interfc.registerNewEmployer(username, email);
		Boolean result=(p instanceof Employer)&&(p.getEmailAddress().equals(email))&&(p.getName().equals(forename));
		assertTrue(result);
	}
	
	@Test
	public void loginTest(){
		assertTrue(interfc.login(username, password));
	}

	@Test
	public void getCurrentUserTest(){
		User test=interfc.getCurrentUser();
		assertEquals(student,test);
	}

	@Test
	public void createNewAdvertisementTest(){
		Advertisement ad=interfc.createNewAdvertisement("Testing Data");
		assertEquals("Testing Data",ad.getApplicationDetails());
		
	}
	
	@Test
	public void selectAdvertisementTest(){
		interfc.login(username, password);
		assertTrue(interfc.selectAdvertisement(1) instanceof Advertisement);
	}

	@Test
	public void selectRoleTest(){
		assertTrue(interfc.selectRole(1, 1) instanceof Role);
	}
	
	@Test
	public void notifyAcceptedOfferTest() {
		String managerEmail="manager@test.com";
		notifyAcceptedOffer(role, managerName, managerEmail);
		final ByteArrayOutputStream printedContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(printedContent));
		assertEquals("Notification email sent to " + managerEmail, printedContent.toString());		
	}
	
	@Test
	public void selectStudentTest(){
		Student test=interfc.selectStudent(student.getID());
		assertTrue(student.equals(test));
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

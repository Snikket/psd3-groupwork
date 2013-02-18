package uk.ac.glasgow.Utility;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.glasgow.internman.InternMan;
import uk.ac.glasgow.internman.impl.InternManStub;


/*a class to test the functionality of the Utility component in the system*/
public class utilityTestClass {
	
	private static InternMan i;
	private static Utility u;
	private static UserStore user;
	 
	 @BeforeClass
	  public static void testSetup() {
	  //instantiate new facade instance to test upon
	   i = new InternManStub();
	   u = new Utility();
	   user = u.getStore();
	  }
	 
	
	/*test login for student already in store*/
	@Test
	public void testStudentLogin(){
		boolean result;
		result = i.login("1005031l", "031l");
		assertEquals("",true,result);
	}
	
	
	/*test login for company*/
	@Test
	public void testCompanyLogin(){
		boolean result;
		user = u.getStore();
		User t = new User("Smith", "IBM","089231x" , "12345", "company");
		user.addUser(t);
		result = i.login("089231x", "12345");
		assertEquals("",true,result);
	}
	
	
	/*test login for pre-existing coordinator*/
	@Test
	public void testAdminLogin(){
		boolean result;
		result = i.login("tws", "1234");
		assertEquals("",true,result);
	}
	
}
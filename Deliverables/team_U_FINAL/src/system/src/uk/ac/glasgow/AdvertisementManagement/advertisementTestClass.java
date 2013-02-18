package system.src.uk.ac.glasgow.AdvertisementManagement;

import java.util.Date;
import org.junit.BeforeClass;
import org.junit.Test;
import uk.ac.glasgow.AdvertisementManagement.Advertisement.AdvertisementStatus;
import uk.ac.glasgow.Utility.UserStore;
import uk.ac.glasgow.Utility.Utility;
import uk.ac.glasgow.internman.InternMan;
import uk.ac.glasgow.internman.impl.InternManStub;


public class advertisementTestClass {
	
	
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
	
	 /*test if a student can see a published advert*/
	@Test
	public void testStudentPublish(){
		Date d = new Date("12");
		Date d2 = new Date("15");
		Advertisement a = i.createNewAdvertisement("advertisement");
		a.addNewRole("advert", "London", d, d2, "this is an advert", 1230.0);

		Advertisement result = i.selectAdvertisement(0);
		assertEquals("","advertisement",result.getApplicationDetails());

	}
	
	
	 /*test the submission of an advert*/
	@Test
	public void testAdvertisementSubmit(){
		Date d = new Date("5");
		Date d2 = new Date("88");
		Advertisement a = i.createNewAdvertisement("another advertisement");
		a.addNewRole("advert", "Other location", d, d2, "another advert", 120.0);
		Advertisement result = i.selectAdvertisement(0);
		assertEquals("","another advertisement",result.getApplicationDetails());

	}
	
	
	 /*test the publication of an advert*/
		@Test
		public void testAdvertisementPublish(){
			Date d = new Date("6");
			Date d2 = new Date("16");
			Advertisement a = i.createNewAdvertisement("new advert");
			a.addNewRole("advert", "Newcastle", d, d2, "another advert", 9999.0);
			i.publishAdvertisement(0, "advertisement fit for publishing");
			assertEquals("",AdvertisementStatus.PUBLISHED,a.getStatus());
		
		}

}
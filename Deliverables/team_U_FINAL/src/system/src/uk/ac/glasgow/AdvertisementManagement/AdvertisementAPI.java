package uk.ac.glasgow.AdvertisementManagement;

public abstract interface AdvertisementAPI {
	public Employer registerNewEmployer ( String name, String emailAddress );
	
	public Advertisement selectAdvertisement( Integer index );
	
	public void reviseAdvertisement( Advertisement revised );
	
	public Advertisement createNewAdvertisement ( String employerContact, String location, String howToApply, String ccComment );
	
	public Role selectRole ( Integer advertisementIndex, Integer roleIndex );
	
	public void reviseRole( Role revised );
	
	public void addNewRole ( Integer adId, String title, String dateStart, String dateEnd, String description, Double salary, boolean approvedSesp );
	
	public void publishAdvertisement ( Integer advertisementIndex, String comment );
	
}

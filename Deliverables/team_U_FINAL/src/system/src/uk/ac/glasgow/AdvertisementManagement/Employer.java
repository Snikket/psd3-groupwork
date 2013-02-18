package uk.ac.glasgow.AdvertisementManagement;
import java.io.Serializable;
import java.util.*;
import uk.ac.glasgow.Utility.User;

public class Employer extends User implements Serializable{
	static final long serialVersionUID = 3L;
   private int employer_id;
   private String login;
   private String password;
   private Company Company;
   private String emailAddress;
   private String name;
   
   public java.util.Collection<Advertisement> advertisement;
   

    public Employer(String login, String password,  String emailAddress, String name) {
        super(name, name, login, password, "Employer");
        this.login = login;
        this.password = password;
        Company = null;
        this.emailAddress = emailAddress;
        this.name = name;
    }
   public java.util.Collection<Advertisement> getAdvertisement() {
      if (advertisement == null)
         advertisement = new java.util.HashSet<Advertisement>();
      return advertisement;
   }
   
   public java.util.Iterator getIteratorAdvertisement() {
      if (advertisement == null)
         advertisement = new java.util.HashSet<Advertisement>();
      return advertisement.iterator();
   }
   
     /* @param newAdvertisement */
   public void setAdvertisement(java.util.Collection<Advertisement> newAdvertisement) {
      removeAllAdvertisement();
      for (java.util.Iterator iter = newAdvertisement.iterator(); iter.hasNext();)
         addAdvertisement((Advertisement)iter.next());
   }
   
     /* @param newAdvertisement */
   public void addAdvertisement(Advertisement newAdvertisement) {
      if (newAdvertisement == null)
         return;
      if (this.advertisement == null)
         this.advertisement = new java.util.HashSet<Advertisement>();
      if (!this.advertisement.contains(newAdvertisement))
         this.advertisement.add(newAdvertisement);
   }
   
    /* @param oldAdvertisement */
   public void removeAdvertisement(Advertisement oldAdvertisement) {
      if (oldAdvertisement == null)
         return;
      if (this.advertisement != null)
         if (this.advertisement.contains(oldAdvertisement))
            this.advertisement.remove(oldAdvertisement);
   }
   
   public void removeAllAdvertisement() {
      if (advertisement != null)
         advertisement.clear();
   }

public String getName() {
	return name;
}

public String getEmailAddress() {
	return emailAddress;
}

}
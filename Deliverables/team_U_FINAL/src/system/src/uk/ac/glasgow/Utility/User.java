package uk.ac.glasgow.Utility;

import java.io.Serializable;

public class User implements Serializable {
	static final long serialVersionUID = 1L;

   private String surname;
   private String forename;
   private String GUID;
   private String password;
   private String user_level;
      
   public User (String surname, String forename, String GUID, String password, String user_level){
      this.surname = surname;
      this.forename = forename;
      this.GUID = GUID;
      this.password = password;
      this.user_level = user_level;
   }

   protected boolean authenticate (String password){
      return this.password.equals(password);
   }

   public String getSurname() {
      return surname;
   }

   public String getForename() {
      return forename;
   }

   public String getMatriculation() {
      return GUID;
   }
   
   public String getLevel() {
      return user_level;
   }
   
   public String getPassword(){
       return password;
   }

}
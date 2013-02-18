package uk.ac.glasgow.AdvertisementManagement;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Advertisement implements Serializable{
    private String applicationDetails;
    private Employer author;
    private String comments;
    private AdvertisementStatus status;
    private Map<Integer, Role> roles;
    private int lastRole;
    
    public Advertisement(String details) {
        applicationDetails = details;
        roles = new HashMap<Integer, Role>();
        author = null;
        comments = null;
        lastRole = 0;
        status = AdvertisementStatus.PENDING;
    }


    public enum AdvertisementStatus {
            PENDING, PUBLISHED
    }

    public Map<Integer, Role> getRoles(){
        return roles;
    }

    public Employer getEmployer(){
        return author;
    }

    public void setAuthor(Employer author) {
        this.author = author;
    }

    public void setStatus(AdvertisementStatus status) {
        this.status = status;
    }

    public void setLastRole(int lastRole) {
        this.lastRole = lastRole;
    }

    public String getApplicationDetails(){
        return applicationDetails;
    }

    public String getComments(){
        return comments;
    }
    
    public void setComments(String c){
        comments = c;
    }

    public Advertisement.AdvertisementStatus getStatus(){
        return status;
    }

    public Role addNewRole(String title, String location, Date start, Date end, String description, Double salary){
        lastRole = roles.size();
        Role role = new Role(title, location, start, end, description, salary);
        roles.put(lastRole, role);
        return role;
    }
    
    
    public Map<Integer, Advertisement> displayAdvertisementSummary() {
        AdvertisementStoreImpl adStore = new AdvertisementStoreImpl("data/adverts.obj");
        return adStore.getAdverts();
    
    }
}

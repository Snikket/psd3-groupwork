package uk.ac.glasgow.AdvertisementManagement;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable{

    private String title;
    private Date start;
    private Date end;
    private Double salary;
    private String location;
    private String description; 
    
    public Role(String title, String location, Date start, Date end, String description, Double salary){
        this.title = title;
        this.location = location;
        this.start = start;
        this.end = end;
        this.description = description;
        this.salary = salary;
    }
    
    public String getTitle(){
        return title;
    }

    public Date getStart(){
        return start;
    }

    public Date getEnd(){
        return end;
    }

    public Double getSalary(){
        return salary;
    }

    public boolean isApproved(){
        return false;
    }

    public String getLocation(){
        return location;
    }
}

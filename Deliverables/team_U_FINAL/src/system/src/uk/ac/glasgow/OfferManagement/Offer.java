package uk.ac.glasgow.OfferManagement;
import java.io.Serializable;
import java.util.*;
import uk.ac.glasgow.AdvertisementManagement.Advertisement;
import uk.ac.glasgow.AdvertisementManagement.Employer;
import uk.ac.glasgow.AdvertisementManagement.Internship;
import uk.ac.glasgow.internman.Student;

public class Offer implements Serializable{
   private Internship internship;
   private Student student;
   private String comment;
   private String status;

    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
   

   
}
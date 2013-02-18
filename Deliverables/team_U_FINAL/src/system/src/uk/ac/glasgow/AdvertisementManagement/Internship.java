package uk.ac.glasgow.AdvertisementManagement;

import uk.ac.glasgow.internman.Visit;


public class Internship {
    String manager;
    String managerEmail;
    Visit visit;
    Role role;
    Employer employer;
    InternshipStatus status;

    public enum InternshipStatus {
            APPLYING, WITHDRAWN, ACCEPTED, APPROVED, PENDING
    }

    public Internship(String manager, String managerEmail, Visit visit, Role role, Employer employer) {
        this.manager = manager;
        this.managerEmail = managerEmail;
        this.visit = visit;
        this.role = role;
        this.employer = employer;
        this.status = InternshipStatus.PENDING;
    }

   

    public boolean isVisitComplete(){
        return visit.getComplete();
    }

   

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public InternshipStatus getStatus() {
        return status;
    }


    public void setStatus(InternshipStatus status) {
        this.status = status;
    }

}

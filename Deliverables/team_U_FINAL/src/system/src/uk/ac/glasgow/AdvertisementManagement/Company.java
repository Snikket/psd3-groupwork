/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.glasgow.AdvertisementManagement;
    
/**
 *
 * @author 2037876b
 */
public class Company {
    
    private String name;
    private String website;
    private String address;
    
    public Company(String name,String website, String address  ){
        this.name = name;
        this.website = website;
        this.address = address;
    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
}

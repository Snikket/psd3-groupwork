package uk.ac.glasgow.internman;

import java.util.Date;

public interface Role {

	public String getTitle();

	public Date getStart();

	public Date getEnd();

	public Double getSalary();
	
	boolean isApproved();

	void setApproved(boolean b);
	
	public String getLocation();
}

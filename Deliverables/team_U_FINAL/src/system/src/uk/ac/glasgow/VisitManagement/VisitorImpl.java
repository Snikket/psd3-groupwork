package uk.ac.glasgow.VisitManagement;

import uk.ac.glasgow.internman.Visitor;

public class VisitorImpl implements Visitor {
	private String visitorName;
	private String visitorEmail;
	
	public VisitorImpl(String visitorName, String visitorEmail) {
		this.visitorName = visitorName;
		this.visitorEmail = visitorEmail;
	}
	
	public String getName() {
		return visitorName;
	}

}

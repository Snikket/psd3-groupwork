package uk.ac.glasgow.VisitManagement;

import uk.ac.glasgow.internman.UoGGrade;
import uk.ac.glasgow.internman.Visitor;
import uk.ac.glasgow.internman.Visit;

public class VisitImpl implements Visit {
	Visitor visitor;
	UoGGrade grade = null;
	String description = null;
	
	public VisitImpl(Visitor visitor) {
		this.visitor = visitor;
	}
	
	public void recordVisitAssessment(UoGGrade grade, String description) {
		this.grade = grade;
		this.description = description;
	}
	
	public Visitor getVisitor() {
		return visitor;
	}

	public UoGGrade getGrade() {
		return grade;
	}

	public String getDescription() {
		return description;
	}
	
	public boolean getComplete() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}

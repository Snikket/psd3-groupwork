package uk.ac.glasgow.VisitManagement;

import uk.ac.glasgow.internman.UoGGrade;
import uk.ac.glasgow.internman.Visit;
import uk.ac.glasgow.internman.Visitor;
import uk.ac.glasgow.internman.Student;

public abstract interface VisitAPI {
	public void assignAcademicVisitor ( Student student, String visitorName, String visitorEmail );
	
	public void recordVisitAssessment ( Student student, UoGGrade grade, String description );
	
}

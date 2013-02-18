package uk.ac.glasgow.VisitManagement;

import uk.ac.glasgow.Utility.UserStore;
import uk.ac.glasgow.Utility.UserStoreImpl;
import uk.ac.glasgow.internman.UoGGrade;
import uk.ac.glasgow.internman.Visitor;
import uk.ac.glasgow.internman.Visit;
import uk.ac.glasgow.internman.Student;
import uk.ac.glasgow.internman.Internship;
import uk.ac.glasgow.internman.InternshipImpl;

public class VisitAPIImpl implements VisitAPI {
	
	public VisitAPIImpl() {}
	
	public void assignAcademicVisitor ( Student student, String visitorName, String visitorEmail ) {
		if (student.getInternship().getVisit() != null) {
			Visitor visitor = new VisitorImpl( visitorName, visitorEmail);
			Visit visit = new VisitImpl(visitor);
			student.getInternship().setVisit(visit);
		}
	}
	
	public void recordVisitAssessment ( Student student, UoGGrade grade, String description ) {
		student.getInternship().getVisit().recordVisitAssessment(grade, description);
	}
	
}

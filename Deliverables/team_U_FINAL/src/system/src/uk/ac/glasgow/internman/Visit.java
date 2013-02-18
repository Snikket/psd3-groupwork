package uk.ac.glasgow.internman;

public interface Visit {

	void recordVisitAssessment(UoGGrade grade, String description);
	
	Visitor getVisitor();

	UoGGrade getGrade();

	String getDescription();
	
	boolean getComplete();

}

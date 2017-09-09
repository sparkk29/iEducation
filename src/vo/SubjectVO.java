package vo;

import java.io.Serializable;

public class SubjectVO implements Serializable{
	
	private long subjectID;
	private String subjectName;
	private String subjectDescription;
	private CourseVO courseID;
	private BranchVO branchID;
	private SemesterVO semesterID;
	public long getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(long subjectID) {
		this.subjectID = subjectID;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectDescription() {
		return subjectDescription;
	}
	public void setSubjectDescription(String subjectDescription) {
		this.subjectDescription = subjectDescription;
	}
	public CourseVO getCourseID() {
		return courseID;
	}
	public void setCourseID(CourseVO courseID) {
		this.courseID = courseID;
	}
	public BranchVO getBranchID() {
		return branchID;
	}
	public void setBranchID(BranchVO branchID) {
		this.branchID = branchID;
	}
	public SemesterVO getSemesterID() {
		return semesterID;
	}
	public void setSemesterID(SemesterVO semesterID) {
		this.semesterID = semesterID;
	}
	
	

}

package vo;

import java.io.Serializable;



public class ManageExamVO implements Serializable{
	
	private long examID;
	private String examName;
	private String examType;
	private String examCode;
	private String startTime;
	private String endTime;
	private String date;
	private String marks;
	private String examDescription;
	private CourseVO courseID;
	private BranchVO branchID;
	private SemesterVO semesterID;
	private SubjectVO subjectID;
	public long getExamID() {
		return examID;
	}
	public void setExamID(long examID) {
		this.examID = examID;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public String getExamType() {
		return examType;
	}
	public void setExamType(String examType) {
		this.examType = examType;
	}
	public String getExamCode() {
		return examCode;
	}
	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getExamDescription() {
		return examDescription;
	}
	public void setExamDescription(String examDescription) {
		this.examDescription = examDescription;
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
	public SubjectVO getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(SubjectVO subjectID) {
		this.subjectID = subjectID;
	}
	
	

}

package vo;

import java.io.Serializable;

public class SemesterVO  implements Serializable{
	
	private long semesterID;
	private String semesterNo;
	private String semesterType;
	private CourseVO courseID;
	public long getSemesterID() {
		return semesterID;
	}
	public void setSemesterID(long semesterID) {
		this.semesterID = semesterID;
	}
	public String getSemesterNo() {
		return semesterNo;
	}
	public void setSemesterNo(String semesterNo) {
		this.semesterNo = semesterNo;
	}
	public String getSemesterType() {
		return semesterType;
	}
	public void setSemesterType(String semesterType) {
		this.semesterType = semesterType;
	}
	public CourseVO getCourseID() {
		return courseID;
	}
	public void setCourseID(CourseVO courseID) {
		this.courseID = courseID;
	}
	
	
}

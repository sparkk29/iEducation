package vo;

import java.io.Serializable;

public class BranchVO  implements Serializable{
	private long branchID;
	private String branchType;
	private String branchDescription;
	 private CourseVO courseID;
	public long getBranchID() {
		return branchID;
	}
	public void setBranchID(long branchID) {
		this.branchID = branchID;
	}
	public String getBranchType() {
		return branchType;
	}
	public void setBranchType(String branchType) {
		this.branchType = branchType;
	}
	public String getBranchDescription() {
		return branchDescription;
	}
	public void setBranchDescription(String branchDescription) {
		this.branchDescription = branchDescription;
	}
	public CourseVO getCourseID() {
		return courseID;
	}
	public void setCourseID(CourseVO courseID) {
		this.courseID = courseID;
	}
	
	 

}

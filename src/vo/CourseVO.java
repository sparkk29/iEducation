package vo;

import java.io.Serializable;

public class CourseVO  implements Serializable{

	private long courseID;
	private String courseType;
	private String courseDescription;
	public long getCourseID() {
		return courseID;
	}
	public void setCourseID(long courseID) {
		this.courseID = courseID;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	
	
	
}

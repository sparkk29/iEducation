package vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class AttachmentVO implements Serializable {
	
	private int attachmentID;
	private String attachmentType;
	private String materialType;
	private CourseVO courseID;
	private BranchVO branchID;
	private SemesterVO semesterID;
	private SubjectVO subjectID;
	private Set attachset =	new HashSet(0);
	public int getAttachmentID() {
		return attachmentID;
	}
	public void setAttachmentID(int attachmentID) {
		this.attachmentID = attachmentID;
	}
	public String getAttachmentType() {
		return attachmentType;
	}
	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}
	public String getMaterialType() {
		return materialType;
	}
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
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
	public Set getAttachset() {
		return attachset;
	}
	public void setAttachset(Set attachset) {
		this.attachset = attachset;
	}
	
	
}

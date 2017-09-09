package vo;

import java.io.Serializable;

import vo.BranchVO;
import vo.CourseVO;
import vo.SemesterVO;
import vo.SubjectVO;

public class Material implements Serializable {
	private long materialID;
	private String contentName;
	private String materialType;
	private CourseVO courseID	;
	private BranchVO branchID;
	private SemesterVO semesterID;
	private SubjectVO subjectID;
	public long getMaterialID() {
		return materialID;
	}
	public void setMaterialID(long materialID) {
		this.materialID = materialID;
	}
	public String getContentName() {
		return contentName;
	}
	public void setContentName(String contentName) {
		this.contentName = contentName;
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
	
}

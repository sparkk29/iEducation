package vo;

import java.io.Serializable;

public class UserTypeVO implements Serializable{

	private long userID;
	private String username;
	private String password;
	private String usertype;
	private StudentRegisterVO studentRegisterVO;
	
	public StudentRegisterVO getStudentRegisterVO() {
		return studentRegisterVO;
	}
	public void setStudentRegisterVO(StudentRegisterVO studentRegisterVO) {
		this.studentRegisterVO = studentRegisterVO;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
}

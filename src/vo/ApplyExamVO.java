package vo;

public class ApplyExamVO {
	private long applyExamID;
	private ManageExamVO examID;
	private UserTypeVO userID;
	private int result;
	public long getApplyExamID() {
		return applyExamID;
	}
	public void setApplyExamID(long applyExamID) {
		this.applyExamID = applyExamID;
	}
	public ManageExamVO getExamID() {
		return examID;
	}
	public void setExamID(ManageExamVO examID) {
		this.examID = examID;
	}
	public UserTypeVO getUserID() {
		return userID;
	}
	public void setUserID(UserTypeVO userID) {
		this.userID = userID;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
		

}

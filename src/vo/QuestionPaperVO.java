package vo;
import java.io.Serializable;

import vo.BranchVO;
import vo.CourseVO;
import vo.SemesterVO;
import vo.SubjectVO;

public class QuestionPaperVO implements Serializable{
	private long questionpaperID;
	private ManageExamVO examID;
	private String question;
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	private String correctAns;
	public long getQuestionpaperID() {
		return questionpaperID;
	}
	public void setQuestionpaperID(long questionpaperID) {
		this.questionpaperID = questionpaperID;
	}
	public ManageExamVO getExamID() {
		return examID;
	}
	public void setExamID(ManageExamVO examID) {
		this.examID = examID;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAns1() {
		return ans1;
	}
	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}
	public String getAns2() {
		return ans2;
	}
	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}
	public String getAns3() {
		return ans3;
	}
	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}
	public String getAns4() {
		return ans4;
	}
	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}
	public String getCorrectAns() {
		return correctAns;
	}
	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}
	
}
package vo;

import java.io.Serializable;

public class FaqVO implements Serializable{
	private long faqID;
	private String faqQuestion;
	private String faqAnswer;
	public long getFaqID() {
		return faqID;
	}
	public void setFaqID(long faqID) {
		this.faqID = faqID;
	}
	public String getFaqQuestion() {
		return faqQuestion;
	}
	public void setFaqQuestion(String faqQuestion) {
		this.faqQuestion = faqQuestion;
	}
	public String getFaqAnswer() {
		return faqAnswer;
	}
	public void setFaqAnswer(String faqAnswer) {
		this.faqAnswer = faqAnswer;
	}

}

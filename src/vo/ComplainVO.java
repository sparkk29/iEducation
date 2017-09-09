package vo;

import java.io.Serializable;

public class ComplainVO implements Serializable{
	private long complainID;
	private String complainSubject;
	private String compose;
	public long getComplainID() {
		return complainID;
	}
	public void setComplainID(long complainID) {
		this.complainID = complainID;
	}
	public String getComplainSubject() {
		return complainSubject;
	}
	public void setComplainSubject(String complainSubject) {
		this.complainSubject = complainSubject;
	}
	public String getCompose() {
		return compose;
	}
	public void setCompose(String compose) {
		this.compose = compose;
	}
	

}

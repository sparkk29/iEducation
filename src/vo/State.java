package vo;

import java.io.Serializable;

public class State implements Serializable{
	private long stateID;
	private String stateName;
	private CountryVO country;
	public long getStateID() {
		return stateID;
	}
	public void setStateID(long stateID) {
		this.stateID = stateID;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public CountryVO getCountry() {
		return country;
	}
	public void setCountry(CountryVO country) {
		this.country = country;
	}
	
	

}

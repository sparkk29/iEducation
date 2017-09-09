package vo;

import java.io.Serializable;

public class StateVO implements Serializable{
	private long stateID;
	private String stateName;
	private CountryVO countryID;
	
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
	public CountryVO getCountryID() {
		return countryID;
	}
	public void setCountryID(CountryVO countryID) {
		this.countryID = countryID;
	}
	
	
}

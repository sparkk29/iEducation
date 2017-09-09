package vo;

import java.io.Serializable;

public class CityVO  implements Serializable{
	private long cityID;
	private String cityName;
	private StateVO stateID;
	private CountryVO countryID;
	public long getCityID() {
		return cityID;
	}
	public void setCityID(long cityID) {
		this.cityID = cityID;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public StateVO getStateID() {
		return stateID;
	}
	public void setStateID(StateVO stateID) {
		this.stateID = stateID;
	}
	public CountryVO getCountryID() {
		return countryID;
	}
	public void setCountryID(CountryVO countryID) {
		this.countryID = countryID;
	}
	
	
}

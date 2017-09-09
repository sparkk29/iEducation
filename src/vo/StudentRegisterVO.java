package vo;

public class StudentRegisterVO {
	private long studentRegisterID;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNo;
	private String emailID;
	private String gender;
	private String dob;
	private String username;
	private String password;
	private  CountryVO countryID;
	private StateVO stateID;
	private CityVO   cityID;
	private  CourseVO courseID;
	private BranchVO branchID;
	private SemesterVO semesterID;
	
	public long getStudentRegisterID() {
		return studentRegisterID;
	}
	public void setStudentRegisterID(long studentRegisterID) {
		this.studentRegisterID = studentRegisterID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
	public CountryVO getCountryID() {
		return countryID;
	}
	public void setCountryID(CountryVO countryID) {
		this.countryID = countryID;
	}
	public StateVO getStateID() {
		return stateID;
	}
	public void setStateID(StateVO stateID) {
		this.stateID = stateID;
	}
	public CityVO getCityID() {
		return cityID;
	}
	public void setCityID(CityVO cityID) {
		this.cityID = cityID;
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
	
	
}

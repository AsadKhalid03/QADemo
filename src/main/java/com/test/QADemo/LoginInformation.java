package com.test.QADemo;

public class LoginInformation {
	
	private int loanAmount;
	private String loanPurpose;
	private String firstName;
	private String lastName;
	private String homeAddress;
	private String city;
	private String state;
	private int zipCode;
	private String dateOfBirth;
	private int annualIncome;
	private int additionalIncome;
	private String email;
	private String password;
	private String termOfUse;
	
	/**
	 * Constructor in which calling setter functions for all the parameters
	 * @param loanAmount
	 * @param loanPurpose
	 * @param firstName
	 * @param lastName
	 * @param homeAddress
	 * @param city
	 * @param state
	 * @param zipCode
	 * @param dateOfBirth
	 * @param annualIncome
	 * @param additionalIncome
	 * @param email
	 * @param password
	 * @param termOfUse
	 */
	
	public LoginInformation(int loanAmount, String loanPurpose, String firstName, String lastName, 
			String homeAddress, String city, String state, int zipCode ,String dateOfBirth, 
			int annualIncome, int additionalIncome, String email, String password, String termOfUse) {
		setLoanAmount(loanAmount);
		setLoanPurpose(loanPurpose);
		setFirstName(firstName);
		setLastName(lastName);
		setHomeAddress(homeAddress);
		setCity(city);
		setState(state);
		setZipCode(zipCode);
		setDateOfBirth(dateOfBirth);
		setAnnualIncome(annualIncome);
		setAdditionalIncome(additionalIncome);
		setEmail(email);
		setPassword(password);
		setTermOfUse(termOfUse);	
	}
	
	/**
	 * Getter & Setter functions for all the defined variables
	 */
	
	public int getLoanAmount() {
		return loanAmount;
	}
	
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public String getLoanPurpose() {
		return loanPurpose;
	}
	
	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
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
	
	public String getHomeAddress() {
		return homeAddress;
	}
	
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public int getAnnualIncome() {
		return annualIncome;
	}
	
	public void setAnnualIncome(int annualIncome) {
		this.annualIncome = annualIncome;
	}
	
	public int getAdditionalIncome() {
		return additionalIncome;
	}
	
	public void setAdditionalIncome(int additionalIncome) {
		this.additionalIncome = additionalIncome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTermOfUse() {
		return termOfUse;
	}
	
	public void setTermOfUse(String termOfUse) {
		this.termOfUse = termOfUse;
	}
}

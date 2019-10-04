package com.test.QADemo;

public class LoanInformation {

	private String loanAmount;
	private String monthlyPayment;
	private String loanTerm;
	private String interestRate;
	private String loanAPR;
	
	/**
	 * Empty constructor
	 */
	
	public LoanInformation() {
	
	}
	
	/**
	 * Constructor in which calling setter functions for all the parameters 
	 * @param loanAmount
	 * @param monthlyPayment
	 * @param loanTerm
	 * @param interestRate
	 * @param loanAPR
	 */
	
	public LoanInformation(String loanAmount, String monthlyPayment, String loanTerm, String interestRate, String loanAPR) {
		setLoanAmount(loanAmount);
		setMonthlyPayment(monthlyPayment);
		setLoanTerm(loanTerm);
		setInterestRate(interestRate);
		setLoanAPR(loanAPR);
	}
	
	/**
	 * Getter & Setter functions for all the defined variables
	 */
	
	public String getLoanAmount() {
		return loanAmount;
	}
	
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public String getMonthlyPayment() {
		return monthlyPayment;
	}
	
	public void setMonthlyPayment(String monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	
	public String getLoanTerm() {
		return loanTerm;
	}
	
	public void setLoanTerm(String loanTerm) {
		this.loanTerm = loanTerm;
	}
	
	public String getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	
	public String getLoanAPR() {
		return loanAPR;
	}
	
	public void setLoanAPR(String loanAPR) {
		this.loanAPR = loanAPR;
	}
}

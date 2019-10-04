package com.test.QADemo.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.test.QADemo.CommonFunctions;
import com.test.QADemo.DriverFactory;
import com.test.QADemo.LoanInformation;
import com.test.QADemo.LoginInformation;

public class WebTest {
	
	/**
	 * Web Links
	 */
	
	private String webLink = "https://www.credify.tech/phone/nonDMFunnel";
	private String loginLink = "https://www.credify.tech/portal/login";
	
	/**
	 * All the CSS paths for sign up
	 */
	
	private String dataFetchingSpinnerCSS = ".layout__wrap div[data-fetching='false']";
	private String loanAmountCSS = "input[name='desiredAmount']";
	private String loanPurposeCSS = ".sc-fMiknA select";
	private String submitButtonCSS = "button[type='submit']";
	private String firstNameCSS = ".sc-iAyFgw input[type='text']";
	private String lastNameCSS = ".sc-iAyFgw input[name='borrowerLastName']";
	private String homeAddressCSS = ".geosuggest input[name='borrowerStreet']";
	private String cityCSS = ".sc-iAyFgw input[name='borrowerCity']";
	private String stateCSS = ".sc-iAyFgw input[name='borrowerState']";
	private String zipCodeCSS = ".sc-iAyFgw input[name='borrowerZipCode']";
	private String dateOfBirthCSS = ".sc-iAyFgw input[name='borrowerDateOfBirth']";
	private String annualIncomeCSS = ".sc-iAyFgw input[name='borrowerIncome']";
	private String additionalIncomeCSS = ".sc-iAyFgw input[name='borrowerAdditionalIncome']";
	private String emailCSS = "input[name='username']";
	private String passwordCSS = "input[name='password']";
	private String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
	private String passwordCheckMarkCSS = ".sc-hSdWYo span.icon-checkmark-thick";
	private String termOfUseCSS = ".sc-kPVwWT.sc-kfGgVZ.ghCrQD";
	
	/**
	 * All the CSS paths for offer page after signing up
	 */
	
	private String laonAmountValueCSS = ".sc-kAzzGY span.sc-chPdSV";
	private String monthlyPaymentValueCSS = ".sc-hXRMBi .sc-iQNlJl span";
	private String loanTermValueCSS = ".sc-bsbRJL .sc-hXRMBi .section--sm div:nth-child(1)";
	private String interestRateValueCSS = ".sc-bsbRJL .sc-hXRMBi .section--sm div:nth-child(2)";
	private String loanAPRValueCSS = ".sc-bsbRJL .sc-hXRMBi .section--sm div:nth-child(3)";
	
	/**
	 * All the CSS paths for logout
	 */
	
	private String menuButton = ".header-nav__toggle";
	private String signOutButton = ".list--unstyled a[href*='/phone/logout']";
	private String signOutText = ".container-fluid .row .title--secondary";
	
	/**
	 * Variables for getting the stored offer information
	 */
	
	private String laonAmountValue;
	private String monthlyPaymentValue;
	private String loanTermValue;
	private String interestRateValue;
	private String loanAPRValue;
	
	/**
	 * Creating objects for respective classes and passing all the information for sign up in LoginInformation class
	 */
	
	DriverFactory driverFactory = new DriverFactory();
	LoginInformation loginInformation = new LoginInformation(2000, "Business", "Abcd", "Xyz", "Apt#22 1074 Layman Court", 
			"NewYork", "NE" , 10001, "01/01/1970", 120000, 50000, "candidate01@upgrade-challenge.com", "Abcdxyz14", "Yes");
	CommonFunctions commonFunctions = new CommonFunctions();
	
	/**
	 * Running a test with all the provided information and validating few place with given instructions
	 * @throws InterruptedException 
	 */
	
	@Test
	public void runWebTest() throws InterruptedException {
		System.out.println("Starting Web test in " + WebTest.class);
		try {
			driverFactory.setupDriverAndBrowser(webLink);
			WebDriver driver = driverFactory.getDriver();
		
			commonFunctions.waitForElement(driver, dataFetchingSpinnerCSS);
			commonFunctions.waitUntilElementIsDisplayed(driver, loanAmountCSS);
			if(loginInformation.getLoanAmount() >= 1000 && loginInformation.getLoanAmount() <= 50000) {
				commonFunctions.writeValue(driver, loanAmountCSS, String.valueOf(loginInformation.getLoanAmount()));
			} else {
				Assert.fail("Loan Amount value isn't between 1,000 to 50,000, Loan Amount value is " + loginInformation.getLoanAmount());		
			}
			commonFunctions.writeValue(driver, loanPurposeCSS, loginInformation.getLoanPurpose());
			commonFunctions.clickOnButton(driver, submitButtonCSS);
			
			commonFunctions.waitForElement(driver, dataFetchingSpinnerCSS);
			commonFunctions.waitUntilElementIsDisplayed(driver, firstNameCSS);
			commonFunctions.clickOnElement(driver, firstNameCSS);
			commonFunctions.writeValue(driver, firstNameCSS, loginInformation.getFirstName());
			commonFunctions.clickOnElement(driver, lastNameCSS);
			commonFunctions.writeValue(driver, lastNameCSS, loginInformation.getLastName());
			commonFunctions.clickOnElement(driver, homeAddressCSS);
			commonFunctions.writeValue(driver, homeAddressCSS, loginInformation.getHomeAddress());
			commonFunctions.clickOnElement(driver, cityCSS);
			commonFunctions.writeValue(driver, cityCSS, loginInformation.getCity());
			commonFunctions.clickOnElement(driver, stateCSS);
			commonFunctions.writeValue(driver, stateCSS, loginInformation.getState());
			commonFunctions.clickOnElement(driver, zipCodeCSS);
			commonFunctions.writeValue(driver, zipCodeCSS, String.valueOf(loginInformation.getZipCode()));
			boolean status = commonFunctions.stringToDateConverter(loginInformation.getDateOfBirth());	        
			if(status == true) {
				commonFunctions.clickOnElement(driver, dateOfBirthCSS);
				commonFunctions.writeValue(driver, dateOfBirthCSS, String.valueOf(loginInformation.getDateOfBirth()));
			} else {
				Assert.fail("Date of Birth date value isn't from between 01/01/1930 to 01/01/2000, Date of Birth date value is " + loginInformation.getDateOfBirth());
			}
			if(loginInformation.getAnnualIncome() >= 120000) {
				commonFunctions.clickOnElement(driver, annualIncomeCSS);
				commonFunctions.writeValue(driver, annualIncomeCSS, String.valueOf(loginInformation.getAnnualIncome()));
			} else {
				Assert.fail("Annual Income value isn't bigger than 120,000, Annual Income value is " + loginInformation.getAnnualIncome());
			}
			if(loginInformation.getAdditionalIncome() >= 50000) {
				commonFunctions.clickOnElement(driver, additionalIncomeCSS);
				commonFunctions.writeValue(driver, additionalIncomeCSS, String.valueOf(loginInformation.getAdditionalIncome()));
			} else {
				Assert.fail("Additional Income value isn't bigger than 50,000, Additional Income value is " + loginInformation.getAdditionalIncome());
			}
			commonFunctions.clickOnElement(driver, emailCSS);
			commonFunctions.writeValue(driver, emailCSS, loginInformation.getEmail());
			commonFunctions.clickOnElement(driver, passwordCSS);
			commonFunctions.writeValue(driver, passwordCSS, loginInformation.getPassword());
			if(loginInformation.getPassword().matches(passwordPattern)) {
				if(driver.findElement(By.cssSelector(passwordCheckMarkCSS)).isDisplayed()) {
					System.out.println("Password pattern is correct, Password value is " + loginInformation.getPassword());
				}
			} else {
				Assert.fail("Password pattern is incorrect, Password value is " + loginInformation.getPassword());
			}
			commonFunctions.selectElement(driver, termOfUseCSS, loginInformation.getTermOfUse());
			commonFunctions.clickOnButton(driver, submitButtonCSS);
			
			commonFunctions.waitForElement(driver, dataFetchingSpinnerCSS);
			commonFunctions.waitUntilElementIsDisplayed(driver, laonAmountValueCSS);
			LoanInformation loanInformation = new LoanInformation(commonFunctions.getElementValue(driver, laonAmountValueCSS), 
					commonFunctions.getElementValue(driver, monthlyPaymentValueCSS), 
					commonFunctions.getElementValue(driver, loanTermValueCSS),
					commonFunctions.getElementValue(driver, interestRateValueCSS),
					commonFunctions.getElementValue(driver, loanAPRValueCSS));
			System.out.println("Loan Amount value is " + loanInformation.getLoanAmount()); 
			System.out.println("Monthly Payment value is " + loanInformation.getMonthlyPayment());
			System.out.println("Loan Term value is " + loanInformation.getLoanTerm());
			System.out.println("Interest Rate value is " + loanInformation.getInterestRate());
			System.out.println("Loan APR value is " + loanInformation.getLoanAPR());
			Thread.sleep(500);
			commonFunctions.clickOnButton(driver, menuButton);
			commonFunctions.waitUntilElementIsDisplayed(driver, signOutButton);
			commonFunctions.clickOnButton(driver, signOutButton);
			commonFunctions.waitUntilElementIsDisplayed(driver, signOutText);
			
			driver.navigate().to(loginLink);
			commonFunctions.waitForElement(driver, dataFetchingSpinnerCSS);
			commonFunctions.waitUntilElementIsDisplayed(driver, emailCSS);
			commonFunctions.clickOnElement(driver, emailCSS);
			commonFunctions.writeValue(driver, emailCSS, loginInformation.getEmail());
			commonFunctions.clickOnElement(driver, passwordCSS);
			commonFunctions.writeValue(driver, passwordCSS, loginInformation.getPassword());
			commonFunctions.clickOnButton(driver, submitButtonCSS);
			
			commonFunctions.waitForElement(driver, dataFetchingSpinnerCSS);
			commonFunctions.waitUntilElementIsDisplayed(driver, laonAmountValueCSS);
			laonAmountValue = commonFunctions.getElementValue(driver, laonAmountValueCSS);
			monthlyPaymentValue = commonFunctions.getElementValue(driver, monthlyPaymentValueCSS);
			loanTermValue = commonFunctions.getElementValue(driver, loanTermValueCSS);
			interestRateValue = commonFunctions.getElementValue(driver, interestRateValueCSS);
			loanAPRValue = commonFunctions.getElementValue(driver, loanAPRValueCSS);
			
			Assert.assertEquals(loanInformation.getLoanAmount(), laonAmountValue);
			System.out.println("Actual Loan Amount value is " + loanInformation.getLoanAmount() + " | Expected Loan Amount value is "+ laonAmountValue);
			Assert.assertEquals(loanInformation.getMonthlyPayment(), monthlyPaymentValue);
			System.out.println("Actual Monthly Payment value is " + loanInformation.getMonthlyPayment() + " | Expected Monthly Payment value is "+ monthlyPaymentValue);
			Assert.assertEquals(loanInformation.getLoanTerm(), loanTermValue);
			System.out.println("Actual Loan Term value is " + loanInformation.getLoanTerm() + " | Expected Loan Term value is "+ loanTermValue);
			Assert.assertEquals(loanInformation.getInterestRate(), interestRateValue);
			System.out.println("Actual Interest Rate is " + loanInformation.getInterestRate() + " | Expected Interest Rate value is "+ interestRateValue);
			Assert.assertEquals(loanInformation.getLoanAPR(), loanAPRValue);
			System.out.println("Actual Loan APR value is " + loanInformation.getLoanAPR() + " | Expected Loan APR value is "+ loanAPRValue);
		} finally {
			System.out.println("Ending Web test in " + WebTest.class);
		}
	}
	
	@AfterMethod 
	public void cleanup(){
		driverFactory.closeDriverAndBrowser();
	}
}

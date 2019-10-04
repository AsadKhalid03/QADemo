package com.test.QADemo.TestCases;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.response.Response;

public class ApiTest {

	/**
	 * Defined valid username and password in a JSON format for payload
	 */
	private static String payload = "{\n" +
	        "  \"username\": \"coding.challenge.login@upgrade.com\",\n" +
	        "  \"password\": \"On$3XcgsW#9q\"\n" +
	        "}";
	
	/**
	 * Running a test with all the provided information (headers and body payload) and saving the response
	 * Then calling a method for http status validation
	 * @throws ParseException
	 */
	@Test
	public void runApiTest() throws ParseException {
		System.out.println("Starting Api test in " + ApiTest.class);
		System.out.println("Payload's data is " + payload);
		try {
			Response response = 
			given().			
				headers("x-cf-source-id", "coding-challenge").
				headers("x-cf-corr-id", "230ea84a-7199-41c9-bf38-fff27e35970d").
				headers("Content-Type", "application/json").
				body(payload).
			when().
				post("https://credapi.credify.tech/api/brportorch/v2/login").
			then().
				//log().				// These two commented methods can log all the response 
				//all().
				extract().
				response();
			statusValidations(response);
		} finally {
			System.out.println("Ending Api test in " + ApiTest.class);
		}
	}
	
	/**
	 * Taking response as parameter and then doing the http status validation
	 * If http status is 200 then only calling a method for response validation
	 * @param response
	 */
	public void statusValidations(Response response) {
		try {
			if (response.getStatusCode() == 200) {
				Assert.assertEquals(response.getStatusCode(), 200);
				System.out.println("Payload's data is correct and API Response is " + response.getStatusCode());
				responseValidations(response);
			} else if (response.getStatusCode() == 401) {
				Assert.assertEquals(response.getStatusCode(), 401);
				System.out.println("Payload's data is incorrect and API Response is " + response.getStatusCode());
			} else if (response.getStatusCode() == 500) {
				Assert.assertEquals(response.getStatusCode(), 500);
				System.out.println("Payload's data is missing and API Response is " + response.getStatusCode());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Taking response as parameter and then parsing each JSON value and printing it's value
	 * Then checking the productType value in the last
	 * @param response
	 * @throws ParseException
	 */
	public void responseValidations(Response response) throws ParseException {
		try {
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(response.getBody().asString());	
			String firstName = (String) jsonObject.get("firstName");
			System.out.println("First Name is " + firstName);
			Long userId = (Long) jsonObject.get("userId");
			System.out.println("User Id is " + userId);
			String userUuid = (String) jsonObject.get("userUuid");
			System.out.println("User Uu Id is " + userUuid);
			JSONArray loanApplication = (JSONArray) jsonObject.get("loanApplications");
			if(loanApplication.isEmpty()) {
				System.out.println("Loan Application is empty");
			} else {
				for (int i = 0; i< loanApplication.size();i++) {
					System.out.println("Loan Application values are " + loanApplication.get(i));
				}
			}
			JSONArray loansInReview = (JSONArray) jsonObject.get("loansInReview");
			if(loansInReview.isEmpty()) {
				System.out.println("Loan Inreview is empty");
			} else {
				for (int i=0; i< loansInReview.size(); i++) {
					System.out.println("Loan Inreview values are " + loansInReview.get(i));
					if(loansInReview.get(i).toString().contains("productType")) {
						JSONObject productType = (JSONObject) loansInReview.get(i);
						String productTypeValue = (String) productType.get("productType");
						if(productTypeValue.equalsIgnoreCase("PERSONAL_LOAN")) {
							Assert.assertEquals(productTypeValue, "PERSONAL_LOAN");
							System.out.println("Product Type exists and it's value is " + productTypeValue);
						} else {
							Assert.fail("Product Type exists but it's value is empty or does not match with expected value");	
						}
					} else {
						Assert.fail("Product Type does not exist");
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

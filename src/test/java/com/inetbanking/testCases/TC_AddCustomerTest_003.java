package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass 
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException 
	{
		LoginPage lp = new LoginPage(driver);
		AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
		
		lp.setUserName(username);
		logger.info("Username is provided");
		Thread.sleep(1000);
		
		lp.setPassword(password);
		logger.info("Passsword is provided");
		Thread.sleep(1000);
		
		lp.clickSubmit();
		logger.info("Login button clicked");
		Thread.sleep(1000);

		logger.info("Adding customer....");
		addCustomerPage.clickAddNewCustomer();

		logger.info("Filling customer details....");
		addCustomerPage.setName("Ram Kumar");
		addCustomerPage.setGender("male");
		addCustomerPage.setDob("07", "06", "1995");
		Thread.sleep(3000);
		
		addCustomerPage.setAddress("INDIA");
		addCustomerPage.setCity("Gurgram");
		addCustomerPage.setState("Haryana");
		addCustomerPage.setPinNo("5000074");
		addCustomerPage.setTelephoneNo("987890091");

		String email = randomestring() + "@gmail.com";
		addCustomerPage.setEmailId(email);
		addCustomerPage.setPassword("abcdef");
		addCustomerPage.setSubmit();	
		logger.info("Done filling customer details....");
		Thread.sleep(1000);

		logger.info("Validation started....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) 
		{
			Assert.assertTrue(true);
			logger.info("Adding customer test case passed....");
		} 
		else 
		{
			logger.info("Adding customer test case failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
}

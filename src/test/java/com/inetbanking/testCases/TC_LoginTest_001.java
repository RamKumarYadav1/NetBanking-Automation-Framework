package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass 
{
	@Test
	public void loginTest() throws IOException, InterruptedException 
	{
		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);
		logger.info("Entered username");
		Thread.sleep(1000);

		lp.setPassword(password);
		logger.info("Entered password");
		Thread.sleep(1000);

		lp.clickSubmit();
		logger.info("Login button clicked");
		Thread.sleep(1000);

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		} 
		else 
		{
			Assert.assertTrue(false);
			logger.info("Login test failed");
			captureScreen(driver, "loginTest");
		}
	}
}

package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass 
{
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException 
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(user);
		logger.info("Username provided");
		Thread.sleep(1000);
		
		lp.setPassword(pwd);
		logger.info("Password provided");
		Thread.sleep(1000);
		
		lp.clickSubmit();
		logger.info("Login button clicked");
		Thread.sleep(1000);

		if(isInvalidLoginAlertPresent() == true) 
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.warn("Login test failed");
			driver.switchTo().alert().accept();		// close the valid login alert
			driver.switchTo().defaultContent();		// return back to login page 
		} 
		else 
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
			lp.clickLogout();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();		// close the logout alert
			driver.switchTo().defaultContent();		// return back to login page
		}
	}

	public boolean isInvalidLoginAlertPresent() 	// user defined method created to check alert is presetn or not
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		} 
		catch (NoAlertPresentException e) 
		{
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException 
	{
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) 
		{
			for (int j = 0; j < colcount; j++) 
			{
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);	// 1 0
			}
		}
		return logindata;
	}
}

package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage 
{
	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) 
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[ contains(text(),'New Customer')]")
	@CacheLookup
	WebElement lnkAddNewCustomer;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender;

	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement txtdob;

	@CacheLookup
	@FindBy(how = How.NAME, using = "addr")
	WebElement txtaddress;

	@CacheLookup
	@FindBy(how = How.NAME, using = "city")
	WebElement txtcity;

	@CacheLookup
	@FindBy(how = How.NAME, using = "state")
	WebElement txtstate;

	@CacheLookup
	@FindBy(how = How.NAME, using = "pinno")
	WebElement txtpinno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement txttelephoneno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtemailid;

	@CacheLookup
	@FindBy(how = How.NAME, using = "password")
	WebElement txtpassword;

	@CacheLookup
	@FindBy(how = How.NAME, using = "sub")
	WebElement btnSubmit;

	public void clickAddNewCustomer() 
	{
		lnkAddNewCustomer.click();
	}

	public void setName(String name) 
	{
		txtCustomerName.sendKeys(name);
	}

	public void setGender(String gender) 
	{
		rdGender.click();
	}

	public void setDob(String mm, String dd, String yy) 
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}

	public void setAddress(String address) 
	{
		txtaddress.sendKeys(address);
	}

	public void setCity(String city) 
	{
		txtcity.sendKeys(city);
	}

	public void setState(String state) 
	{
		txtstate.sendKeys(state);
	}

	public void setPinNo(String pinNo) 
	{
		txtpinno.sendKeys(String.valueOf(pinNo));
	}

	public void setTelephoneNo(String telephoneNo) 
	{
		txttelephoneno.sendKeys(telephoneNo);
	}

	public void setEmailId(String emailId) 
	{
		txtemailid.sendKeys(emailId);
	}

	public void setPassword(String password) 
	{
		txtpassword.sendKeys(password);
	}

	public void setSubmit() 
	{
		btnSubmit.click();
	}
}

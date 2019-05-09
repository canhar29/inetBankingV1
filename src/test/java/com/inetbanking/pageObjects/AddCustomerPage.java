package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
	 ldriver = rdriver;
	 PageFactory.initElements(rdriver, this);
	}

	@FindBy(how=How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement linAddNewCustomer;
	
	@FindBy(how=How.NAME, using="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how=How.NAME, using="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how=How.NAME, using="dob")
	@CacheLookup
	WebElement txtDob;
	
	@FindBy(how=How.NAME, using="addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how=How.NAME, using="city")
	@CacheLookup
	WebElement txtCity;
		
	@FindBy(how=How.NAME, using="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how=How.NAME, using="pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(how=How.NAME, using="telephoneno")
	@CacheLookup
	WebElement txtPhone;
	
	@FindBy(how=How.NAME, using="emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how=How.NAME, using="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how=How.NAME, using="sub")
	@CacheLookup
	WebElement custSubmit;
	
	public void clickAddNewCustomer() {
		linAddNewCustomer.click();
	}
	
	public void setCustName(String custname) {
		txtCustomerName.sendKeys(custname);
	}
	
	public void setCustGender(String cgender) {
		rdGender.click();
	}
	
	public void setCustDOB(String mm, String dd, String yy) {
		txtDob.sendKeys(mm);
		txtDob.sendKeys(dd);
		txtDob.sendKeys(yy);
	}	
	
	public void setCustAddress(String caddress) {
		txtAddress.sendKeys(caddress);
	}
	
	public void setCustCity(String ccity) {
		txtCity.sendKeys(ccity);
	}
	
	public void setCustState(String cstate) {
		txtState.sendKeys(cstate);
	}
	
	public void setCustPin(String cpinno) {
		txtPin.sendKeys(String.valueOf(cpinno));
	}
	
	public void setCustPhNo(String cphno) {
		txtPhone.sendKeys(cphno);
	}
	
	public void setCustEmail(String cemail) {
		txtEmail.sendKeys(cemail);
		
	}
	
	public void setCustpassword(String cpwd) {
		txtPassword.sendKeys(cpwd);
	}
	
	public void clkSubmit() {
		custSubmit.click();
	}
	
	
	
	
	
	
	

}

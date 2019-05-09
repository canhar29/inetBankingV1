package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	public static Logger logger = LogManager.getLogger(TC_AddCustomerTest_003.class);
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassWord(password);
		lp.clickSubmit();
		Thread.sleep(5000);
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		addcust.setCustName("Pooja");
		addcust.setCustGender("female");
		addcust.setCustDOB("04", "08", "1982");
		Thread.sleep(8000);
		addcust.setCustAddress("Flemington Road");
		addcust.setCustCity("Harrison");
		addcust.setCustState("Canberra");
		addcust.setCustPin("512002");
		addcust.setCustPhNo("22336688");
		String email=randomestring()+"@gmail.com";
		addcust.setCustEmail(email);
		addcust.setCustpassword("123456");
		addcust.clkSubmit();
		Thread.sleep(5000);
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res == true) {
			Assert.assertTrue(true);
			System.out.println("testPassed");
		}
		else {
			captureScreenshot(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	logger.info("add customer test passed");
	}

}

package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	public static Logger logger = LogManager.getLogger(TC_LoginTest_001.class);
  @Test
  public void loginTest() throws IOException{
	  LoginPage lp = new LoginPage(driver);
	 //Thread.sleep(3000);
	  lp.setUserName(username);
	  logger.info("entered username");
	  lp.setPassWord(password);
	  logger.info("entered password");
	  lp.clickSubmit();
	  logger.info("button clicked");
	  
	  if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	  {
		  Assert.assertTrue(true);
		  System.out.println("passed");
		  logger.info("successfully logged in");
	  }
	  else
	  {
		  captureScreenshot(driver,"loginTest");
		  Assert.assertTrue(false);
		  System.out.println("failed");
		  logger.error("unsusscessfull login");
	  }
  }
}

package com.inetbanking.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XlsUtils;

public class TC_LoginTestExcel_002 extends BaseClass {
	public static Logger logger = LogManager.getLogger(TC_LoginTestExcel_002.class);
  @Test(dataProvider="LoginData")
  public void loginDDT(String user, String pwd) throws InterruptedException, IOException{
	  LoginPage lp = new LoginPage(driver);
	  lp.setUserName(user);
	  lp.setPassWord(pwd);
	  lp.clickSubmit();
	  Thread.sleep(3000);
	  
	  
	  if (isAlertPresent()==true)
	  {
		  //captureScreenshot(driver,"loginDDT");
		  driver.switchTo().alert().accept();
		  driver.switchTo().defaultContent();
		  Assert.assertTrue(false);
	  }
	  else
	  {
		Assert.assertTrue(true);
		lp.clickLogout();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		
	  }
	  
	   
  }
  
  
  public boolean isAlertPresent()
  {
	  try
	  {
		  driver.switchTo().alert();
		  return true;
	  }
	  catch(NoAlertPresentException e) 
	  {
		  return false;
		  
	  }
  }
  /*@DataProvider(name="LoginData")//
  String[][] getData() throws IOException
  {
	  String path="C:/Users/SD/eclipse-workspaceNew/inetBankingV1/src/test/java/com/inetbanking/testData/LoginData.xlsx";
	  int rownum = XlsUtils.getRowCount(path, "Sheet1");
	  int colcount = XlsUtils.getCellCount(path, "Sheet1", 1);
	  String logindata[][] = new String[rownum][colcount];
	  for (int i=1; i<rownum;i++) {
		  for (int j=0; j<colcount;j++)
		  {
			  logindata[i-1][j]= XlsUtils.getCellData("path", "Sheet1",i, j);
		  }
	  }
	  return logindata;
	  
  }*/
    @DataProvider(name = "LoginData") 
    public Object[][] passData(){
    	Object[][] data = new Object[4][2];
    	
    	data[0][0] = "mngr189437";
    	data[0][1] = "gYrEhep";
    	
    	data[1][0] = "mngr189438";
    	data[1][1] = "gYrEher";
    	
    	data[2][0] = "mngr189437";
    	data[2][1] = "gYrEhep";
    	
    	data[3][0] = "mngr189439";
    	data[3][1] = "gYrEhes";
    	return data;
    	    	
    }
  
  }

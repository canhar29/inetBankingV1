package com.inetbanking.testCases;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	
	String baseURL = readconfig.getApplicationURL();
	String username = readconfig.getUserName();
	String password = readconfig.getPassWord();
	public static WebDriver driver;
	public static Logger logger = LogManager.getLogger(BaseClass.class);
	//mngr189437,gYrEhep,http://demo.guru99.com/v4/index.php
	@Parameters("browser")
    @BeforeClass
    public void setup(String br) throws InterruptedException {
    	
    	if (br.equals("chrome")){
    		
    	 System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		 driver = new ChromeDriver();
    	}
    	else if(br.equals("firefox")){
    		
    	 System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
		 driver = new FirefoxDriver();
    	}
    	else if(br.equals("ie")){
    		
    	 System.setProperty("webdriver.ie.driver",readconfig.getIePath());
		 driver = new InternetExplorerDriver();
    	}
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 logger.info("Browser opened");
		 driver.get(baseURL);
		 //Thread.sleep(3000);
		 logger.info("navigated to url");
		}
    
    
    @AfterClass
    public void tearDown() {
    	 driver.quit();
    	logger.info("browser closed");
    }
    
    public void captureScreenshot(WebDriver driver, String tname) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+ tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
    }
    
    public String randomestring() {
    	String generatedstring1 =RandomStringUtils.randomAlphabetic(8);
    	return generatedstring1;
    }
    
    public String randomenum() {
    	String generatedstring2 =RandomStringUtils.randomNumeric(4);
    	return generatedstring2;
    }
    
    
    
    




}

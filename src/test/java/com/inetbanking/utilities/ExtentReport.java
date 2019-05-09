package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport extends TestListenerAdapter{
	
	public WebDriver driver;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testcontext) {
		String timeStamp = new SimpleDateFormat("YYYYMMDDhhssmm").format(new Date()); 
		String repName = "Test-Report-"+timeStamp+".html";
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+ repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		htmlReporter.config().setDocumentTitle("InetBankingV1Automation Report");
		htmlReporter.config().setReportName("Functional Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("Os", "Windows10");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("TesterName","Lavi");			
	}
	
	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+ ".png";
		File f = new File(screenshotPath);
		
		if(f.exists())
		{
		try {
		    logger.fail("screenshot is below:"+logger.addScreenCaptureFromPath(screenshotPath));
		    }
		catch(IOException e) 
		       {
			    e.printStackTrace();
		       }
		}
	}
	
	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testcontext) {
		extent.flush();
	}
	
	}
	
	/*AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == (ITestResult.FAILURE)){
			test.log(Status.FAIL, "Test Case Failed Is"+ result.getName());
			test.log(Status.FAIL,"Test Case Failed Is"+ result.getThrowable());
			
			String screenshotPath = ExtentReport.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		}else if(result.getStatus() == (ITestResult.SKIP)){
			test.log(Status.SKIP, "Test case skipped is "+result.getName());
			
		}else if (result.getStatus() == (ITestResult.SUCCESS)) {
			test.log(Status.PASS,"Test case passed is"+result.getName());
			
		}
								
		}
		
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("YYYYMMDDhhssmm").format(new Date()); 
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"/Screenshots/"+ screenshotName + dateName + ".png";
				
		File finaldestination = new File(destination);
		FileUtils.copyFile(source, finaldestination);
		return destination;
		
	}
	*/



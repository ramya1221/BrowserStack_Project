package com.project.framework.test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.project.framework.Pages.Homepage;
import com.project.framework.Pages.SingnUpPage;
import com.project.framework.utils.CommonUtils;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class PageTestOfExtentReport {
  WebDriver driver;
  Homepage objHomePage;
  SingnUpPage objSignUpPage;
  ExtentReports extent;
  ExtentSparkReporter htmlReporter;
  ExtentTest test;
  CommonUtils utils;
  String env, executionPlace;

  @BeforeTest
  public void setup() {
	  utils = new CommonUtils();
	  extent = new ExtentReports();
	  ExtentSparkReporter htmlReporter = new ExtentSparkReporter("ramyaExtentReport.html");
	  extent.attachReporter(htmlReporter);
	  env = "dev";
	  executionPlace = "Local Machine";
	  
	  extent.setSystemInfo("Host Name", executionPlace);
	  extent.setSystemInfo("Environment", env);
	  driver = new ChromeDriver();
	  driver.get("https://www.browserstack.com");
	  driver.manage().window().maximize();
  }
  @Test(priority = 1)
  public void navigate_to_homepage_click_on_getStarted() {
	  test = extent.createTest("navigate_to_homepage_click_on_getStarted");
	  test.log(Status.INFO, "Starting test case");
	  objHomePage = new Homepage(driver);
	  objHomePage.verifyHeader();
	  objHomePage.clickOnGetStarted();
	  test.log(Status.INFO, "Ending test case");
  }
  @Test(priority = 2)
  public void enter_userDetails() {
	  test = extent.createTest("enter_userDetails");
	  test.log(Status.INFO, "Starting test case");
	  objSignUpPage = new SingnUpPage(driver);
	  objSignUpPage.verifyHeader();
	  objSignUpPage.enterFullName("tester");
	  objSignUpPage.enterBussinessEmail("testUser@gmail.com");
	  objSignUpPage.enterPassword("testUserPaswrd");
	  test.log(Status.INFO, "Ending test case");
	  test.fail("second test");
	  fail();
  }
  @AfterMethod
  public void afterMethod(ITestResult result) throws IOException {
	  System.out.println("Test status " +result.getStatus());
	  System.out.println("Test status " +ITestResult.FAILURE);
	  if(result.getStatus() == ITestResult.FAILURE) {
		  test.fail("Snapshot below :" +test.addScreenCaptureFromPath(utils.screenCapturePath(driver)));
	  }
	
}
  @AfterTest
  public void tearDown() {
	  driver.quit();
	  extent.flush();
  }

}

package com.project.framework.test;

import org.testng.annotations.Test;

import com.project.framework.Pages.Homepage;
import com.project.framework.Pages.SingnUpPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class PageTest {
  WebDriver driver;
  Homepage objHomePage;
  SingnUpPage objSignUpPage;
  String url = "https://www.browserstack.com";
  
  @BeforeTest
  public void setup() {
	  driver = new ChromeDriver();
	  Reporter.log("Browser opened");
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	  driver.get(url);
	  driver.manage().window().maximize();
	  Reporter.log("URL Loaded " + url);
  }
  @Test(priority = 1)
  public void navigate_to_homepage_click_on_getStarted() {
	  objHomePage = new Homepage(driver);
	  objHomePage.verifyHeader();
	  objHomePage.clickOnGetStarted();
  }

  @Test(priority = 2)
  public void eneter_userDetails() {
	  objSignUpPage = new SingnUpPage(driver);
	  objSignUpPage.verifyHeader();
	  objSignUpPage.enterFullName("tester");
	  objSignUpPage.enterBussinessEmail("testUser@gmail.com");
	  objSignUpPage.enterPassword("testUserPaswrd");
  }
  
  @AfterTest
  public void tearDown() {
	  driver.quit();
  }
}

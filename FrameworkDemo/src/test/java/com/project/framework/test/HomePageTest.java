package com.project.framework.test;

import org.testng.annotations.Test;

import com.project.framework.Pages.Homepage;
import com.project.framework.Pages.SingnUpPage;
import com.project.framework.utils.BaseClass;
import com.project.framework.utils.ConfigFileReader;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class HomePageTest extends BaseClass{
	WebDriver driver;
	Homepage objHomePage;
	SingnUpPage objSignUpPage;
	ConfigFileReader config;
	String browserName,url;

  @BeforeTest
 
  public void setup() {
	  config = new ConfigFileReader();
	  browserName = config.getConfigValue("browser");
	  url = config.getConfigValue("url");
	  driver = BaseClass.init(browserName);
	  objHomePage = new Homepage(driver);
	  objSignUpPage = new SingnUpPage(driver);
	  driver.get(url);
  }
  @Test(priority = 1)
  public void navigate_to_homepage_click_on_getStarted() {
	  
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

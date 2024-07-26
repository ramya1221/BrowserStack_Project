package com.project.framework.test;

import org.testng.annotations.Test;

import com.project.framework.Pages.Homepage;
import com.project.framework.Pages.SingnUpPage;
import com.project.framework.utils.BaseClass;
import com.project.framework.utils.ConfigFileReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class PageTest2 extends BaseClass{
	WebDriver driver;
	Homepage objHomePage;
	SingnUpPage objSignUpPage;
	ConfigFileReader config;
	String url = "https://www.browserstack.com";

  @BeforeTest
  @Parameters("browser")//readed from testng
  public void setup(String browser) {
	  if(browser.equalsIgnoreCase("chrome")) {
		  driver = new ChromeDriver();
	  }
	  else if(browser.equalsIgnoreCase("edge")) {
		  driver = new EdgeDriver();
		  driver.manage().window().maximize();
	  }
	  
	  driver.get(url);
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

package com.project.framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.project.framework.utils.CommonUtils;

public class Homepage extends CommonUtils{
	
  WebDriver driver;
  
  @FindBy(xpath = "//h1")
  WebElement Header;
  
  
  
  @FindBy( xpath = "//*[@id=\"signupModalProductButton\"]")
  WebElement getStarted;
  
  
  public Homepage(WebDriver driver) {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
  }
  
  public  void verifyHeader() {
	  String getHeadertext = getText(Header);
	
}
  public void clickOnGetStarted() {
	  click(getStarted);
	
}

}

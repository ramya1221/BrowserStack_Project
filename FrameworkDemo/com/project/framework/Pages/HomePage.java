package com.project.framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePage extends CommonUtils{
	
  WebDriver driver;
  
  @FindBy(xpath = "//h1")
  WebElement Header;
  
  
  
  @FindBy( xpath = "//*[@id="signup"]")
  WebElement getStarted;
  
  
  public Homepage(WebDriver driver) {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
  }
  
  public  void veryHeader(WebDriver driver) {
	  String getHeadertext = getText(Header);
	
}

}

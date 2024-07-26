package com.project.framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SingnUpPage {
 WebDriver driver;
 @FindBy(xpath = "//h1")
 WebElement Header;
 @FindBy(xpath = "//*[@id=\"user_full_name\"]")
 WebElement userName;
 @FindBy(xpath = "//*[@id=\"user_email_login\"]")
 WebElement bussinessEmail;
 @FindBy(xpath = "//*[@id=\"user_password\"]")
 WebElement password;
 
 public SingnUpPage(WebDriver driver) {
	 this.driver = driver;
	 PageFactory.initElements(driver, this);	
 }
 public void verifyHeader() {
	 String getHeaderText = Header.getText().trim();	

 }
 public void enterFullName(String arg1) {
	 userName.sendKeys(arg1);
	

 }
 public void enterBussinessEmail(String arg1) {
	 bussinessEmail.sendKeys(arg1);
	
 }
 public void enterPassword(String arg1) {
	 password.sendKeys(arg1);
 }
}

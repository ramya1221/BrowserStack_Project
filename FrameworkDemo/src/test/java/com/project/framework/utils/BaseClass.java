package com.project.framework.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
 static WebDriver driver;
 public static WebDriver init(String browserName) {
	if(browserName.equalsIgnoreCase("Chrome")) {
		driver = new ChromeDriver();
	}else if(browserName.equalsIgnoreCase("Firefox")){
		driver = new FirefoxDriver();
	}
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	return driver;
		
 }
 public static void close() {
	 driver.quit();
	
}
 
}

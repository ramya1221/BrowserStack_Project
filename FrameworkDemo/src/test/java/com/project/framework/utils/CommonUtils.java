package com.project.framework.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;

public class CommonUtils {

 public String screenCapturePath(WebDriver driver) throws IOException {
		Date d = new Date();
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		
		//Capture Screenshot as a file object
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		String fileName = "screenshot_" + d.toString().replace(":", "_").replace(" ", "_")+ ".png";
		System.out.println("filename: "+ fileName);
		String path = "extent/screenshot/" + fileName;
		//Save the screenshot to a desired location
		Files.copy(srcFile, new File(path));
	    return path;
		
	}
 public void click(WebElement elem) {
	 try {
		elem.click();
	} catch (NoSuchElementException e) {
		System.out.println("Element not found");
	}catch(ElementClickInterceptedException e) {
		System.out.println("Element not clickabale");
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}	
}
 public String getText(WebElement elem) {	
	 String text = null;
	 try {
		text = elem.getText();
		System.out.println(text);
		return text;
	} catch (Exception e) {
		System.out.println(e.getMessage());
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return text;
	 
 }
 
}

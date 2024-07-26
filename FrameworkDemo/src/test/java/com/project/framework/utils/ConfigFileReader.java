package com.project.framework.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
  private Properties properities;
  private final String PropertyFilePath = "resources/config.properities";
  
  public  ConfigFileReader() {
   BufferedReader reader;
   try {
	   reader = new BufferedReader(new FileReader(PropertyFilePath));
	   properities = new Properties();
	   try {
		   properities.load(reader);
		   reader.close();
	   } catch (IOException e) {
		 e.printStackTrace();
	   }
		
	}catch(FileNotFoundException e) {
		e.printStackTrace();
		throw new RuntimeException("properities not found at " + PropertyFilePath);
		
      }
    }
  
  public long getImplicitWait() {
	  String implicitWait = properities.getProperty("ConfigFileReader");
	  if(implicitWait != null) return Long.parseLong(implicitWait);
	  else throw new RuntimeException("Implicit wait not specified in Configuration.properities file.");
	 }
  public String getApplicationUrl() {
	  String url = properities.getProperty("url");
	  if(url != null) return url;
	  else throw new RuntimeException("Url not specified in the Configuration.properities file.");
	}
  public String getBrowser() {
	  String url = properities.getProperty("browser");
	  if(url != null) return url;
	  else throw new RuntimeException("Browser not specified in the Configuration.properities file.");
	}
  public String getConfigValue(String Key) {
	  String keyvalue = properities.getProperty(Key);
	  if(keyvalue != null) return keyvalue;
	  else throw new RuntimeException("Key not specified in the Configuration.properities file.");
	}
	
 
}

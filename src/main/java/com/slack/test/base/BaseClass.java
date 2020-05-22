package com.slack.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public WebDriver driver;
	
	public Properties prop;
	
	public WebDriver Launch_driver(String  browserName)
	{
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\RahKumar\\Desktop\\Remote\\chromedriver.exe");
			if(prop.getProperty("headless").equals("yes"))
			{
			
		       ChromeOptions options =new ChromeOptions();
		       options.addArguments("--headless");
		       driver=new ChromeDriver(options);
			}else
			{
				driver=new ChromeDriver();
				
			}
			
			}
		     return driver ; 
		       
		}
	
	public Properties Launc_Properties() throws FileNotFoundException
	{
		prop =new Properties();
		File Data =new File("C:\\Users\\RahKumar\\SeleniumTest\\SlackFrame\\src\\main\\java\\com\\slack\\test\\config\\config.properties");
		
			FileInputStream ip =new FileInputStream("Data");
			
				try {
					prop.load(ip);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				
		return prop;
		
	}
		

}
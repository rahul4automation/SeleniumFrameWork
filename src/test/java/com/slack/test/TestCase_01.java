package com.slack.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.slack.keyword.engine.UtilLib;


public class TestCase_01 {

	WebDriver driver;

	@BeforeTest
	public void setup() throws IOException

	{

		System.setProperty("webdriver.gecko.driver","C:\\Users\\RahKumar\\Desktop\\Remote\\geckodriver.exe");
		driver =new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		System.out.println("Browser is Open");
		
	}

	@DataProvider
	public Object[][] getLoginData() throws InvalidFormatException 
	{
		Object data[][] =UtilLib.getTestData("LoginData");
		return data;
	}



	@Test(priority=1 ,dataProvider="getLoginData")
	public void LoginFeature(String UserName,String Password)
	{
		
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(UserName);
	    driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Password);
		
	}
		 
	@AfterTest
	public void TearDown()
	{
		
		System.out.println("test is pass ");

	}

}






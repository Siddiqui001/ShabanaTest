package com.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class MyFather {

	WebDriver driver;
	ThreadLocal<WebDriver> ayaan;

	
	public WebDriver ayaanget() {
		return ayaan.get();
	}
	
	
	@BeforeMethod
	public void r() {
		ayaan= new ThreadLocal<WebDriver>();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\MATEEQ\\Downloads\\New folder (2)\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();
		ayaan.set(driver);
		
		
		ayaanget().manage().window().maximize();

	}

	@AfterMethod
	public void u() {
		ayaanget().quit();
	}

}

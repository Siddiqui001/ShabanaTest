package com.sample;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyTest {

	ExtentHtmlReporter htmlreport;
	ExtentReports creator;
	WebDriver driver;

	@BeforeTest
	public void m() {
		htmlreport = new ExtentHtmlReporter(new File("shabana.html"));
		creator = new ExtentReports();
		creator.attachReporter(htmlreport);
	}

	@BeforeMethod
	public void jj() {

		// WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MATEEQ\\Downloads\\New folder (2)\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.yahoo.com/");
	}

	@AfterTest
	public void yy() {
		creator.flush();
	}

	@AfterMethod
	public void hh() {
		driver.quit();

	}

	 public String captureScrenshot() throws IOException {
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date  d= new Date();
		SimpleDateFormat fu= new SimpleDateFormat("ddmmyyyyhhmmss");
		String ee=	fu.format(d);
		FileHandler.copy(f, new File(ee +".jpg"));
		String dest=ee+".jpg";
		return dest;
	}
	
	
	@Test
	public void VerifyTitle() throws IOException {
		ExtentTest shabanaLogger = creator.createTest("VerifyTitle");
		shabanaLogger.log(Status.INFO, "Browser INvoked...");
		shabanaLogger.log(Status.INFO, "Navaigated to URL...");
		shabanaLogger.log(Status.INFO, "screen" + shabanaLogger.addScreenCaptureFromPath(captureScrenshot()));
		String actualTitle = driver.getTitle();
		String expectedTitle = "Hello";
		shabanaLogger.log(Status.INFO, "screen" + shabanaLogger.addScreenCaptureFromPath(captureScrenshot()));
		
		
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Yeah Our Title Matched..");
			shabanaLogger.log(Status.PASS, "title matched...");
		} else {
			System.out.println("Nooh Our Title didn't Matched..");
			shabanaLogger.log(Status.FAIL, "title DID'T matched...");
			shabanaLogger.log(Status.INFO, "screen" + shabanaLogger.addScreenCaptureFromPath(captureScrenshot()));
		}
	}

	@Test
	public void Adddetails() throws IOException {
		ExtentTest shabanaLogger = creator.createTest("VerifyAdddetails");
		shabanaLogger.log(Status.INFO, "Browser INvoked...");
		shabanaLogger.log(Status.INFO, "Navaigated to URL...");
		driver.findElement(By.id("login-username")).sendKeys("Hello");

		driver.findElement(By.id("login-signin")).click();
		shabanaLogger.log(Status.INFO, "Ihave Submmited the form");
		String actualdata = driver.findElement(By.xpath("//strong[contains(text(),'Enter')]")).getText();
		String Expecteddata = "Siddiqui";

		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f, new File("abcd.jpg"));

		if (actualdata.contains(Expecteddata)) {
			shabanaLogger.log(Status.PASS, "value matched");
		} else {
			shabanaLogger.log(Status.INFO, "screen" + shabanaLogger.addScreenCaptureFromPath("abcd.jpg"));
			shabanaLogger.log(Status.FAIL, "value  didn't matched");
		}

	}

}

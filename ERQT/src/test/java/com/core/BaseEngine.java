package com.core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseEngine {

	public static WebDriver driver; // shabana

	public ExtentHtmlReporter htmlreport;
	public ExtentReports creator;

	@BeforeTest
	public void m() {
		htmlreport = new ExtentHtmlReporter(new File("shabana.html"));
		creator = new ExtentReports();
		creator.attachReporter(htmlreport);
	}

	@AfterTest
	public void yy() {
		creator.flush();
	}

	@BeforeMethod
	public void invokeBrowser() {

		switch ("Chrome") {

		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://demo.guru99.com/V4/");
			break;

		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get("https://demo.guru99.com/V4/");
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get("https://demo.guru99.com/V4/"); // Property file
			break;

		default:
			System.out.println("Browser is not available..");
			break;
		}

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	public String captureScrenshot() throws IOException {
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		SimpleDateFormat fu = new SimpleDateFormat("ddmmyyyyhhmmss");
		String ee = fu.format(d);
		FileHandler.copy(f, new File(ee + ".jpg"));
		String dest = ee + ".jpg";
		return dest;
	}

}

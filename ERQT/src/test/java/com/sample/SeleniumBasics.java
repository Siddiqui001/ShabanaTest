package com.sample;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SeleniumBasics {

	public static void main(String[] args) throws InterruptedException, IOException {

		 //System.setProperty("webdriver.chrome.driver","C:\\Users\\MATEEQ\\Downloads\\New folder (2)\\New folder\\chromedriver.exe");
		
		 
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/select-menu");

		WebElement ele = driver.findElement(By.xpath("//div[text()='Interactions']"));

		JavascriptExecutor re = (JavascriptExecutor) driver;
		re.executeScript("arguments[0].scrollIntoView();", ele);

		File trry = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);

		FileHandler.copy(trry, new File("FullPageScreenshot.png"));

		// window.scrollBY(250,250)

		Thread.sleep(3000);

		driver.quit();

	}
}

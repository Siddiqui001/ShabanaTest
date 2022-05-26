package com.sample;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyReader {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demoqa.com/automation-practice-form");

		WebElement re = driver.findElement(By.xpath("//input[@id='firstName']"));

		Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10000)).pollingEvery(Duration.ofMillis(100));

		wait.until(ExpectedConditions.visibilityOf(re));

		re.sendKeys("Ayaan");
		
		driver.quit();

	}

}

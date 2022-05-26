package com.shabana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tr[3]/td[1]")
	WebElement managerID;

	// By managerID = By.xpath("//tr[3]/td[1]");

	public String verifytheName() {
		// String name = driver.findElement(managerID).getText();
		String name = managerID.getText();
		return name;
	}

}

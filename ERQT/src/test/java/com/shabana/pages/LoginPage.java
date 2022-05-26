package com.shabana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//input[@name='uid']")
	WebElement loginUserID;

	@FindBy(xpath="//input[@name='password']")
	WebElement loginPassword;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement loginButton;
	
	public void loginIntoApp() {
		//driver.findElement(loginUserID).sendKeys("mngr409750");
		loginUserID.sendKeys("mngr409750");
		loginPassword.sendKeys("EbYsEtE");
		//driver.findElement(loginButton).click();
		loginButton.click();
	}

}

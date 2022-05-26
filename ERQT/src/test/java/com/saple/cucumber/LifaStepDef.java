package com.saple.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LifaStepDef {

	WebDriver driver;

	@Before
	public void m() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/V4/");
	}

	@After
	public void h() {
		driver.quit();
	}
	
	
	@Given("^Appliaction form is diplayed to user for signin$")
	public void appliaction_form_is_diplayed_to_user_for_signin() {

		SoftAssert s = new SoftAssert();
		if (driver.findElement(By.xpath("//input[@name='btnLogin']")).isDisplayed()) {

		} else {
			s.fail();
			s.assertAll();
		}

	}

	@When("^user enters valid credentials$")
	public void user_enters_valid_credentials() {
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr409750");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("EbYsEtE");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}

	@Then("^system should redirect user to home page$")
	public void system_should_redirect_user_to_home_page() {
		SoftAssert s = new SoftAssert();
		if (driver.findElement(By.xpath("//tr[3]/td[1]")).isDisplayed()) {

		} else {
			s.fail();
			s.assertAll();
		}
	}

	@And("^system should displaye the username on home page$")
	public void system_should_displaye_the_username_on_home_page() {
		String text = driver.findElement(By.xpath("//tr[3]/td[1]")).getText();
		SoftAssert s = new SoftAssert();
		if (text.contains("mngr409750")) {

		} else {
			s.fail();
			s.assertAll();
		}
	}

}

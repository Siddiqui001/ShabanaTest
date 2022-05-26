package com.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.sample.Mylistern.class)
public class FirstTestNG extends MyFather {

	@Test
	public void myTest() {
		ayaanget().get("https://www.linkedin.com/feed/");
	}

	@Test
	public void myTest1() {
		ayaanget().get("https://www.youtube.com/feed/");
	}

	@Test
	public void myTest66() {
		ayaanget().get("https://www.facebook.com");
	}

}
package comGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import bsh.Capabilities;

public class MyGrid {

	@Test
	public void g() throws MalformedURLException, InterruptedException {

		DesiredCapabilities c = new DesiredCapabilities();
		c.setBrowserName("chrome");
		c.setPlatform(Platform.WIN10);
		URL u = new URL("http://192.168.0.114:4444/wd/hub");
		WebDriver driver = new RemoteWebDriver(u, c);

		driver.get("https://www.toolsqa.com/selenium-webdriver/selenium-grid-how-to-easily-setup-a-hub-and-node/");
		Thread.sleep(5000);
		
		driver.quit();

	}

}

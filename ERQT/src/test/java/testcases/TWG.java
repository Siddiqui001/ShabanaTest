package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.core.BaseEngine;
import com.shabana.pages.HomePage;
import com.shabana.pages.LoginPage;

public class TWG extends BaseEngine {
	@Test
	public void XDMJKJNDD() throws IOException {
		ExtentTest ayaan = creator.createTest("verifythePageTitle");
		LoginPage lp = new LoginPage(driver);

		HomePage hp = new HomePage(driver);
		lp.loginIntoApp();
		ayaan.log(Status.INFO, "we are logge in..");

		String name = hp.verifytheName();
		if (name.contains("mngr409750")) {
			ayaan.log(Status.PASS, "NAME MATCHED...");
			ayaan.log(Status.INFO, "dsh"+ayaan.addScreenCaptureFromPath(captureScrenshot()));
		} else {
			 //ayaan.log(Status.INFO,""+ MediaEntityBuilder.createScreenCaptureFromPath(captureScrenshot()).build());
		
			ayaan.log(Status.FAIL, "NAME  DID NOT MATCHED...");
		}

}
}

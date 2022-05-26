package com.sample;

import org.testng.annotations.Test;

public class SecondTestNG extends MyFather {


	
	@Test(groups= {"Sanity","Regression"})
	public void fileuploadfunctionalityTest() {
		System.out.println("Hello from testng..2");
	}
	


	
	
}

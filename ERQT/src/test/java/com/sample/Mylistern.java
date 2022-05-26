package com.sample;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Mylistern implements ITestListener  {

	public void onTestStart(ITestResult result) {
		System.out.println("Test cases has been started...");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test cases has successtake screenshot...");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test cases has Failstake screenshot...");
	}
	



}

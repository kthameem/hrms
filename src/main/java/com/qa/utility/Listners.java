package com.qa.utility;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.ExtentReport.ExtentReportConfiguration;
import com.qa.baseclass.BaseClass;

public class Listners extends BaseClass implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		String pathString = result.getMethod().getMethodName();
		try {
			ExtentReportConfiguration.getScreenShotsBase64(pathString);
		} catch (IOException e) {
			System.out.println("Check the path of screenshot");
		}

	}
}

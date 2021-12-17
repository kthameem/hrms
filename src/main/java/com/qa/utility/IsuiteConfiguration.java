package com.qa.utility;

import java.io.IOException;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import com.qa.ExtentReport.ExtentReportConfiguration;
import com.qa.TestData.ExcelReadData;
import com.qa.baseclass.BaseClass;

public class IsuiteConfiguration extends BaseClass implements ISuiteListener {

	public ExtentReportConfiguration ERConfig = new ExtentReportConfiguration();
	private final String pathString = "src\\main\\java\\com\\qa\\config\\congi.Properties";

	@Override
	public void onStart(ISuite suite) {
		try {
			ExcelReadData.excelReadDAta();
			propertyLoad(pathString);
			String testName = properties.getProperty("TestName");
			String reportName = properties.getProperty("reportName");
			String documentTitle = properties.getProperty("documentTitle");
			String assignAuthor = properties.getProperty("assignAuthor");
			String assignDevice = properties.getProperty("assignDevice");
			String category = properties.getProperty("category");
			ERConfig.extentReportPassSetup(reportName, documentTitle, assignAuthor, category, assignDevice, testName);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("On start Isuite failed");
		}
	}
}

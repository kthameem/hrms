package com.qa.ExtentReport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.qa.baseclass.BaseClass;

/**
 * 
 * @author hariprasath
 *
 *         We can use the above method alternative using xml and json
 *         extentSparkReporter.loadXMLConfig(File path);
 *         extentSparkReporter.loadJSONConfig(file path); ***Important**** every
 *         test run the report generate and automatically open in default
 *         browser to use---> Desktop.getDesktop().browse(new
 *         File("reportName.html").Uri()); " &nbsp; <br />
 *         &nbsp; " is using for enter the next line of the log
 *
 */

public class ExtentReportConfiguration extends BaseClass {

	public static ExtentTest test1;
	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentReports extentReport;
	public static ExtentTest test;
	public static ExtentTest passTest;
	static String base64extent;
	public static String pathString1;

	public void extentReportPassSetup(String reportName, String documentTitle, String assignAutor, String category,
			String assignDevice, String testName) throws IOException {
		extentReport = new ExtentReports();
		extentSparkReporter = new ExtentSparkReporter("target\\passReport.html");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setReportName(reportName);
		extentSparkReporter.config().setDocumentTitle(documentTitle);
		extentReport.attachReporter(extentSparkReporter);
		test = extentReport.createTest(testName).assignAuthor(assignAutor).assignCategory(category)
				.assignDevice(assignDevice);
		test.info("Report of login screen");
		test.info("Report of logout screen");
		test.info("Report of login screen url's");
		test.info("Report login screen with valid credential");
		test.info("Report login screen with invalid credential");
		test.info("Report of forgot password");
	}

	public static ExtentTest passTest(String testName) {
		return extentReport.createTest(testName);
	}

	public static String getScreenShotsBase64(String methodString) throws IOException {
		System.out.println(methodString);
		TakesScreenshot scrShot = ((TakesScreenshot) getDriver());
		File src1 = scrShot.getScreenshotAs(OutputType.FILE);
		pathString1 = System.getProperty("user.dir") + "\\target\\screenshots\\" + methodString.substring(0, 10)
				+ RandomStringUtils.randomNumeric(2) + ".png";
		FileUtils.copyFile(src1, new File(pathString1));
		byte[] jjBytes = IOUtils.toByteArray(new FileInputStream(pathString1));
		return base64extent = Base64.getEncoder().encodeToString(jjBytes);
	}

	@AfterTest
	public static void extentReportFlush() {
		extentReport.flush();
	}
}

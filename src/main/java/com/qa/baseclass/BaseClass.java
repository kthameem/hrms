package com.qa.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.ExtentReport.ExtentReportConfiguration;
import com.qa.TestData.ExcelReadData;
import com.qa.pageObjects.CH_EmpProfileObjects;
import com.qa.pageObjects.Dashboard_Objects;
import com.qa.pageObjects.LoginPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties properties = null;
	protected static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
	protected static byte ImplicitlyWait = 10;
	protected byte pageLoadTimeOut = 100;
	private String browserName = null;
	public SoftAssert softAssert = new SoftAssert();
	public LoginPageObjects loginPageObject = null;
	public ExtentReportConfiguration ERConfig;
	public static WebDriverWait wait;
	public String url = null, textPage = null;
	public WebDriver driver = getDriver();
	// browser stack
	public static final String AUTOMATE_USERNAME = "hariofficial_5OrlzM";
	public static final String AUTOMATE_ACCESS_KEY = "pv6QXkT83PEZATxqENd9";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";

	@BeforeSuite
	public WebDriver driverSetup() throws IOException {
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("browserName", "Safari");
//		capabilities.setCapability("browserVersion", "14.1");
//		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//		browserstackOptions.put("os", "OS X");
//		browserstackOptions.put("osVersion", "Big Sur");
//		browserstackOptions.put("projectName", "Prople Eployee Profile");
//		browserstackOptions.put("buildName", "BUild 3.1");
//		browserstackOptions.put("sessionName", "Employee Profile Test");
//		browserstackOptions.put("local", "false");
//		browserstackOptions.put("seleniumVersion", "3.14.0");
//		HashMap<String, Object> safariOptions = new HashMap<String, Object>();
//		safariOptions.put("enablePopups", "true");
//		browserstackOptions.put("safari", safariOptions);
//		capabilities.setCapability("bstack:options", browserstackOptions);
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setCapability("os", "OS X");
//		caps.setCapability("os_version", "Big Sur");
//		caps.setCapability("browser", "Chrome");
//		caps.setCapability("browser_version", "latest");
//		caps.setCapability("browserstack.local", "false");
//		caps.setCapability("browserstack.selenium_version", "3.14.0");
		ERConfig = new ExtentReportConfiguration();
		browserName = properties.getProperty("browser");
		url = properties.getProperty("url");
		if (threadLocal == null) {
			System.out.println("Driver is Empty");
			return null;
		}
		browserName.toLowerCase();
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().arch64().setup();
			threadLocal.set(new ChromeDriver());
			// new RemoteWebDriver(new URL(URL), caps)
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().arch64().setup();
			threadLocal.set(new FirefoxDriver());
		} else if (browserName.equals("internet explolar")) {
			WebDriverManager.iedriver().arch64().setup();
			threadLocal.set(new InternetExplorerDriver());
		} else if (browserName.equals("opera")) {
			WebDriverManager.operadriver().arch64().setup();
			threadLocal.set(new OperaDriver());
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(ImplicitlyWait, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
		wait = new WebDriverWait(getDriver(), ImplicitlyWait);
		getDriver().get(url);
		ExtentTest environmentTest = ExtentReportConfiguration.passTest("Test Environment Setup");
		environmentTest.info("The property file sucessfully loaded");
		environmentTest.info("The Extented report scuessfully loaded");
		environmentTest.info("The Log4j sucessfully loaded");
		ExtentTest baseTest = ExtentReportConfiguration.passTest("Test Data Setup");
		baseTest.info("The Browser sucessfully loaded");
		baseTest.info("The " + browserName + " successfully initialized");
		baseTest.pass(MarkupHelper.createLabel("The navigate url is: " + url, ExtentColor.PURPLE));
		String[][] validData = { { "UserName", "Password", "Valid or Not" }, { "admin", "Admin1@", "Valid" } };
		baseTest.pass(MarkupHelper.createCodeBlock("Through excel uploaded valid data as showing below"));
		baseTest.info(MarkupHelper.createTable(validData).getMarkup());
		String[][] Data = ExcelReadData.excelDataExtentDisplay();
		baseTest.pass(MarkupHelper.createCodeBlock("Through excel uploaded invalid data as showing below"));
		baseTest.info(MarkupHelper.createTable(Data).getMarkup());
		pageObjectTriggers(getDriver());
		return getDriver();
	}

	@SuppressWarnings("unused")
	public void pageObjectTriggers(WebDriver driver) {
		loginPageObject = new LoginPageObjects(driver);
		CH_EmpProfileObjects employeeObjects = new CH_EmpProfileObjects(driver);
		new Dashboard_Objects(driver);

	}

	public static synchronized WebDriver getDriver() {
		return threadLocal.get();

	}

	public Properties propertyLoad(String pathString) {
		try {
			File file = new File(pathString);
			FileInputStream fileInputStream = new FileInputStream(file);
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return properties;
	}

	public String toastMessage() {
		javascriptExecutorBorder(CH_EmpProfileObjects.toastMesaageVerify);
		System.out.println(CH_EmpProfileObjects.toastMesaageVerify.getText());
		return CH_EmpProfileObjects.toastMesaageVerify.getText();
	}

	public void javascriptExecutorBorder(WebElement element) {
		if (getDriver() == null) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].style.border='3px solid red'", element);
		} else {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
			jsExecutor.executeScript("arguments[0].style.border='3px solid red'", element);
		}
	}

	public void javascriptExecuorScrollDown(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-250)");
	}

	public void generateAlert(String message) throws InterruptedException {
		if (getDriver() == null) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("alert('" + message + "')");
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} else {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
			jsExecutor.executeScript("alert('" + message + "')");
			Thread.sleep(2000);
			Alert alert = getDriver().switchTo().alert();
			alert.accept();
		}
	}

	public String generate_EntireTextPage() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		textPage = jsExecutor.executeScript("return document.documentElement.innerText").toString();
		return textPage;
	}

	public void smokeTest() {
		pageObjectTriggers(getDriver());
		LoginPageObjects.userName.sendKeys("admin");
		LoginPageObjects.password.sendKeys("Admin1@");
		LoginPageObjects.login.click();
	}

	//@AfterSuite
	public void tearDown() {
		getDriver().close();
	}

}

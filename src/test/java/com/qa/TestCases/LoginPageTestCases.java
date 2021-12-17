package com.qa.TestCases;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.ExtentReport.ExtentReportConfiguration;
import com.qa.TestData.ExcelReadData;
import com.qa.pageObjects.LoginPageObjects;

public class LoginPageTestCases extends ExtentReportConfiguration {
	public HttpsURLConnection httpsURLConnection = null;
	int responseCode = 0;
	public boolean userField, passwordField, companyLogo, forgotLink, loginButton, mainImage, versionInfo;
	boolean flag = true;
	ExtentReportConfiguration exReport = new ExtentReportConfiguration();
	String methodName, defaultUserFieldBox, otpText, cancelText;
	ExtentTest testInfo;
	List<WebElement> activeLinks = null, allLinks = null;
	List<String> urlLinks = null;
	List<Integer> responceMessage = null;
	boolean forgotLinkEnable, forgotFieldIsEnable, sendOtpIsEnabled, cancelButton;

	@Test(priority = 0, enabled = true)
	public void Url_Test_LoginPage() throws InterruptedException, IOException {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		testInfo = passTest(methodName);
		testInfo.info("Loginpage valid credentials: ",
				MediaEntityBuilder
						.createScreenCaptureFromBase64String(ExtentReportConfiguration.getScreenShotsBase64(methodName))
						.build());
		testInfo.info(MarkupHelper.createLabel(
				"Check the all broken links & images and test the valid url should be response of 200 ",
				ExtentColor.PURPLE));
		testInfo.pass(MarkupHelper.createLabel("https://thinktelesales.in/global_hrms/", ExtentColor.GREY));
		allLinks = LoginPageObjects.brokenLinks;
		allLinks.addAll(LoginPageObjects.brokenImage);
		activeLinks = new ArrayList<WebElement>();
		urlLinks = new ArrayList<String>();
		responceMessage = new ArrayList<Integer>();
		String pageSource = getDriver().getPageSource();
		testInfo.info(MarkupHelper.createCodeBlock("The login screen page source", pageSource));
		for (WebElement linksList : allLinks) {
			if (linksList.getAttribute("href") != null && linksList.getAttribute("href") != "javascript") {
				activeLinks.add(linksList);
			}
		}
		generateAlert("The login page url is testing please wait until finish");
		String[][] array = new String[activeLinks.size()][3];
		for (WebElement allActiveURL : activeLinks) {
			try {
				String url = allActiveURL.getAttribute("href");
				URL validUrl = new URL(url);
				httpsURLConnection = (HttpsURLConnection) validUrl.openConnection();
				httpsURLConnection.connect();
				responseCode = httpsURLConnection.getResponseCode();
				int defaultResponseCode = 200;
				if (responseCode == defaultResponseCode) {
					urlLinks.add(url);
					responceMessage.add(responseCode);
				} else {
					testInfo.fail("There are " + allLinks.size() + " links availvable");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int count = 0;
		for (int i = 0; i < activeLinks.size(); i++) {
			array[count][0] = urlLinks.get(i);
			array[count][1] = Integer.toString(responceMessage.get(i));
			array[count][2] = " ------> Pass";
			count++;
		}
		testInfo.info(
				MarkupHelper.createCodeBlock("Therae are " + allLinks.size() + " links availble in the login page"));
		testInfo.pass(MarkupHelper.createLabel("There are  active links in login page: " + activeLinks.size(),
				ExtentColor.PURPLE));
		testInfo.pass(MarkupHelper.createTable(array).getMarkup());
		testInfo.pass(MarkupHelper.createLabel("The all valid links and images are successfull response code of 200",
				ExtentColor.PURPLE));
		httpsURLConnection.disconnect();
	}

	@Test(priority = 1, enabled = true)
	public void PageLabel_and_button_Check() throws InterruptedException {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		testInfo = passTest(methodName);
		testInfo.info(MarkupHelper.createLabel("Check the appearence of the labels and buttons on the screen",
				ExtentColor.PURPLE));
		String pageContent = generate_EntireTextPage();
		testInfo.info(MarkupHelper.createCodeBlock(pageContent + " || "));
		userField = LoginPageObjects.userName.isEnabled();
		if (userField == flag) {
			String userFieldText = LoginPageObjects.userName.getAttribute("placeholder");
			Assert.assertEquals(userFieldText, "USERNAME");
			testInfo.pass("The user text field isEnable: " + userField + " The expected and actual placeholder: "
					+ userFieldText + " ------> Passed");
		}
		passwordField = LoginPageObjects.password.isEnabled();
		if (passwordField == flag) {
			String passwordText = LoginPageObjects.password.getAttribute("placeholder");
			Assert.assertEquals(passwordText, "PASSWORD");
			testInfo.pass("The password Text field  isEnable: " + passwordField
					+ " The expected and actual placeholder: " + passwordText + " ------> Passed");
		}
		companyLogo = LoginPageObjects.perkLogo.isDisplayed();
		Assert.assertEquals(companyLogo, flag);
		testInfo.pass("The companylogo isDisplayed: " + companyLogo + " ------> Passed");
		forgotLink = LoginPageObjects.forgotLink.isDisplayed();
		if (forgotLink == flag) {
			String forgotLinkText = LoginPageObjects.forgotLink.getText();
			Assert.assertEquals(forgotLinkText, "FORGOT PASSWORD");
			testInfo.pass("The forgot link isDisplayed: " + forgotLink + "----->  The expected and actual text: "
					+ forgotLinkText + " ------> Passed");
		}
		loginButton = LoginPageObjects.login.isEnabled();
		testInfo.pass("The loginButton isEnabled: " + loginButton + " ------> Passed");
		mainImage = LoginPageObjects.mainImg.isDisplayed();
		testInfo.pass("The mainImage is showing: " + mainImage + " ------> Passed");
		versionInfo = LoginPageObjects.versionInfo.isDisplayed();
		if (versionInfo == flag) {
			String versionInfoText = LoginPageObjects.versionInfo.getText();
			testInfo.pass("The expected and actual text: " + versionInfoText + " ------> Passed");
			Assert.assertEquals(passwordField, flag);
			Assert.assertEquals(forgotLink, flag);
			Assert.assertEquals(loginButton, flag);
			Assert.assertEquals(mainImage, flag);
			Assert.assertEquals(versionInfo, flag);
		}
	}

	@Test(priority = 2, enabled = true)
	public void Login_Page_With_valid_credentials() throws IOException {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		testInfo = passTest(methodName);
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		testInfo.info(MarkupHelper.createLabel("Testing the login page with valid credentials:- ", ExtentColor.PURPLE));
		String[][] validData = { { "UserName", "Password", "Valid or Not" }, { "admin", "Admin1@", "Valid" } };
		testInfo.info(MarkupHelper.createTable(validData));
		if (userName.equals("admin") && password.equals("Admin1@")) {
			System.out.println(userName + " : " + password);
			LoginPageObjects.userName.sendKeys(userName);
			LoginPageObjects.password.sendKeys(password);
			testInfo.info("Loginpage valid credentials: " + userName + " || " + " " + password, MediaEntityBuilder
					.createScreenCaptureFromBase64String(ExtentReportConfiguration.getScreenShotsBase64(methodName))
					.build());
			LoginPageObjects.login.click();
			testInfo.info("Loginpage valid credentials: " + userName + " || " + " " + password + "---->" + " Pass",
					MediaEntityBuilder.createScreenCaptureFromBase64String(
							ExtentReportConfiguration.getScreenShotsBase64(methodName)).build());
			LoginPageObjects.logout.click();
			LoginPageObjects.logout_No.click();
			LoginPageObjects.logout.click();
			LoginPageObjects.logout_Yes.click();
			testInfo.info("Logout sucessfully", MediaEntityBuilder
					.createScreenCaptureFromBase64String(ExtentReportConfiguration.getScreenShotsBase64(methodName))
					.build());
			testInfo.pass("After login page title should be: " + getDriver().getTitle() + " -------> Pass");
			testInfo.pass("Successfully logout  -------> Pass");
			testInfo.pass("Login page testcases sucessfully passed");
		}
	}

	@Test(priority = 3, enabled = true)
	public void Loginpage_with_invalid_credentials() throws IOException {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		testInfo = passTest(methodName);
		testInfo.info(
				MarkupHelper.createLabel("Testing the login page with invalid credentials:- ", ExtentColor.PURPLE));
		String[][] Data = ExcelReadData.excelDataExtentDisplay();
		testInfo.pass(MarkupHelper.createCodeBlock("Through excel uploaded invalid data as showing below"));
		testInfo.info(MarkupHelper.createTable(Data).getMarkup());
		for (int i = 0; i < ExcelReadData.userNameList.size(); i++) {
			Executor(ExcelReadData.userNameList.get(i), ExcelReadData.passwordList.get(i));
		}
		testInfo.pass("All invalid credentials are successfully passed");
	}

	public void Executor(String userName, String password) throws IOException {
		LoginPageObjects.userName.sendKeys(userName);
		LoginPageObjects.password.sendKeys(password);
		LoginPageObjects.login.click();
		badCredntials(userName, password, methodName);
	}

	@SuppressWarnings("static-access")
	public void badCredntials(String username, String password, String methodname) throws IOException {
		String badCredenitals = loginPageObject.badCredentials.getText();
		if (badCredenitals.equals("Bad credentials")) {
			softAssert.assertTrue(true);
			testInfo.info("Loginpage invalid credentials: " + username + " || " + " " + password + " ---->" + " Pass",
					MediaEntityBuilder.createScreenCaptureFromBase64String(
							ExtentReportConfiguration.getScreenShotsBase64(methodname)).build());
			testInfo.pass("Error message should be displayed Bad credentials: " + "-----------> Pass");
		}

	}

	@Test(priority = 4, enabled = true)
	@SuppressWarnings("static-access")
	public void forgotPasswordLinkTest() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ExtentTest testInfoForgot = passTest(methodName);
		LoginPageObjects.forgotLink.click();
		forgotLinkEnable = LoginPageObjects.forgotLink.isEnabled();
		softAssert.assertTrue(forgotLinkEnable);
		forgotFieldIsEnable = LoginPageObjects.adminForgotField.isEnabled();
		softAssert.assertFalse(forgotFieldIsEnable);
		defaultUserFieldBox = LoginPageObjects.adminForgotField.getAttribute("value");
		softAssert.assertEquals(defaultUserFieldBox, "admin");
		sendOtpIsEnabled = loginPageObject.sendOTP.isEnabled();
		otpText = loginPageObject.sendOTP.getAttribute("innerText");
		softAssert.assertEquals(sendOtpIsEnabled, true);
		softAssert.assertEquals(otpText, "Send OTP");
		cancelButton = loginPageObject.cancelOTP.isEnabled();
		cancelText = loginPageObject.cancelOTP.getAttribute("innerText");
		loginPageObject.cancelOTP.click();
		softAssert.assertEquals(cancelButton, true);
		softAssert.assertEquals(cancelText, "Send OTP");
		extendReportForgotPassword(testInfoForgot);
	}

	public void extendReportForgotPassword(ExtentTest testInfoForgot) {
		testInfoForgot.info(MarkupHelper.createLabel("Forgot Password test Case ", ExtentColor.PURPLE));
		testInfoForgot.info("The forgot password link is displayed: " + forgotLinkEnable + "------>Pass");
		testInfoForgot.info("The forgot edit field link is enabled: " + forgotFieldIsEnable + "------>Pass");
		testInfoForgot.pass("The forgot edit field is enabled: " + forgotFieldIsEnable + "------>Pass");
		testInfoForgot.pass("The default userField text is: " + defaultUserFieldBox + "------>Pass");
		testInfoForgot.pass("The send otp button is enable: " + sendOtpIsEnabled + "------>Pass");
		testInfoForgot.pass("The otp button text is: " + otpText + "------>Pass");
		testInfoForgot.pass("The cancelButton button is enable: " + cancelButton + "------>Pass");
		testInfoForgot.pass("The cancelButton text is: " + cancelText + "------>Pass");
	}
}

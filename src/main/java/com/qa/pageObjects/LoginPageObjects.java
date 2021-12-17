package com.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	WebDriver driver;

	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(id = "u_name")
	public static WebElement userName;

	@FindBy(id = "u_pass")
	public static WebElement password;

	@FindBy(linkText = "FORGOT PASSWORD")
	public static WebElement forgotLink;

	@FindBy(id = "login")
	public static WebElement login;

	@FindBy(xpath = "(//p//span)[2]")
	public static WebElement badCredentials;

	@FindBy(xpath = "//img[@class='login-img']")
	public static WebElement mainImg;

	@FindBy(xpath = "//div[@class='col-lg-4']//img")
	public static WebElement perkLogo;

	@FindBy(xpath = "//small")
	public static WebElement versionInfo;

	@FindBy(xpath = "//a")
	public static List<WebElement> brokenLinks;

	@FindBy(xpath = "//img")
	public static List<WebElement> brokenImage;

	@FindBy(xpath = "//body")
	public static WebElement allContentPageText;

	@FindBy(xpath = "(//a//img)[7]")
	public static WebElement logout;

	@FindBy(xpath = "//a//button")
	public static WebElement logout_Yes;

	@FindBy(xpath = "(//button[contains(text(),'No')])[1]")
	public static WebElement logout_No;

	@FindBy(id = "forgetUName")
	public static WebElement adminForgotField;

	@FindBy(xpath = "(//button)[2]")
	public static WebElement sendOTP;

	@FindBy(xpath = "(//button)[3]")
	public static WebElement cancelOTP;
}

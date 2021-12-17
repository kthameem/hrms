package com.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_Objects {

	public Dashboard_Objects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Dashboard Highlights

	@FindBy(xpath = "(//a)[1]")
	public static WebElement dashBoardLink;

	// DashBoard Highlights

	@FindBy(xpath = "//span[@class='numbers']")
	public static WebElement empCount;

	@FindBy(xpath = "(//span[@class='numbers'])[2]")
	public static WebElement empCOst;

	@FindBy(xpath = "(//span[@class='numbers'])[3]")
	public static WebElement attrition;

	@FindBy(xpath = "(//span[@class='numbers'])[4]")
	public static WebElement attendanceLevel;

	@FindBy(xpath = "(//span[@class='numbers'])[5]")
	public static WebElement noOfLocations;

	@FindBy(xpath = "(//span[@class='numbers'])[6]")
	public static WebElement newJoines;

	// Dashboard ChartVIew and Table View

	@FindBy(xpath = "//div[@id='main_0']//following::button/..//button[@title]")
	public static List<WebElement> table_Chart_View;

	// tableValue

	@FindBy(xpath = "//tbody[1]//tr")
	public static List<WebElement> tableRow;

	@FindBy(xpath = "//tbody")
	public static List<WebElement> tableTBODY;

	@FindBy(xpath = "//div[@class='chart-title']//span")
	public static List<WebElement> chartTittle;

	// Dashboard Setings btn

	@FindBy(xpath = "//button[@title='SETTINGS']")
	public static WebElement settingsBtn;

	@FindBy(xpath = "//label[@class='switch']")
	public static List<WebElement> switchBtn;

	@FindBy(xpath = "//*[text()='Submit']")
	public static WebElement switchSubmit;

	@FindBy(xpath = "//div[@id='cdk-drop-list-1']//div")
	public static List<WebElement> switchAscDsc;

	@FindBy(xpath = "//button[@title='REFRESH']")
	public static WebElement refreshBtn;

	@FindBy(xpath = "//*[text()='Profile & Dashboard']")
	public static WebElement refresh1;

	@FindBy(xpath = "//*[text()='Employee Movement']")
	public static WebElement refresh2;

	@FindBy(xpath = "(//button[text()='Close'])[2]")
	public static WebElement closeRefresh;

	@FindBy(xpath = "(//button[text()='Close'])[1]")
	public static WebElement closeSettingBtn;

	@FindBy(xpath = "//span[@id='timer_1']")
	public static WebElement dateTimeRef;

	@FindBy(xpath = "//span[@id='timer_5']")
	public static WebElement dateTimeRef1;

	// Dashboard Highlights

	@FindBy(xpath = "//*[normalize-space()='Active']")
	public static List<WebElement> activeEmp;

	@FindBy(xpath = "(//*[normalize-space()='Salary Check'])[3]")
	public static WebElement reportSalary;

	@FindBy(xpath = "(//a)[4]")
	public static WebElement reportLink;

	@FindBy(xpath = "(//*[normalize-space()='GROSS SALARY'])[3]")
	public static WebElement grossSalaryTable;

	@FindBy(xpath = "(//*[normalize-space()='STATUS'])[3]")
	public static WebElement status;

	@FindBy(xpath = "//tr[@role='row']//td[2]")
	public static List<WebElement> grossoryAmnt;

	@FindBy(xpath = "//*[text()='FLEXI']")
	public static WebElement flexi;

	@FindBy(xpath = "(//*[normalize-space()='WORK LOCATION'])[3]")
	public static WebElement workLocationTable;

	@FindBy(xpath = "//tr[@role='row']//td[4]")
	public static List<WebElement> workLocationList;

}

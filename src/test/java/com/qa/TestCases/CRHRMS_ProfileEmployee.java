package com.qa.TestCases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.qa.ReadExcelData.EmpProfileExcel;
import com.qa.baseclass.BaseClass;
import com.qa.pageObjects.CH_EmpProfileObjects;
import com.qa.pageObjects.LoginPageObjects;
import com.qa.utility.IRetryAnalyser;

public class CRHRMS_ProfileEmployee extends BaseClass {
	protected EmpProfileExcel empProfileExcel = new EmpProfileExcel();
	private Select select;
	int k = 0;
	protected WebDriverWait wait;
	WebDriver driver = getDriver();

	/**
	 * @ Clicking all Links in the CoreHRMS Menu
	 * 
	 */
	@Test(priority = 1, enabled = true)
	public void check_the_secondrySection_of_coreHRMS() throws InterruptedException {
		smokeTest();
		WebElement ssElement = wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.coreHrmsMenu));
		if (ssElement.isEnabled() == true) {
			ssElement.click();
		} else {
			System.exit(0);
		}
		generateAlert("Click all link: Core Hrms Section");
		CH_EmpProfileObjects.secondarySection.forEach(f -> {
			try {
				javascriptExecutorBorder(f);
				wait.until(ExpectedConditions.elementToBeClickable(f)).click();
			} catch (Exception e) {
				javascriptExecutorBorder(f);
				wait.until(ExpectedConditions.elementToBeClickable(f)).click();
			}

		});
		Thread.sleep(1500);
		try {
			ssElement.click();
		} catch (Exception e) {
			ssElement.click();
		}
		generateAlert("Sucessfully tested: Clicking all links");
	}

	/**
	 * 
	 * @Note:- -> I write the code only accept 3 rows in execel -> Book.xlsx
	 *         (Refer)-> Cell count start from 24th cell
	 */
	@Test(priority = 2, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void addEmployee() throws InterruptedException, IOException {
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.addButton)).click();
		empProfileExcel.excelReadDAta();
		generateAlert("Execel Data Loading...");
		List<String> excelDataList = (List<String>) empProfileExcel.employeeExcelInitilizer();
		int cellCount = 24;
		int lastCell = EmpProfileExcel.lastCellNum;
		int j = 1;
		int lastRowNum = EmpProfileExcel.sheet.getLastRowNum();
		generateAlert("Adding Employee Data...");
		for (int i = 1; i <= lastRowNum; i++) {
			sampledata(excelDataList.get(cellCount), excelDataList.get(cellCount + 1), excelDataList.get(cellCount + 2),
					excelDataList.get(cellCount + 3), excelDataList.get(cellCount + 4),
					excelDataList.get(cellCount + 5), excelDataList.get(cellCount + 6),
					excelDataList.get(cellCount + 7), excelDataList.get(cellCount + 8),
					excelDataList.get(cellCount + 9), excelDataList.get(cellCount + 10),
					excelDataList.get(cellCount + 11), excelDataList.get(cellCount + 12),
					excelDataList.get(cellCount + 13), excelDataList.get(cellCount + 14),
					excelDataList.get(cellCount + 15), excelDataList.get(cellCount + 16),
					excelDataList.get(cellCount + 17), excelDataList.get(cellCount + 18),
					excelDataList.get(cellCount + 19), excelDataList.get(cellCount + 20),
					excelDataList.get(cellCount + 21), excelDataList.get(cellCount + 22),
					excelDataList.get(cellCount + 23));
			if (j == 1) {
				cellCount = cellCount + lastCell;
			} else if (j == 2) {
				cellCount = cellCount + lastCell;
			} else {
				break;
			}
			j++;
			k++;
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.backButton)).click();
		}
		generateAlert("Employee Profiles Are Suceessfully added");
	}

	public void sampledata(String prfix, String title, String lastName, String middleName, String firstName,
			String nickName, String imagepath, String age, String month, String gender, String mblNum, String landNum,
			String email, String pscategory, String payRoll, String department, String subDept, String costCent,
			String bussinessUnit, String jobLevel, String postionTitle, String dateHire, String lineManger,
			String depHead) throws InterruptedException, IOException {
		try {
			selectFromDropdown(CH_EmpProfileObjects.prefixCode, prfix, "text");
			selectFromDropdown(CH_EmpProfileObjects.title, title, "text");
			CH_EmpProfileObjects.lastName.sendKeys(lastName + RandomStringUtils.randomAlphabetic(3));
			CH_EmpProfileObjects.middleName.sendKeys(middleName);
			CH_EmpProfileObjects.firstName.sendKeys(firstName);
			CH_EmpProfileObjects.nickName.sendKeys(nickName);
			CH_EmpProfileObjects.dob.click();
			dateSelection("7", "1992", "12");
			selectFromDropdown(CH_EmpProfileObjects.gender, gender, "text");
			CH_EmpProfileObjects.mblNumber.sendKeys(mblNum);
			CH_EmpProfileObjects.landNumber.sendKeys(landNum);
			CH_EmpProfileObjects.email.sendKeys(email + RandomStringUtils.randomAlphabetic(3) + "@gmail.com");
			selectFromDropdown(CH_EmpProfileObjects.positionCategory, pscategory, "text");
			selectFromDropdown(CH_EmpProfileObjects.payRollGroup, payRoll, "text");
			selectFromDropdown(CH_EmpProfileObjects.departMent, department, "text");
			selectFromDropdown(CH_EmpProfileObjects.subDepartment, subDept, "text");
			selectFromDropdown(CH_EmpProfileObjects.costCenter, costCent, "text");
			selectFromDropdown(CH_EmpProfileObjects.businessUnit, bussinessUnit, "text");
			selectFromDropdown(CH_EmpProfileObjects.jobLevel, jobLevel, "text");
			selectFromDropdown(CH_EmpProfileObjects.positionTitle, postionTitle, "text");
			CH_EmpProfileObjects.dateOfHire.click();
			dateSelection("6", "2020", "23");
			selectFromDropdown(CH_EmpProfileObjects.lineManager, lineManger, "value");
			selectFromDropdown(CH_EmpProfileObjects.departmentHead, depHead, "value");
			CH_EmpProfileObjects.chooseImage.sendKeys(imagepath);
		} catch (Exception e) {
			selectFromDropdown(CH_EmpProfileObjects.jobLevel, jobLevel, "text");
			selectFromDropdown(CH_EmpProfileObjects.positionTitle, postionTitle, "text");
			Thread.sleep(1000);
			CH_EmpProfileObjects.dateOfHire.click();
			Thread.sleep(1000);
			dateSelection("6", "2020", "23");
			selectFromDropdown(CH_EmpProfileObjects.lineManager, lineManger, "value");
			selectFromDropdown(CH_EmpProfileObjects.departmentHead, depHead, "value");
			CH_EmpProfileObjects.chooseImage.sendKeys(imagepath);
		}
		addOrUpdateButton();
	}

	@Test(priority = 3, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void editEmployees() throws InterruptedException {
		javascriptExecutorBorder(CH_EmpProfileObjects.noOfemployees);
		javascriptExecutorBorder(CH_EmpProfileObjects.lastEmployee);
		Thread.sleep(1100);
		generateAlert("Testing the Horziontal Section Link");
		CH_EmpProfileObjects.horizontalMenu.forEach(horizontalMenu -> {
			if (horizontalMenu.isEnabled()) {
				try {
					javascriptExecutorBorder(horizontalMenu);
					horizontalMenu.click();
				} catch (Exception e) {
					javascriptExecutorBorder(horizontalMenu);
					horizontalMenu.click();
				}
			}
		});
		CH_EmpProfileObjects.empProfile.click();
		generateAlert("Testing the Asending<--->Descending Table Format");
		for (int i = 0; i < 5; i++) {
			javascriptExecutorBorder(CH_EmpProfileObjects.asendingDesending.get(i));
			CH_EmpProfileObjects.asendingDesending.get(i).click();
			Thread.sleep(1000);
			CH_EmpProfileObjects.asendingDesending.get(i).click();
		}
		generateAlert("Testing the Show Options:-->10-25-50-100");
		select = new Select(CH_EmpProfileObjects.noOfTableShow);
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				select.selectByValue("10");
			} else if (i == 1) {
				select.selectByValue("25");
			} else if (i == 2) {
				select.selectByValue("50");
			} else if (i == 3) {
				Thread.sleep(500);
				select.selectByValue("100");
			}
		}
		generateAlert("Testing the last employee in the table: Scroll Down");
		javascriptExecuorScrollDown(getDriver());
		Thread.sleep(1000);
		CH_EmpProfileObjects.empProfile.click();
		generateAlert("Testing the all check box option: Employee Profile");
		for (int i = 0; i < 4; i++) {
			Thread.sleep(1000);
			if (i == 0) {
				javascriptExecutorBorder(CH_EmpProfileObjects.listOfTablesCheckBox);
			}
			try {
				CH_EmpProfileObjects.listOfTablesCheckBox.click();
			} catch (Exception e) {
				CH_EmpProfileObjects.listOfTablesCheckBox.click();
			}

		}
		generateAlert("Testing the search box : Employee Details");
		for (int i = 0; i <= 2; i++) {
			try {
				if (i == 0) {
					CH_EmpProfileObjects.searchElement.sendKeys(properties.getProperty("search1"));
					javascriptExecutorBorder(CH_EmpProfileObjects.searchDropDownList);
					Thread.sleep(1000);
					CH_EmpProfileObjects.searchElement.clear();
				} else if (i == 1) {
					CH_EmpProfileObjects.searchElement.sendKeys(properties.getProperty("search2"));
					javascriptExecutorBorder(CH_EmpProfileObjects.searchDropDownList);
					Thread.sleep(1000);
					CH_EmpProfileObjects.searchElement.clear();
				} else {
					CH_EmpProfileObjects.searchElement.sendKeys(properties.getProperty("search3"));
					javascriptExecutorBorder(CH_EmpProfileObjects.searchDropDownList);
					Thread.sleep(1000);
					CH_EmpProfileObjects.searchElement.clear();
				}
			} catch (Exception e) {
				if (i == 0) {
					CH_EmpProfileObjects.searchElement.sendKeys(properties.getProperty("search1"));
					javascriptExecutorBorder(CH_EmpProfileObjects.searchDropDownList);
					Thread.sleep(1000);
					CH_EmpProfileObjects.searchElement.clear();
				} else if (i == 1) {
					CH_EmpProfileObjects.searchElement.sendKeys(properties.getProperty("search2"));
					javascriptExecutorBorder(CH_EmpProfileObjects.searchDropDownList);
					Thread.sleep(1000);
					CH_EmpProfileObjects.searchElement.clear();
				} else {
					CH_EmpProfileObjects.searchElement.sendKeys(properties.getProperty("search3"));
					javascriptExecutorBorder(CH_EmpProfileObjects.searchDropDownList);
					Thread.sleep(1000);
					CH_EmpProfileObjects.searchElement.clear();
				}
			}
		}
		try {
			CH_EmpProfileObjects.empProfile.click();
		} catch (Exception e) {
			CH_EmpProfileObjects.empProfile.click();
		}
		generateAlert("Testing the next buttons : Employee Details");
		javascriptExecuorScrollDown(getDriver());
		for (int i = 0; i < CH_EmpProfileObjects.nextButtons.size(); i++) {
			CH_EmpProfileObjects.nextButtons.get(i).click();
			Thread.sleep(500);
		}
		Thread.sleep(1500);
		try {
			CH_EmpProfileObjects.listOfTablesCheckBox.click();
		} catch (Exception e) {
			CH_EmpProfileObjects.listOfTablesCheckBox.click();
		}
		generateAlert("Testing the employee profile : Drop Downs");
		for (int i = 0; i < 1; i++) {
			Thread.sleep(1000);
			javascriptExecutorBorder(CH_EmpProfileObjects.empCode);
			selectFromDropdown(CH_EmpProfileObjects.payrollDropDown, properties.getProperty("payRoll"), "text");
			selectFromDropdown(CH_EmpProfileObjects.categoryDropdown, properties.getProperty("categoryDrop"), "text");
			selectFromDropdown(CH_EmpProfileObjects.departmentDropDown, properties.getProperty("departmentDrop"),
					"text");
			selectFromDropdown(CH_EmpProfileObjects.subDeptDropDown, properties.getProperty("subDeptDrop"), "text");
			selectFromDropdown(CH_EmpProfileObjects.positiontitleDropdown, properties.getProperty("positionTitle"),
					"text");
		}
		generateAlert("Sucessfully tested employee section!!");
	}

	@Test(priority = 4, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void listOfView() throws InterruptedException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.empProfile)).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.empProfile)).click();
		}
		generateAlert("Testing the employee profile option: <- VIEW ->");
		for (int i = 0; i < 1; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.listOfViewEmployee.get(i))).click();
			checklistView();
			try {
				wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.viewBack)).click();
			} catch (Exception e) {
				wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.viewBack)).click();
			}
		}
		generateAlert("Sucessfully tested: <- VIEW ->");
	}

	public void checklistView() throws InterruptedException {
		Thread.sleep(300);
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.password)).click();
		javascriptExecutorBorder(CH_EmpProfileObjects.passwordText);
		System.out.println(CH_EmpProfileObjects.passwordText.getText());
		Thread.sleep(400);
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.closepaswd)).click();
		Thread.sleep(300);
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.printView)).click();
		Thread.sleep(400);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		for (int i = 0; i < 130; i++) {
			js.executeScript("window.scrollBy(0," + i + ")", "");
		}
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		Thread.sleep(300);
		javascriptExecutorBorder(getDriver().findElement(By.xpath("//table[@id='formtable']//td[2]")));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.printViewBack)).click();

			Thread.sleep(1000);
		} catch (Exception e) {
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.printViewBack)).click();
		}
		javascriptExecutorBorder(CH_EmpProfileObjects.empCode);
	}

	@Test(priority = 5, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void updateDetails() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.empProfile)).click();
		generateAlert("Testing the Employee: ACTIVE <-> INACTIVE");
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.codeascDesec)).click();
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.tableFirstRow)).click();
		selectFromDropdown(CH_EmpProfileObjects.status, properties.getProperty("InactiveStatus"), "value");
		CH_EmpProfileObjects.updateBtn.click();
		Thread.sleep(1000);
		softAssert.assertEquals(toastMessage(), "Select Inactive reason");
		Thread.sleep(1000);
		selectFromDropdown(CH_EmpProfileObjects.inactiveReason, properties.getProperty("inactiveReason"), "value");
		CH_EmpProfileObjects.updateBtn.click();
		Thread.sleep(1500);
		softAssert.assertEquals(toastMessage(), "Data Successfully updated");
		selectFromDropdown(CH_EmpProfileObjects.status, properties.getProperty("activeStatus"), "value");
		CH_EmpProfileObjects.remarks.sendKeys(properties.getProperty("remarks"));
		Thread.sleep(1000);
		CH_EmpProfileObjects.updateBtn.click();
		Thread.sleep(1000);
		softAssert.assertEquals(toastMessage(), "Data Successfully updated");
		CH_EmpProfileObjects.email.clear();
		CH_EmpProfileObjects.updateBtn.click();
		Thread.sleep(1200);
		softAssert.assertEquals(toastMessage(), "Enter Email");
		CH_EmpProfileObjects.email.clear();
		CH_EmpProfileObjects.email.sendKeys("GeorgeDaivd@thienslc.in");
		Thread.sleep(1000);
		CH_EmpProfileObjects.updateBtn.click();
		Thread.sleep(1000);
		softAssert.assertEquals(toastMessage(), "Employee email id should be unique");
		Thread.sleep(1000);
		CH_EmpProfileObjects.email.clear();
		CH_EmpProfileObjects.email
				.sendKeys(properties.getProperty("uniqueEmail") + System.currentTimeMillis() + "@gmail.com");
		CH_EmpProfileObjects.updateBtn.click();
		Thread.sleep(1000);
		softAssert.assertEquals(toastMessage(), "Data Successfully updated");
		Thread.sleep(500);
		selectFromDropdown(CH_EmpProfileObjects.status, properties.getProperty("InactiveStatus"), "value");
		selectFromDropdown(CH_EmpProfileObjects.inactiveReason, properties.getProperty("inactiveReason"), "value");
		CH_EmpProfileObjects.updateBtn.click();
		Thread.sleep(1000);
		softAssert.assertEquals(toastMessage(), "Saved Successfully");
		Thread.sleep(2000);
		try {
			CH_EmpProfileObjects.backButton.click();
		} catch (Exception e) {
			CH_EmpProfileObjects.backButton.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.codeascDesec)).click();
		javascriptExecutorBorder(CH_EmpProfileObjects.statusTable);
		softAssert.assertEquals(CH_EmpProfileObjects.statusTable.getText(), "InActive");
		generateAlert("Sucessfully Tested: ACTIVE <-> INACTIVE");
	}

	@Test(priority = 6, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void editPersonalDetails() throws InterruptedException {
		coreHRMSClick();
		generateAlert("Testing the personal Info: Edit Employee Personal Info");
		Thread.sleep(2000);
		CH_EmpProfileObjects.noticePeriod.sendKeys(properties.getProperty("noticePeriod"));
		CH_EmpProfileObjects.noticePerioProb.clear();
		CH_EmpProfileObjects.noticePerioProb.sendKeys((properties.getProperty("noticePerioProb")));
		CH_EmpProfileObjects.hmo.sendKeys(properties.getProperty("hmo"));
		CH_EmpProfileObjects.hmoNo.sendKeys(properties.getProperty("hmoNo"));
		CH_EmpProfileObjects.dependency.sendKeys(properties.getProperty("dependency"));
		if (CH_EmpProfileObjects.passportNum.isEnabled()) {
			try {
				CH_EmpProfileObjects.passportNum.sendKeys(properties.getProperty("passportNum"));
			} catch (Exception e) {
				CH_EmpProfileObjects.passportNum.sendKeys(properties.getProperty("passportNum"));
			}
			if (CH_EmpProfileObjects.pssportdDteIssue.isEnabled()) {
				CH_EmpProfileObjects.pssportdDteIssue.click();
				dateSelection("3", "2011", "22");
				softAssert.assertTrue(true);
			}
			if (CH_EmpProfileObjects.pssportdExpiry.isEnabled()) {
				CH_EmpProfileObjects.pssportdExpiry.click();
				select = new Select(CH_EmpProfileObjects.year);
				select.selectByValue("2028");
				select = new Select(CH_EmpProfileObjects.month);
				select.selectByValue("3");
				getDriver().findElement(By.xpath("//*[text()='25']")).click();
				softAssert.assertTrue(true);
			}
		}
		select = new Select(CH_EmpProfileObjects.bloodGrp);
		Select select1 = new Select(CH_EmpProfileObjects.nationality);
		Select select2 = new Select(CH_EmpProfileObjects.birthPlace);
		Select select3 = new Select(CH_EmpProfileObjects.maritalSts);
		for (int i = 0; i < 5; i++) {
			Thread.sleep(600);
			select.selectByIndex(i);
			select1.selectByIndex(i);
			select2.selectByIndex(i);
			select3.selectByIndex(i);
		}
		if (CH_EmpProfileObjects.momMaiddName.isEnabled()) {
			CH_EmpProfileObjects.momMaiddName.sendKeys(properties.getProperty("momMaiddName"));
			softAssert.assertTrue(true);
		}
		if (CH_EmpProfileObjects.personalEmail.isEnabled()) {
			CH_EmpProfileObjects.personalEmail.sendKeys(properties.getProperty("personalEmail"));
			softAssert.assertTrue(true);
		}
		if (CH_EmpProfileObjects.personalMbl.isEnabled()) {
			CH_EmpProfileObjects.personalMbl.sendKeys(properties.getProperty("personalMbl"));
			softAssert.assertTrue(true);
		}
		selectFromDropdown(CH_EmpProfileObjects.maritalSts, properties.getProperty("maritialStatus"), "text");
		if (CH_EmpProfileObjects.anniversaryDate.isEnabled()) {
			CH_EmpProfileObjects.anniversaryDate.click();
			dateSelection("8", "2015", "12");
			softAssert.assertTrue(true);
		}
		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				if (CH_EmpProfileObjects.personalAllCheckBox.get(i).isEnabled()) {
					CH_EmpProfileObjects.personalAllCheckBox.get(i).click();
					CH_EmpProfileObjects.personalAllCheckBox.get(3).click();
					CH_EmpProfileObjects.personalAllCheckBox.get(4).click();
					softAssert.assertTrue(true);
				}
			}
			Thread.sleep(500);
			CH_EmpProfileObjects.personalAllCheckBox.get(i).click();
		}
		addOrUpdateButton();
		generateAlert("Sucessfully tested: Personal Information!!");
	}

	@Test(priority = 7, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void address() throws InterruptedException {
		try {
			coreHRMSClick();
		} catch (Exception e) {
			coreHRMSClick();
		}
		generateAlert("Testing the Address Field: Edit Address");
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.adressLink)).click();
		CH_EmpProfileObjects.address.sendKeys(properties.getProperty("address"));
//		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.countryAdd)).click();
//		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.countryText))
//				.sendKeys(properties.getProperty("countryAddText"));
//		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.countrySave)).click();
//		softAssert.assertEquals(toastMessage(), "Saved Successfully");
//		selectFromDropdown(null, url, textPage);
//		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.provinceAdd)).click();
//		Thread.sleep(500);
//		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.provinceText))
//				.sendKeys(properties.getProperty("proviceAddText"));
//		Thread.sleep(500);
//		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.provinceSave)).click();
//		softAssert.assertEquals(toastMessage(), "Saved Successfully");

		// country reselection
		selectFromDropdown(CH_EmpProfileObjects.countrySelect, properties.getProperty("countryName"), "text");
		selectFromDropdown(CH_EmpProfileObjects.province, properties.getProperty("provinceName"), "text");
		selectFromDropdown(CH_EmpProfileObjects.city, properties.getProperty("cityName"), "text");
		selectFromDropdown(CH_EmpProfileObjects.barangay, properties.getProperty("barangay"), "text");
		CH_EmpProfileObjects.landMark.sendKeys(properties.getProperty("landmark"));
		CH_EmpProfileObjects.presentSamePresent.click();
		addOrUpdateButton();
		generateAlert("Sucessfully tested: Address section!!");
	}

	@Test(priority = 8, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void bankDetails() throws InterruptedException {
		coreHRMSClick();
		generateAlert("Testing the Bank Section Field: Edit Bank");
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.bankSectionLink)).click();
		select = new Select(CH_EmpProfileObjects.paymentMethod);
		for (int i = 0; i < 4; i++) {
			Thread.sleep(1000);
			select.selectByIndex(i);
		}
		select.selectByVisibleText(properties.getProperty("paymentMethod"));
		if (CH_EmpProfileObjects.bankName.isEnabled()) {
			selectFromDropdown(CH_EmpProfileObjects.bankName, properties.getProperty("bankName"), "text");
			selectFromDropdown(CH_EmpProfileObjects.bankbranch, properties.getProperty("bankBranch"), "text");
			CH_EmpProfileObjects.accountNo.sendKeys(properties.getProperty("acntNo"));
			selectFromDropdown(CH_EmpProfileObjects.bankType, properties.getProperty("bankAcntType"), "text");
		}
		Thread.sleep(2000);
		CH_EmpProfileObjects.bankPercentage.clear();
		CH_EmpProfileObjects.bankPercentage.sendKeys("200");
		Thread.sleep(2000);
		softAssert.assertEquals(toastMessage(), "Percentage should be less than or equal 100");
		Thread.sleep(2000);
		CH_EmpProfileObjects.bankPercentage.clear();
		CH_EmpProfileObjects.bankPercentage.sendKeys(properties.getProperty("bankPercentage"));
		Thread.sleep(600);
		CH_EmpProfileObjects.bankCopyDetails.click();
		Thread.sleep(500);
		addOrUpdateButton();
		generateAlert("Sucessfully tested: Bank details section!!");
	}

	@Test(priority = 9, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void educationDetails() throws InterruptedException {
		coreHRMSClick();
		generateAlert("Testing the education section: Edit Education ");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.educationSecLink)).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.educationSecLink)).click();
		}

		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.deleteEducationInfo)).click();
				softAssert.assertEquals(toastMessage(), "One Row must Exist");
				wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.addEducationInfo)).click();
				softAssert.assertEquals(toastMessage(), "Select the Qualification");
				Thread.sleep(1500);
				selectFromDropdown(CH_EmpProfileObjects.qualification, properties.getProperty("qualification"), "text");
				selectFromDropdown(CH_EmpProfileObjects.degree, properties.getProperty("degree"), "text");
				selectFromDropdown(CH_EmpProfileObjects.course, properties.getProperty("course"), "index");
				CH_EmpProfileObjects.specialization.sendKeys(properties.getProperty("specialization"));
				CH_EmpProfileObjects.institute.sendKeys(properties.getProperty("institute"));
				wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.schoolFromYear)).click();
				dateSelection("5", "2014", "25");
				wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.schooFromlTo)).click();
				dateSelection("3", "2014", "25");
				softAssert.assertEquals(toastMessage(), "To year must be greater than From Year");
			}
			Thread.sleep(2000);
			if (i == 1) {
				wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.schooFromlTo)).click();
				dateSelection("6", "2016", "27");
				wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.passingYear)).click();
				dateSelection("5", "2020", "16");
			}
			if (i == 2) {
				wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.addEducationInfo)).click();
				selectFromDropdown(CH_EmpProfileObjects.qualification1, properties.getProperty("qualification"),
						"text");
				selectFromDropdown(CH_EmpProfileObjects.degree1, properties.getProperty("degree"), "text");
				selectFromDropdown(CH_EmpProfileObjects.course1, properties.getProperty("course"), "index");
				softAssert.assertEquals(toastMessage(), "Already Exist");
				Thread.sleep(2000);
				selectFromDropdown(CH_EmpProfileObjects.qualification1, properties.getProperty("qualification1"),
						"text");
				selectFromDropdown(CH_EmpProfileObjects.degree1, properties.getProperty("degree1"), "text");
				selectFromDropdown(CH_EmpProfileObjects.course1, properties.getProperty("course1"), "text");
				try {
					CH_EmpProfileObjects.specialization1.sendKeys(properties.getProperty("specialization1"));
					CH_EmpProfileObjects.institute1.sendKeys(properties.getProperty("institute1"));
				} catch (Exception e) {
					CH_EmpProfileObjects.specialization1.sendKeys(properties.getProperty("specialization1"));
					CH_EmpProfileObjects.institute1.sendKeys(properties.getProperty("institute1"));
				}

				wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.schoolFromYear1)).click();
				dateSelection("5", "2016", "25");
				wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.schooFromlTo1)).click();
				dateSelection("6", "2018", "27");
				wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.passingYear1)).click();
				dateSelection("7", "2018", "20");
			}
		}
		addOrUpdateButton();
		generateAlert("Sucessfully tested: Education section!!");
	}

	@Test(priority = 10, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void experienceSection() throws InterruptedException {
		coreHRMSClick();
		generateAlert("Testing the experience section: Edit Experience ");
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.experienceSecLink)).click();
		CH_EmpProfileObjects.deleteExperienceInfo.click();
		softAssert.assertEquals(toastMessage(), "One Row must Exist");
		CH_EmpProfileObjects.addExperienceInfo.click();
		softAssert.assertEquals(toastMessage(), "Enter Previous Company Name");
		Thread.sleep(2000);
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				CH_EmpProfileObjects.company.sendKeys(properties.getProperty("company"));
				CH_EmpProfileObjects.industry.sendKeys(properties.getProperty("industry"));
				CH_EmpProfileObjects.strtDesigantion.sendKeys(properties.getProperty("strtDesigantion"));
				CH_EmpProfileObjects.strtSalary.sendKeys(properties.getProperty("strtSalary"));
				CH_EmpProfileObjects.experienceStartFrom.click();
				dateSelection("8", "2019", "13");
				CH_EmpProfileObjects.experienceToDate.click();
				dateSelection("3", "2020", "12");
				CH_EmpProfileObjects.immidiateSup.sendKeys(properties.getProperty("immidiateSup"));
				CH_EmpProfileObjects.contactNumber.sendKeys(properties.getProperty("contactNumber"));
				CH_EmpProfileObjects.endDesigination.sendKeys(properties.getProperty("endDesigination"));
				CH_EmpProfileObjects.endSalary.sendKeys(properties.getProperty("endSalary"));
				CH_EmpProfileObjects.companyAddress.sendKeys(properties.getProperty("companyAddress"));
			} else if (i == 1) {
				if (CH_EmpProfileObjects.company.getText() != null) {
					CH_EmpProfileObjects.addExperienceInfo.click();
					CH_EmpProfileObjects.company1.sendKeys(properties.getProperty("company1"));
					CH_EmpProfileObjects.industry1.sendKeys(properties.getProperty("industry1"));
					CH_EmpProfileObjects.strtDesigantion1.sendKeys(properties.getProperty("strtDesigantion1"));
					CH_EmpProfileObjects.strtSalary1.sendKeys(properties.getProperty("strtSalary1"));
					CH_EmpProfileObjects.experienceStartFrom1.click();
					dateSelection("2", "2015", "18");
					CH_EmpProfileObjects.experienceToDate1.click();
					dateSelection("6", "2020", "11");
					CH_EmpProfileObjects.immidiateSup1.sendKeys(properties.getProperty("immidiateSup1"));
					CH_EmpProfileObjects.contactNumber1.sendKeys(properties.getProperty("contactNumber1"));
					CH_EmpProfileObjects.endDesigination1.sendKeys(properties.getProperty("endDesigination1"));
					CH_EmpProfileObjects.endSalary1.sendKeys(properties.getProperty("endSalary1"));
					CH_EmpProfileObjects.companyAddress1.sendKeys(properties.getProperty("companyAddress1"));
				}
			}
		}
		Thread.sleep(1000);
		addOrUpdateButton();
		generateAlert("Sucessfully tested: Experience section!!");
	}

	@Test(priority = 11, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void documentUpload() throws InterruptedException {
		coreHRMSClick();
		generateAlert("Testing the document section: Upload Document ->(More than 1 MB)->jpeg,jpg,png");
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.documentSecLink)).click();
		if (CH_EmpProfileObjects.selectDocument.getText() == "Select Document") {
			CH_EmpProfileObjects.firstAddPersonalInfo.click();
			Thread.sleep(1000);
			softAssert.assertEquals(toastMessage(), "Select Document Name");
		}
		int j = 1;
		for (int i = 0; i < 2; i++) {
			select = new Select(CH_EmpProfileObjects.selectDocument);
			if (i == 0) {
				select.selectByIndex(i);
				CH_EmpProfileObjects.firstAddPersonalInfo.click();
				softAssert.assertEquals(toastMessage(), "Select Document Name");
				Thread.sleep(1500);
				select.selectByIndex(j);
				CH_EmpProfileObjects.firstAddPersonalInfo.click();
				softAssert.assertEquals(toastMessage(), "Select image");
				Thread.sleep(1500);
				select.selectByIndex(j);
				CH_EmpProfileObjects.chooseFile.sendKeys(
						"C:\\Users\\hariprasath\\eclipse-workspace\\AdminPerk\\src\\test\\resources\\pexels-pixabay-235986.jpg");
				Thread.sleep(1700);
				softAssert.assertEquals(toastMessage(), "Please Upload File That Has Size Less Than 1Mb");
			} else if (i == 1) {
				try {
					Thread.sleep(1000);
					select.selectByIndex(i);
					CH_EmpProfileObjects.chooseFile.sendKeys(
							"C:\\Users\\hariprasath\\eclipse-workspace\\AdminPerk\\src\\test\\resources\\UgCertificate.jpg");
					CH_EmpProfileObjects.firstAddPersonalInfo.click();
					Thread.sleep(1000);
					softAssert.assertEquals(toastMessage(), "Saved Successfully");
				} catch (Exception e) {
					select.selectByIndex(i);
					CH_EmpProfileObjects.chooseFile.sendKeys(
							"C:\\Users\\hariprasath\\eclipse-workspace\\AdminPerk\\src\\test\\resources\\Pg certificate.jpg");
					CH_EmpProfileObjects.firstAddPersonalInfo.click();
					Thread.sleep(1000);
					softAssert.assertEquals(toastMessage(), "Saved Successfully");
				}
			}
		}
		generateAlert("Testing the download Butons");
		for (int i = 0; i < CH_EmpProfileObjects.downloadImgBtn.size(); i++) {
			try {
				CH_EmpProfileObjects.downloadImgBtn.get(i).click();
			} catch (Exception e) {
				CH_EmpProfileObjects.downloadImgBtn.get(i).click();
			}
		}
		generateAlert("Testing the delete Butons");
		for (int i = 0; i < CH_EmpProfileObjects.deleteImgBtn.size(); i++) {
			try {
				CH_EmpProfileObjects.deleteImgBtn.get(i).click();
				Thread.sleep(2000);
				CH_EmpProfileObjects.deleteNo.click();
				CH_EmpProfileObjects.deleteImgBtn.get(i).click();
				Thread.sleep(2000);
				CH_EmpProfileObjects.deleteYes.click();
			} catch (Exception e) {
				Thread.sleep(2000);
				CH_EmpProfileObjects.deleteYes.click();
			}
		}
		Thread.sleep(1000);
		softAssert.assertEquals(toastMessage(), "Data Successfully deleted");
		Thread.sleep(2000);
		generateAlert("Again adding Image");
		select.selectByIndex(1);
		CH_EmpProfileObjects.chooseFile.sendKeys(
				"C:\\Users\\hariprasath\\eclipse-workspace\\AdminPerk\\src\\test\\resources\\UgCertificate.jpg");
		CH_EmpProfileObjects.firstAddPersonalInfo.click();
		Thread.sleep(1000);
		softAssert.assertEquals(toastMessage(), "Saved Successfully");
		generateAlert("Upload Document section Succesfully Tested!!");
	}

	@Test(priority = 12, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void familyDetailsInfo() throws InterruptedException {
		coreHRMSClick();
		generateAlert("Testing the family details section: Edit Family");
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.familySecLink)).click();
		CH_EmpProfileObjects.famName.sendKeys(properties.getProperty("famName"));
		selectFromDropdown(CH_EmpProfileObjects.famRelationship, "Father", "text");
		CH_EmpProfileObjects.famContactNo.sendKeys(properties.getProperty("famContactNo"));
		CH_EmpProfileObjects.famEmergencyContact.click();
		CH_EmpProfileObjects.famDob.click();
		dateSelection("8", "1985", "21");
		CH_EmpProfileObjects.famAddress.sendKeys(properties.getProperty("famAddress"));
		CH_EmpProfileObjects.famHmoDependent.click();
		CH_EmpProfileObjects.famHmoNumber.sendKeys(properties.getProperty("famHmoNumber"));
		CH_EmpProfileObjects.famChooseImage
				.sendKeys("C:\\Users\\hariprasath\\eclipse-workspace\\AdminPerk\\src\\test\\resources\\profile2.jpg");
		addOrUpdateButton();
		generateAlert("Family details section sucessfully tested!!");
	}

	@Test(priority = 13, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void statutoryDeatils() throws InterruptedException {
		coreHRMSClick();
		generateAlert("Testing the statutory deatials section: Edit Statutory");
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.statutrySecLink)).click();
		selectFromDropdown(CH_EmpProfileObjects.payType, properties.getProperty("payType"), "text");
		for (int i = 0; i < 1; i++) {
			CH_EmpProfileObjects.minimumWageEarnerNYes.click();
			CH_EmpProfileObjects.regionStatutory.sendKeys(properties.getProperty("regionStatutory"));
			CH_EmpProfileObjects.deductWithoutHoldYes.click();
			selectFromDropdown(CH_EmpProfileObjects.whtCycleStatutory, properties.getProperty("whtCycleStatutory"),
					"text");
			CH_EmpProfileObjects.recurringStatutory.click();
			CH_EmpProfileObjects.taxIdentyNo.sendKeys(properties.getProperty("taxIdentyNo"));
			CH_EmpProfileObjects.taxClassification.sendKeys(properties.getProperty("taxClassification"));
			CH_EmpProfileObjects.expandTax.sendKeys("222");
			Thread.sleep(1000);
			softAssert.assertEquals(toastMessage(), "Percentage should be less than 100");
			CH_EmpProfileObjects.expandTax.sendKeys(properties.getProperty("expandTax"));
			CH_EmpProfileObjects.deductSSYes.click();
			selectFromDropdown(CH_EmpProfileObjects.sssCycle, properties.getProperty("sssCycle"), "text");
			CH_EmpProfileObjects.recurring1Statutory.click();
			CH_EmpProfileObjects.empPayEasyYes.click();
			CH_EmpProfileObjects.sclSecurityNo.sendKeys(properties.getProperty("sclSecurityNo"));
			CH_EmpProfileObjects.deductPhilHealthYes.click();
			selectFromDropdown(CH_EmpProfileObjects.philhealthCycle, properties.getProperty("philhealthCycle"), "text");
			CH_EmpProfileObjects.recurring2Statutory.click();
			CH_EmpProfileObjects.philHelathNum.sendKeys(properties.getProperty("philHelathNum"));
			CH_EmpProfileObjects.deductvoulntaryBigYes.click();
			CH_EmpProfileObjects.philHelathMaxAmnt.sendKeys(properties.getProperty("philHelathMaxAmnt"));
			CH_EmpProfileObjects.DEDUCTPAGbagPigYes.click();
			selectFromDropdown(CH_EmpProfileObjects.pagIbigCycle, properties.getProperty("pagIbigCycle"), "text");
			CH_EmpProfileObjects.recurring3Statutory.click();
			CH_EmpProfileObjects.pagIBIGNo.sendKeys(properties.getProperty("pagIBIGNo"));
			CH_EmpProfileObjects.voluntibigYes.click();
			CH_EmpProfileObjects.pagIBIGAmmnt.sendKeys(properties.getProperty("pagIBIGAmmnt"));
			CH_EmpProfileObjects.TackHomePay.sendKeys(properties.getProperty("TackHomePay"));
			CH_EmpProfileObjects.dayRate.sendKeys(properties.getProperty("dayRate"));
			CH_EmpProfileObjects.MonthPayYes.click();
			addOrUpdateButton();
			generateAlert("Statutory sucessfully tested!!");
		}
	}

//	public void StatutoryNo() throws InterruptedException {
//		int j = 0;
//		if (j == 0) {
//			System.out.println("hi");
//			Thread.sleep(1000);
//			CH_EmpProfileObjects.minimumWageEarnerNo.click();
//			CH_EmpProfileObjects.deductWithoutHoldNo.click();
//			CH_EmpProfileObjects.deductSSNo.click();
//			CH_EmpProfileObjects.empPayEasyNo.click();
//			CH_EmpProfileObjects.deductPhilHealthNo.click();
//			CH_EmpProfileObjects.deductvoulntaryBigNo.click();
//			CH_EmpProfileObjects.DEDUCTPAGbagPigNo.click();
//			CH_EmpProfileObjects.voluntibigNo.click();
//			CH_EmpProfileObjects.MonthPayNo.click();
//		}
//		j = j + 1;
//	}

	@Test(priority = 13, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void attendanceDetails() throws InterruptedException {
		coreHRMSClick();
		generateAlert("Testing the attendance section: Edit Attendance");
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.attendancSecLink)).click();
		for (int i = 0; i < 7; i++) {
			Thread.sleep(600);
			try {
				CH_EmpProfileObjects.restDaysCheckBox.get(i).click();
			} catch (Exception e) {
				CH_EmpProfileObjects.restDaysCheckBox.get(i).click();
			}
		}
		CH_EmpProfileObjects.noOfWorkingMonth.sendKeys(properties.getProperty("noOfWorkingMonth"));
		selectFromDropdown(CH_EmpProfileObjects.excessHour, "1", "index");
		CH_EmpProfileObjects.biometricNo.sendKeys(properties.getProperty("biometricNo"));
		selectFromDropdown(CH_EmpProfileObjects.attendancePolicy, "4", "index");
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.policyEffectDate)).click();
		dateSelection("7", "2021", "12");
		selectFromDropdown(CH_EmpProfileObjects.shiftName, "10", "index");
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.shiftEffectDate)).click();
		dateSelection("3", "2021", "22");
		for (int i = 0; i < 5; i++) {
			Thread.sleep(500);
			try {
				CH_EmpProfileObjects.defaultAttendance.get(i).click();
			} catch (Exception e) {
				CH_EmpProfileObjects.defaultAttendance.get(i).click();
			}
		}
		selectFromDropdown(CH_EmpProfileObjects.logPrioritization, "2", "index");
		for (int i = 0; i < 6; i++) {
			Thread.sleep(20);
			CH_EmpProfileObjects.attendanceMobile.get(i).click();
		}
		addOrUpdateButton();
		generateAlert("Statutory sucessfully tested!!");
	}

	@Test(priority = 14, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void trainningDetails() throws InterruptedException {
		coreHRMSClick();
		generateAlert("Testing the trainning section: Edit Trainning");
		// Date section
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.trainingSecLink)).click();
		CH_EmpProfileObjects.trainningTitle.sendKeys(properties.getProperty("trainningTitle"));
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.courseStartingDate)).click();
		dateSelection("2", "1996", "17");
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.courseEndingDate)).click();
		dateSelection("9", "2013", "14");
		CH_EmpProfileObjects.trainningCost.sendKeys(properties.getProperty("trainningCost"));
		CH_EmpProfileObjects.certificateChoseImg.sendKeys(
				"C:\\Users\\hariprasath\\eclipse-workspace\\AdminPerk\\src\\test\\resources\\UgCertificate.jpg");
		CH_EmpProfileObjects.remarksTrainning.sendKeys(properties.getProperty("remarksTrainning"));
		addOrUpdateButton();
		generateAlert("Statutory sucessfully tested!!");
	}

	@Test(priority = 15, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void approvalSection() throws InterruptedException {
		// note:- Update button separate id to work xpath not working
		// tooltip data change modify to run
		coreHRMSClick();
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.approvalSecLink)).click();
		for (int i = 0; i < 9; i++) {
			for (int j = 1; j <= 1; j++) {
				if (i == 0) {
					try {
						System.out.println("hi");
						approverField(CH_EmpProfileObjects.leaveAbsenceAdd, CH_EmpProfileObjects.approver1);

					} catch (Exception e) {
						approverField(CH_EmpProfileObjects.leaveAbsenceAdd, CH_EmpProfileObjects.approver1);
					}
				} else if (i == 1) {
					try {
						approverField(CH_EmpProfileObjects.failureTimeAdd, CH_EmpProfileObjects.TimeApprover);
					} catch (Exception e) {
						approverField(CH_EmpProfileObjects.failureTimeAdd, CH_EmpProfileObjects.TimeApprover);
					}
				} else if (i == 2) {
					try {
						approverField(CH_EmpProfileObjects.officialBussiAdd,
								CH_EmpProfileObjects.officialBusinessTripApprover);
					} catch (Exception e) {
						approverField(CH_EmpProfileObjects.officialBussiAdd,
								CH_EmpProfileObjects.officialBusinessTripApprover);
					}
				} else if (i == 3) {
					try {
						approverField(CH_EmpProfileObjects.overTimeAdd, CH_EmpProfileObjects.ovrtimeApprover);
					} catch (Exception e) {
						approverField(CH_EmpProfileObjects.overTimeAdd, CH_EmpProfileObjects.ovrtimeApprover);
					}
				} else if (i == 4) {
					try {
						approverField(CH_EmpProfileObjects.restDatAdd, CH_EmpProfileObjects.restdayApprover);
					} catch (Exception e) {
						approverField(CH_EmpProfileObjects.restDatAdd, CH_EmpProfileObjects.restdayApprover);
					}
				} else if (i == 5) {
					try {
						approverField(CH_EmpProfileObjects.shiftCodeAdd, CH_EmpProfileObjects.shifyCodeApprover);
					} catch (Exception e) {
						approverField(CH_EmpProfileObjects.shiftCodeAdd, CH_EmpProfileObjects.shifyCodeApprover);
					}
				} else if (i == 6) {
					try {
						approverField(CH_EmpProfileObjects.toilAdd, CH_EmpProfileObjects.toilApprover);
					} catch (Exception e) {
						approverField(CH_EmpProfileObjects.toilAdd, CH_EmpProfileObjects.toilApprover);
					}
				} else if (i == 7) {
					try {
						approverField(CH_EmpProfileObjects.loanAdd, CH_EmpProfileObjects.loanApprover);
					} catch (Exception e) {
						approverField(CH_EmpProfileObjects.loanAdd, CH_EmpProfileObjects.loanApprover);
					}
				} else if (i == 8) {
					try {
						approverField(CH_EmpProfileObjects.resiginationAdd, CH_EmpProfileObjects.resigApprover);
					} catch (Exception e) {
						approverField(CH_EmpProfileObjects.resiginationAdd, CH_EmpProfileObjects.resigApprover);
					}
				} else {
					System.out.println("xpath probelm");
				}
				String hrRepEmployeeCode = getDriver().findElement(By.xpath("(//ul)[7]//following::li[" + j + "]"))
						.getText();
				// tooltipEmployee
				WebElement listEmployee = getDriver().findElement(By.xpath("(//ul)[7]//following::li[" + j + "]"));
				listEmployee.click();
				// -------------------------->
				if (i == 0) {
					hrRep(CH_EmpProfileObjects.leaveHrRep, hrRepEmployeeCode);
					wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.updateApproval1)).click();
					softAssert.assertEquals(toastMessage(), "Data updated Successfully");
				} else if (i == 1) {
					hrRep(CH_EmpProfileObjects.TimeApproverHrRep, hrRepEmployeeCode);
					wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.updateApproval2)).click();
					softAssert.assertEquals(toastMessage(), "Data updated Successfully");
				} else if (i == 2) {
					hrRep(CH_EmpProfileObjects.officialBusinessTripHrRep, hrRepEmployeeCode);
					wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.updateApproval3)).click();
					softAssert.assertEquals(toastMessage(), "Data updated Successfully");
				} else if (i == 3) {
					hrRep(CH_EmpProfileObjects.overtimeHrRep, hrRepEmployeeCode);
					wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.updateApproval4)).click();
					softAssert.assertEquals(toastMessage(), "Data updated Successfully");
				} else if (i == 4) {
					hrRep(CH_EmpProfileObjects.restdayHrRep, hrRepEmployeeCode);
					wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.updateApproval5)).click();
					softAssert.assertEquals(toastMessage(), "Data updated Successfully");
				} else if (i == 5) {
					hrRep(CH_EmpProfileObjects.shifyCodeHrRep, hrRepEmployeeCode);
					wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.updateApproval6)).click();
					softAssert.assertEquals(toastMessage(), "Data updated Successfully");
				} else if (i == 6) {
					hrRep(CH_EmpProfileObjects.toilHrRep, hrRepEmployeeCode);
					wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.updateApproval7)).click();
					softAssert.assertEquals(toastMessage(), "Data updated Successfully");
				} else if (i == 7) {
					hrRep(CH_EmpProfileObjects.loanHrRep, hrRepEmployeeCode);
					wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.updateApproval8)).click();
					softAssert.assertEquals(toastMessage(), "Data updated Successfully");
				} else if (i == 8) {
					hrRep(CH_EmpProfileObjects.resigHrRep, hrRepEmployeeCode);
					wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.updateApproval9)).click();
					softAssert.assertEquals(toastMessage(), "Data updated Successfully");
				} else {
					System.out.println("xpath probelm");
				}
			}
		}
	}

	public void approverField(WebElement add, WebElement approver) throws InterruptedException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.approvalSecLink)).click();
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(add)).click();
			wait.until(ExpectedConditions.elementToBeClickable(approver)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(approver)).sendKeys("1");
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(approver)).sendKeys("0");
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.approvalSecLink)).click();
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(add)).click();
			wait.until(ExpectedConditions.elementToBeClickable(approver)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(approver)).sendKeys("1");
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(approver)).sendKeys("0");
		}
	}

	public void hrRep(WebElement hrRep, String hrRepEmployeeCode) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(hrRep)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(hrRep)).sendKeys(hrRepEmployeeCode);
		wait.until(ExpectedConditions.elementToBeClickable(hrRep)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(hrRep)).sendKeys(hrRepEmployeeCode);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.hrRepEmployeeToolTip)).click();
	}

	@Test(priority = 16, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void assets() throws InterruptedException {
		coreHRMSClick();
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.assetsLinks)).click();
		generateAlert("Testing the Assets section: Update Assets");
		int size = CH_EmpProfileObjects.checkBoxAssets.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.checkBoxAssets.get(i))).click();
		}
		CH_EmpProfileObjects.bluetooth.sendKeys(properties.getProperty("bluetooth"));
		CH_EmpProfileObjects.bluetoothDate.click();
		dateSelection("3", "2011", "17");
		CH_EmpProfileObjects.deskTop.sendKeys(properties.getProperty("deskTop"));
		CH_EmpProfileObjects.desktopDate.click();
		dateSelection("4", "2012", "13");
		CH_EmpProfileObjects.identyCard.sendKeys(properties.getProperty("identyCard"));
		CH_EmpProfileObjects.idenrtCardDate.click();
		dateSelection("5", "2013", "14");
		CH_EmpProfileObjects.laptop.sendKeys(properties.getProperty("laptop"));
		CH_EmpProfileObjects.laptopDate.click();
		dateSelection("8", "2021", "23");
		CH_EmpProfileObjects.ram8GB.sendKeys(properties.getProperty("ram8GB"));
		CH_EmpProfileObjects.ram8GBDate.click();
		dateSelection("6", "2014", "15");
		CH_EmpProfileObjects.test.sendKeys(properties.getProperty("test"));
		CH_EmpProfileObjects.testDate.click();
		dateSelection("7", "2015", "16");
		CH_EmpProfileObjects.wirelessMouse.sendKeys(properties.getProperty("wirelessMouse"));
		CH_EmpProfileObjects.wirelessMouseDate.click();
		dateSelection("8", "2020", "17");
		try {
			CH_EmpProfileObjects.assetsUpdate.click();
			Thread.sleep(1000);
			softAssert.assertEquals(toastMessage(), "Saved Successfully");
		} catch (Exception e) {
			CH_EmpProfileObjects.assetsUpdate.click();
			Thread.sleep(1000);
			softAssert.assertEquals(toastMessage(), "Saved Successfully");
		}
		generateAlert("Assets sucessfully tested!!");
	}

	@Test(priority = 17, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void othersSection() throws InterruptedException {
		coreHRMSClick();
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.othersSecLink)).click();
		generateAlert("Testing the Assets section: Update Assets");
		selectFromDropdown(CH_EmpProfileObjects.domicile, "1", "index");
		selectFromDropdown(CH_EmpProfileObjects.workLocationOthers, "1", "index");
		selectFromDropdown(CH_EmpProfileObjects.empType, "1", "index");
		selectFromDropdown(CH_EmpProfileObjects.mktDesignation, "1", "index");
		CH_EmpProfileObjects.sourceOfHire.sendKeys(properties.getProperty("sourceOfHire"));
		CH_EmpProfileObjects.seatingLocation.sendKeys(properties.getProperty("seatingLocation"));
		CH_EmpProfileObjects.deskExtension.sendKeys(properties.getProperty("deskExtension"));
		Thread.sleep(500);
		CH_EmpProfileObjects.remarks1.sendKeys(properties.getProperty("remarks1"));
		wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.applicalibilityYes)).click();
		CH_EmpProfileObjects.probMonth.sendKeys(properties.getProperty("probMonth"));
		CH_EmpProfileObjects.probDays.sendKeys(properties.getProperty("probDays"));
		addOrUpdateButton();
		generateAlert("Others section sucessfully tested!!");
	}

	public void addOrUpdateButton() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.firstAddPersonalInfo)).click();
			softAssert.assertEquals(toastMessage(), "Saved Successfully");
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.updateBtn)).click();
			softAssert.assertEquals(toastMessage(), "Saved Successfully");
		}
	}

	public void selectFromDropdown(WebElement element, String textorValueorIndex, String strategy) {
		select = new Select(element);
		if (strategy.equalsIgnoreCase("text")) {
			select.selectByVisibleText(textorValueorIndex);
		} else if (strategy.equalsIgnoreCase("value")) {
			select.selectByValue(textorValueorIndex);
		} else if (strategy.equalsIgnoreCase("index")) {
			select.selectByIndex(Integer.parseInt(textorValueorIndex));
		} else {
			System.out.println("Invalid startegy");
		}
	}

	public void dateSelection(String months, String years, String dates) {
		select = new Select(CH_EmpProfileObjects.month);
		select.selectByValue(months);
		select = new Select(CH_EmpProfileObjects.year);
		select.selectByValue(years);
		getDriver().findElement(By.xpath("//*[text()='" + dates + "']")).click();
	}

	public void coreHRMSClick() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.empProfile)).click();
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.codeascDesec)).click();
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.tableSecondRow)).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.empProfile)).click();
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.codeascDesec)).click();
			wait.until(ExpectedConditions.elementToBeClickable(CH_EmpProfileObjects.tableSecondRow)).click();
		}
	}
}
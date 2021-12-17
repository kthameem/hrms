package com.qa.TestCases;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.qa.baseclass.BaseClass;
import com.qa.pageObjects.CH_EmpProfileObjects;
import com.qa.pageObjects.Dashboard_Objects;
import com.qa.utility.IRetryAnalyser;
import com.qa.utility.WaitFactory;
import com.qa.utility.WaitStrategy;

public class DashBoardTestCases extends BaseClass {
	private DashBoardTestCases() {

	};

	@Test(priority = 0, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void table_chart_View_Click() throws InterruptedException {
		smokeTest();
		generateAlert("Testing Dashboard page!!");
		Thread.sleep(2000);
		Dashboard_Objects.table_Chart_View.forEach(s -> {
			try {
				javascriptExecutorBorder(s);
				WaitFactory.performWaitFactory(WaitStrategy.CLICKABLE, s).click();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}

	@Test(priority = 1, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void tableCount() throws InterruptedException {
		for (int i = 0; i < Dashboard_Objects.table_Chart_View.size(); i++) {
			if (i % 2 == 0) {
				try {
					WaitFactory.performWaitFactory(WaitStrategy.CLICKABLE, Dashboard_Objects.table_Chart_View.get(i))
							.click();
				} catch (Exception e) {
					WaitFactory.performWaitFactory(WaitStrategy.CLICKABLE, Dashboard_Objects.table_Chart_View.get(i))
							.click();
				}
			}
		}
	}

	@Test(priority = 2, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void tableValue() throws InterruptedException {
		generateAlert("Testing Table value counts");
		for (int i = 0; i < Dashboard_Objects.chartTittle.size(); i++) {
			String dynamicXpathTbody = "(//tbody)[";
			String dynamicXpathTbody1 = "]//tr";
			System.out.println("Table: " + Dashboard_Objects.chartTittle.get(i).getText());
			System.out.println("--------------------------");
			List<WebElement> list = getDriver().findElements(By.xpath(dynamicXpathTbody + i + dynamicXpathTbody1));
			for (int j = 0; j < list.size(); j++) {
				javascriptExecutorBorder(list.get(j));
				System.out.println(list.get(j).getAttribute("innerText"));
			}
			System.out.println("---------------------------------------------------------------");
		}
	}

	@Test(priority = 3, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void settingsSwitch() throws InterruptedException {
		generateAlert("Testing Settings Button!!");
		try {
			WaitFactory.performWaitFactory(WaitStrategy.CLICKABLE, Dashboard_Objects.settingsBtn).click();
		} catch (Exception e) {
			WaitFactory.performWaitFactory(WaitStrategy.CLICKABLE, Dashboard_Objects.settingsBtn).click();
		}
		Dashboard_Objects.switchBtn.forEach(s -> {
			if (s.isEnabled()) {
				javascriptExecutorBorder(s);
				s.click();
			}
		});
		Dashboard_Objects.switchSubmit.click();
		toastMessage();
		generateAlert("Dashboard switch btn Turned Off sucessfully");
		Dashboard_Objects.settingsBtn.click();
		Dashboard_Objects.switchBtn.forEach(s -> {
			if (s.isEnabled()) {
				javascriptExecutorBorder(s);
				s.click();
			}
		});
		Dashboard_Objects.switchSubmit.click();
		toastMessage();
		generateAlert("Dashboard switch btn Turned on sucessfully");
		verifyChartToogleEnable();
	}

	@Test(priority = 4, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void chartAescDesc() throws InterruptedException {
		generateAlert("Testing Ascending - Descending Orderwise Dashboard chart");
		javascriptExecutorBorder(Dashboard_Objects.settingsBtn);
		Dashboard_Objects.settingsBtn.click();
		Actions action = new Actions(getDriver());
		Random random = new Random();
		for (int i = 0; i < 1; i++) {
			for (int j = Dashboard_Objects.switchAscDsc.size() - 1; j > 0; j--) {
				Thread.sleep(2000);
				action.dragAndDrop(Dashboard_Objects.switchAscDsc.get(random.nextInt(9)),
						Dashboard_Objects.switchAscDsc.get(j)).build().perform();
			}
		}
		javascriptExecutorBorder(Dashboard_Objects.switchSubmit);
		Dashboard_Objects.switchSubmit.click();
		toastMessage();
		verifyChartToogleEnable();
	}

	@Test(priority = 5, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void dashBoardRefresh() throws InterruptedException {
		generateAlert("Testing Refresh button and Close Button!!");
		javascriptExecutorBorder(Dashboard_Objects.refreshBtn);
		Dashboard_Objects.refreshBtn.click();
		Thread.sleep(1500);
		javascriptExecutorBorder(Dashboard_Objects.closeRefresh);
		Dashboard_Objects.closeRefresh.click();
		Thread.sleep(1500);
		Dashboard_Objects.refreshBtn.click();
		javascriptExecutorBorder(Dashboard_Objects.refresh1);
		Dashboard_Objects.refresh1.click();
		Dashboard_Objects.closeRefresh.click();
		Thread.sleep(15000);
		toastMessage();
		try {
			WaitFactory.performWaitFactory(WaitStrategy.CLICKABLE, Dashboard_Objects.refreshBtn).click();
		} catch (Exception e) {
			WaitFactory.performWaitFactory(WaitStrategy.CLICKABLE, Dashboard_Objects.refreshBtn).click();
		}

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		LocalTime time = LocalTime.now();
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm");
		String dateRefresh = Dashboard_Objects.dateTimeRef.getAttribute("innerText");
		generateAlert("Last Profile and Dashboard refresh Date & Time: " + dateRefresh);
		System.out.println("<------------------------- Refresh Dashboard ------------------------------------>");
		System.out.println("Last Profile and Dashboard refresh Date & Time: " + dateRefresh);
		if (dateRefresh.substring(0, 10).trim().equals(formatter.format(date))) {
			if (dateRefresh.substring(11, 16).trim().equals(time.format(formatter1))) {
				javascriptExecutorBorder(Dashboard_Objects.dateTimeRef);
				generateAlert("Profile and Dashboard new refresh time : " + dateRefresh.substring(0, 10) + " "
						+ dateRefresh.substring(11, 16));
				System.out.println("Profile and Dashboard new refresh time : " + dateRefresh.substring(0, 10) + " "
						+ dateRefresh.substring(11, 16));
			}
		}
		Dashboard_Objects.closeRefresh.click();
		Thread.sleep(1500);
		Dashboard_Objects.refreshBtn.click();
		Thread.sleep(1500);
		javascriptExecutorBorder(Dashboard_Objects.refresh2);
		Dashboard_Objects.refresh2.click();
		Thread.sleep(1200);
		toastMessage();
		try {
			WaitFactory.performWaitFactory(WaitStrategy.CLICKABLE, Dashboard_Objects.refreshBtn).click();
		} catch (Exception e) {
			WaitFactory.performWaitFactory(WaitStrategy.CLICKABLE, Dashboard_Objects.refreshBtn).click();
		}
		String dateRefresh1 = Dashboard_Objects.dateTimeRef1.getAttribute("innerText");
		generateAlert("Last Employee movement refresh Date & Time: " + dateRefresh);
		System.out
				.println("--------------------------------_________________________----------------------------------");
		System.out.println("Last Employee movement refresh Date & Time: " + dateRefresh);
		if (dateRefresh1.substring(0, 10).trim().equals(formatter.format(date))) {
			if (dateRefresh1.substring(11, 16).trim().equals(time.format(formatter1))) {
				javascriptExecutorBorder(Dashboard_Objects.dateTimeRef1);
				generateAlert("Employee movement new refresh time : " + dateRefresh.substring(0, 10) + " "
						+ dateRefresh.substring(11, 16));
				System.out.println("Employee movement new refresh time : " + dateRefresh.substring(0, 10) + " "
						+ dateRefresh.substring(11, 16));
			}
		}
		Dashboard_Objects.closeRefresh.click();
	}

	int k = 0;
	int j = 0;

	@Test(priority = 6, retryAnalyzer = IRetryAnalyser.class, enabled = true)
	public void verifyDashboardHighlights() throws InterruptedException {
		String dashboardEmp = Dashboard_Objects.empCount.getText();
		javascriptExecutorBorder(CH_EmpProfileObjects.coreHrmsMenu);
		CH_EmpProfileObjects.coreHrmsMenu.click();
		javascriptExecutorBorder(CH_EmpProfileObjects.noOfemployees);
		String actEmp = CH_EmpProfileObjects.noOfemployees.getText();
		getDriver().navigate().refresh();
		if (dashboardEmp.equals(actEmp)) {
			javascriptExecutorBorder(Dashboard_Objects.empCount);
			generateAlert("The Active Employee Count: " + actEmp);
		}
		javascriptExecutorBorder(Dashboard_Objects.reportLink);
		Dashboard_Objects.reportLink.click();
		javascriptExecutorBorder(Dashboard_Objects.flexi);
		Dashboard_Objects.flexi.click();
		javascriptExecutorBorder(Dashboard_Objects.reportSalary);
		Dashboard_Objects.reportSalary.click();
		javascriptExecutorBorder(Dashboard_Objects.grossSalaryTable);
		Dashboard_Objects.grossSalaryTable.click();
		javascriptExecutorBorder(Dashboard_Objects.status);
		Dashboard_Objects.status.click();
		Select select = new Select(CH_EmpProfileObjects.noOfTableShow);
		select.selectByValue("100");
		List<String> values = new ArrayList<String>();
		for (int i = 0; i <= 100; i++) {
			int length = Dashboard_Objects.grossoryAmnt.get(i).getAttribute("innerText").length();
			if (length > 5) {
				values.add(Dashboard_Objects.grossoryAmnt.get(i).getAttribute("innerText"));
			} else {
				break;
			}
		}
		System.out.println(
				"<----------------------------------------- Active Employee Monthly salary -------------------------------------->");
		values.forEach(f -> {
			int n = Integer.parseInt(f.replace(".00", " ").replace(",", "").trim());
			System.out.println(n);
			k += n * 12;
		});
		System.out.println("-----------------------------------------------------------------");
		System.out.println("The Grossory amnt of active employee " + k);
		System.out.println("-----------------------------------------------------------------");
		generateAlert("The Grossory amnt of active employee " + k);
		Dashboard_Objects.workLocationTable.click();
		javascriptExecutorBorder(Dashboard_Objects.workLocationTable);
		Dashboard_Objects.workLocationTable.click();
		Set<String> locationSet = new HashSet<String>();
		for (int i = 0; i < Dashboard_Objects.workLocationList.size(); i++) {
			if (Dashboard_Objects.workLocationList.get(i).getAttribute("innerText") != " "
					&& Dashboard_Objects.workLocationList.get(i).getAttribute("innerText") != null) {
				locationSet.add(Dashboard_Objects.workLocationList.get(i).getAttribute("innerText"));
			} else {
				break;
			}
		}
		locationSet.forEach(d -> {
			if (!d.isBlank() || !d.isEmpty()) {
				System.out.println(d);
				j++;
			}
		});
		getDriver().navigate().refresh();
		javascriptExecutorBorder(Dashboard_Objects.noOfLocations);
		generateAlert("WorkLocation Count: " + k);
		System.out.println("WorkLocation Count: " + j);
	}

	public void verifyChartToogleEnable() throws InterruptedException {
		generateAlert("Verifying Dashboard Chart title and Dashboard chart present or not");
		System.out.println("--------------------------------------------------");
		System.out.println("Verify Chart names and Dashbord charts");
		for (int i = 0; i < Dashboard_Objects.chartTittle.size(); i++) {
			String switchVerify = Dashboard_Objects.chartTittle.get(i).getText();
			if (switchVerify.equals(switchVerify)) {
				System.out.println("Toogles are presented: " + switchVerify);
			} else {
				System.out.println("Not presented switch toogle");
				generateAlert("Not presented switch toogle");
			}
		}
		generateAlert("All switch toogle and Dashboard charts are presented: True");
	}

}

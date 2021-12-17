package com.qa.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.baseclass.BaseClass;

public class WaitFactory extends BaseClass {

	public WaitFactory() {
	};

	public static WebElement performWaitFactory(WaitStrategy strategy, WebElement Element) {

		WebElement element = Element;
		if (strategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(getDriver(), ImplicitlyWait)
					.until(ExpectedConditions.elementToBeClickable(element));
		} else if (strategy == WaitStrategy.PRESENCE) {
			element = (new WebDriverWait(getDriver(), ImplicitlyWait)
					.until(ExpectedConditions.presenceOfElementLocated((By) element)));
		} else if (strategy == WaitStrategy.VISIBILITY) {
			element = new WebDriverWait(getDriver(), ImplicitlyWait)
					.until(ExpectedConditions.visibilityOfElementLocated((By) element));
		} else {
			System.out.println("Enter the valid strategy");
		}
		return element;
	}

}

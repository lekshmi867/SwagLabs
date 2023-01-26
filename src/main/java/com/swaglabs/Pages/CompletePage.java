package com.swaglabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.swaglabs.Browsers.ProxyDriver;

public class CompletePage extends Page {
	public static final String PAGE_URL = "/checkout-complete.html";

	public CompletePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		
	}

	private static final By successtext=By.cssSelector("h2.complete-header");
	
	public String getOrderCompleteSuccessTxt() {
		return ((ProxyDriver) wd).getText(successtext, 10);
	}

	@Override
	protected void isLoaded() {

		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
		
	}
	
	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

}

package com.swaglabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.swaglabs.Browsers.ProxyDriver;

public class CheckoutPage extends Page {
	public static final String PAGE_URL = "/checkout-step-one.html";

	public CheckoutPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		
	}
	
	private static final By firstName=By.cssSelector("input[id='first-name']");
	private static final By lastName=By.cssSelector("input[id='last-name']");
	private static final By postalcode=By.cssSelector("input[id='postal-code']");
	private static final By continueBtn=By.cssSelector("input[id='continue']");
	private static final By finishBtn=By.cssSelector("button[id='finish']");
	
	public CompletePage checkoutProduct(String fname, String lname, String postCode) {
		((ProxyDriver) wd).sendKeys(firstName, fname);
		((ProxyDriver) wd).sendKeys(lastName, lname);
		((ProxyDriver) wd).sendKeys(postalcode, postCode);
		((ProxyDriver) wd).click(continueBtn);
		((ProxyDriver) wd).click(finishBtn);
		return new CompletePage(wd, true);
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

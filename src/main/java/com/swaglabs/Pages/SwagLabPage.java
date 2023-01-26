package com.swaglabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.swaglabs.Browsers.ProxyDriver;

public class SwagLabPage extends Page {

	public static final String PAGE_URL = "";

	public SwagLabPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By username = By.cssSelector("input[id='user-name']");
	private static final By password = By.cssSelector("input[id='password']");
	private static final By loginBtn = By.cssSelector("input[id='login-button']");

	private void enterUserName(String name) {
		((ProxyDriver) wd).sendKeys(username, name);
	}

	private void enterPassword(String pswd) {
		((ProxyDriver) wd).sendKeys(password, pswd);
	}

	private void clickLoginBtn() {
		((ProxyDriver) wd).click(loginBtn);
	}
	
	public ProductPage login(String usrname, String pswd) {
		enterUserName(usrname);
		enterPassword(pswd);
		clickLoginBtn();
		return new ProductPage(wd,true);
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
	
	@Override
	public SwagLabPage get() {
		return (SwagLabPage)super.get();
	}

}

package com.swaglabs.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.swaglabs.Browsers.Browsers;
import com.swaglabs.Browsers.ProxyDriver;
import com.swaglabs.Listeners.WebdriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Browsers Default_Browser =Browsers.GOOGLE_CHROME;
	public static WebdriverEvents events=new WebdriverEvents();
	public EventFiringWebDriver eventFiringWebDriver; 
	
	public void launchBrowser() {
		switch(Default_Browser) {
		case GOOGLE_CHROME:
			driver=new ProxyDriver(WebDriverManager.chromedriver().create());
			break;
		case EDGE:
			driver=new ProxyDriver(WebDriverManager.edgedriver().create());
			break;
		case FIREFOX:
			driver=new ProxyDriver(WebDriverManager.firefoxdriver().create());
			break;
		
		}
		
		eventFiringWebDriver=new EventFiringWebDriver(driver);
		eventFiringWebDriver.register(events);
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS) ;
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void quitBrowser() {
		driver.quit();
	}
}

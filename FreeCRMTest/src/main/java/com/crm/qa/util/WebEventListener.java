package com.crm.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener{

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		
		System.out.println("Before Navigating to: '"+ url +" '");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		
		System.out.println("Navigated to: '"+ url +" '");
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		
		System.out.println("Before Navigating back");
		
	}

	public void afterNavigateBack(WebDriver driver) {
		
		System.out.println("Navigated back");
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		
		System.out.println("Before Navigating forward");
		
	}

	public void afterNavigateForward(WebDriver driver) {
		
		System.out.println("Navigated forward");
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		
		System.out.println("Before Refresh");
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		
		System.out.println("Refreshed");
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		
		System.out.println("Before findBy :'"+by.toString() +" ' ");
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		
		System.out.println("After findBy :'"+by.toString() +" ' ");
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		
		System.out.println("Before ClickOn :'"+element.toString() +" ' ");
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		
		System.out.println("After ClickOn :'"+element.toString() +" ' ");
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		
		System.out.println("beforeChangeValueOf :'"+element.toString() +" ' ");
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		
		System.out.println("afterChangeValueOf :'"+element.toString() +" ' ");
		
	}

	public void beforeScript(String script, WebDriver driver) {
		
		System.out.println("beforeScript :'"+script +" ' ");
		
	}

	public void afterScript(String script, WebDriver driver) {
		
		System.out.println("afterScript :'"+script +" ' ");
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		
		System.out.println("beforeSwitchToWindow :'"+ windowName +" ' ");
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		
		System.out.println("afterSwitchToWindow :'"+ windowName +" ' ");
		
	}

	public void onException(Throwable throwable, WebDriver driver) {

		System.out.println("exception occured..."+throwable);
		
		TestUtil.takeScreenshot();
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}

}

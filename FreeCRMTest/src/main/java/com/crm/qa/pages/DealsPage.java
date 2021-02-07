package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{

	@FindBy(xpath="//div[contains(@id,'dashboard-toolbar')]/div[1]")
	WebElement dealspageLabel;

	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String VerifyDealsPageTitle()
	{
		String dLabel=dealspageLabel.getAttribute("innerHTML");
		return dLabel;

	}
}

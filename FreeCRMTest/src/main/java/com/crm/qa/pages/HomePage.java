package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	TestUtil testUtil;

	@FindBy(xpath="//span[@class='user-display']")
	WebElement usernamelabel;

	@FindBy(xpath="//div[@id='main-nav']")
	WebElement sideNavbar;

	//@FindBy(xpath="//a[contains(@href,'contacts')]/following-sibling::button")
	@FindBy(xpath="//a[contains(@href,'contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//a[contains(@href,'contacts')]/following-sibling::button")
	WebElement createContact;

	//@FindBy(xpath="//a[contains(@href,'deals')]/following-sibling::button")
	@FindBy(xpath="//a[contains(@href,'deals')]")
	WebElement dealsLink;

	@FindBy(xpath="//a[contains(@href,'tasks')]/following-sibling::button")
	WebElement taskLink;	



	public HomePage()
	{
		PageFactory.initElements(driver, this);
		testUtil=new TestUtil();
	}

	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	public String getLoggedinUser()
	{
		return usernamelabel.getAttribute("innerHTML");
	}
	public ContactsPage clickonContactLink()
	{
		testUtil.mouseHower(driver,sideNavbar);
		//		Actions act=new Actions(driver);
		//		act.moveToElement(sideNavbar).perform();
		contactLink.click();
		return new ContactsPage();

	}
	
	public void createContact()
	{
		testUtil.mouseHower(driver,sideNavbar);
		createContact.click();
		testUtil.mouseOut();
	}

	public DealsPage clickonDealsLink()
	{
		//		Actions act=new Actions(driver);
		//		act.moveToElement(sideNavbar).perform();
		//testUtil.mouseHower(driver, sideNavbar);
		dealsLink.click();
		return new DealsPage();
	}
	public TaskPage clickonTasksLink()
	{
		//testUtil.mouseHower(driver, sideNavbar);
		taskLink.click();
		return new TaskPage();
	}

}

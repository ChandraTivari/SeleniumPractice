package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase{

	TestUtil testUtil;

	@FindBy(xpath="//div[contains(@id,'dashboard-toolbar')]/div[1]")
	WebElement contactpageLabel;
	

	@FindBy(xpath="//div[@id='main-nav']")
	WebElement sideNavbar;

	@FindBy(xpath="//a[contains(@href,'contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstnametxt;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastnametxt;
	
	@FindBy(xpath="//div[@role='listbox' and @name='status']")
	WebElement statusDropdown;
	
	@FindBy(xpath="//div[@class='item']/button[2]")
	WebElement saveBtn;

	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
		testUtil=new TestUtil();
	}

	public String VerifyContactPageTitle()
	{
		testUtil.mouseHower(driver, sideNavbar);
		contactLink.click();
		testUtil.mouseOut();
		String cLabel=contactpageLabel.getAttribute("innerHTML");
		return cLabel;

	}

	public boolean selectByName(String name)
	{
		testUtil.mouseHower(driver, sideNavbar);
		contactLink.click();
		testUtil.mouseOut();
		driver.findElement(By.xpath("//div[contains(@class,'table-wrapper')]/table/tbody/tr/td/child::a[contains(text(),'"+name+"')]/parent::td/preceding-sibling::td/div")).click();
		return driver.findElement(By.xpath("//div[contains(@class,'table-wrapper')]/table/tbody/tr/td/child::a[contains(text(),'"+name+"')]/parent::td/preceding-sibling::td/div/input")).isSelected();
	}
	public boolean createNewContact(String fName,String lName)
	{
		firstnametxt.sendKeys(fName);
		lastnametxt.sendKeys(lName);
		statusDropdown.click();
		driver.findElement(By.xpath("//div[@role='listbox' and @name='status']/descendant::span[contains(text(),'Active')]")).click();
		saveBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElement(By.xpath("//div[@id='dashboard-toolbar']/div[1]")).isDisplayed();
		
	}
}

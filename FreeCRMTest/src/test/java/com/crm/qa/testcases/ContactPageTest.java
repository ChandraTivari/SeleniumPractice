package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homePage;	
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	
	public ContactPageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage=new LoginPage();
		contactsPage=new ContactsPage();
		dealsPage=new DealsPage();		
		homePage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	
	@Test(priority = 1)
	public void contactPageTitleTest()
	{
		Assert.assertTrue(contactsPage.VerifyContactPageTitle().contains("Contacts"));
		test.log(Status.PASS, "Contact page title verified successfully");
	}
	
	@Test(priority = 3)
	public void selectContactTest()
	{
		Assert.assertTrue(contactsPage.selectByName("Peter Wang"), "Selection of the name was not successfull");
	}
	
	@Test(priority = 2,dataProvider ="getTestData")
	public void createNewContactTest(String firstName,String lastName)
	{
		homePage.createContact();
		boolean status=contactsPage.createNewContact(firstName, lastName);
		Assert.assertTrue(status);
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]>testData=TestUtil.getDataFromExcel("Contact");
		return testData.iterator();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}

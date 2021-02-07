package com.crm.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICIT_WAIT=30;
	public static String TEST_DATA_SHEET_PATH=System.getProperty("user.dir")+"/data/ApachePOIPractice.xlsx";
	public static Actions act;	
	static Xls_Reader reader;



	public  void mouseHower(WebDriver driver,WebElement element)
	{
		act=new Actions(driver);

		try {
			Thread.sleep(3000);
			act.moveToElement(element).perform();			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public void mouseOut()
	{
		act.moveByOffset(500, 0).perform();
	}


	public static ArrayList<Object[]> getDataFromExcel(String sheetName)
	{
		ArrayList<Object[]> myData=new ArrayList<Object[]>();

		try {
			reader=new Xls_Reader(TEST_DATA_SHEET_PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(int rowNum=2;rowNum<=reader.getRowCount(sheetName);rowNum++) 
		{
			
			String fName=reader.getCellData("Contact", "FirstName", rowNum);
			String lName=reader.getCellData("Contact", "LastName", rowNum);
			
			myData.add(new Object[] {fName,lName});
			
		}
		
		return myData;

	}
	
	public static String takeScreenshot()
	{
		String dateFormat=getDate();
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/ScreenShots/"+dateFormat+".png";
		
		try {
			FileHandler.copy(srcFile,new File(screenshotPath));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return screenshotPath;
	}
	
	public static String getDate()
	{
		SimpleDateFormat format=new SimpleDateFormat("ddMMYYYYhhmmss");
		
		Date date=new Date();
		return format.format(date);
		
	}
}

package com.bikewale.test;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bikewale.test.Drive;
import com.bikewale.test.ScreenShot;
import com.bikewale.test.Search2;
import com.bikewale.test.WriteData1;

public class TestNG {
	
	static WebDriver driver;
	
	@BeforeTest
	public void driver1()
	{
		Drive o=new Drive();
		driver=o.getwebd();
		 driver.manage().deleteAllCookies();
	    driver.get("https://www.bikewale.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}
	
	@Test(priority=1)
	public void validate()
	{
		String actualTitle="New Bikes, New Scooters, Used Bikes, Buy a Bike - BikeWale";
		String estimatedTitle=driver.getTitle();
		System.out.println("The title is :"+estimatedTitle);
		Assert.assertEquals(actualTitle, estimatedTitle);
	}
	
	@Test(priority=2)
	public void filtering() throws InterruptedException
	{
		Search2 ob2=new Search2(driver);
		ob2.filters();
	}
	
	@Test(priority=3)
	public void writing() throws FileNotFoundException, IOException
	{
		WriteData1 ob3=new WriteData1(driver);
		ob3.writeExcelData();
	}
	
	@Test(priority=4)
	
		public void picture() throws IOException
		{
		ScreenShot ob4=new ScreenShot(driver);
		ob4.screenshot();
		}
	
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	

}
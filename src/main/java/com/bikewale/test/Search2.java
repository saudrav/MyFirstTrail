package com.bikewale.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search2 {
	
	static WebDriver driver;
	
	Search2(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void filters() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='navbarBtn nav-icon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'New Bikes')]")).click();
		Thread.sleep(1000);
		WebElement upcoming= driver.findElement(By.xpath("//a[contains(text(),'Upcoming Bikes')]"));
		upcoming.click();
		driver.findElement(By.xpath("/html[1]/body[1]/section[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'Select brand')]")).sendKeys("Honda");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Select brand')]")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,610)");
	}

}
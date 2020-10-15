package com.bikewale.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenShot {

static WebDriver driver;
	
	ScreenShot(WebDriver driver)
	{
		this.driver=driver;
	}
	public void screenshot() {
		 TakesScreenshot scrn = ((TakesScreenshot)driver);
		  File src = scrn.getScreenshotAs(OutputType.FILE);
		  String Destinationfile = System.getProperty("user.dir")+"/screenshot/";
		  File dest = new File(Destinationfile+System.currentTimeMillis()+".png");
		  try {
			  Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}

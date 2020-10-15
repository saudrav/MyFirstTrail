package com.bikewale.test;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Drive {
	public  WebDriver driver;
	public  WebDriver getwebd()
	{
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver(options);
		return driver;*/
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Browser to Launch :\n1.Chrome\n2.FireFox\n3.Internet Explorer\nEnter Your Choice : ");
		int choice = s.nextInt();
				
		switch(choice)
		{
		   case 1 :  //Launch Chrome Browser
			  ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
			   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			   		driver = new ChromeDriver(options);
		   			 break;
		   			 
		   case 2 :  //Launch FireFox Browser
			   		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			   		driver = new FirefoxDriver();
		   			 break;
		   case 3 : //Launch IE Browser 
		   		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/Drivers/IEDriverServer.exe");
		   		driver = new InternetExplorerDriver();
		   default : //Error for incorrect selection
			   System.out.println("The given browser:" + choice +"is invalid");
				System.exit(0);
				break;
		}
		s.close();
		return driver;
	}

}
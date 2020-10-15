package com.bikewale.test;

/*import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.apache.poi.ss.usermodel.*;


public class WriteData1 {

	static WebDriver driver;
	WriteData1(WebDriver driver)
	{
		this.driver=driver;
	}
	public static void writeExcelData() throws FileNotFoundException, IOException 
    {         
		
	      String name, rupees,dates;
		 ArrayList<String> names=new ArrayList<String>();
		
        ArrayList<String> price=new ArrayList<String>();
		
       ArrayList<String> date=new ArrayList<String>();
        
        File src=new File("C:\\Users\\AbHiGyAn\\eclipse-workspace\\Selenium\\src\\com\\bikewale\\test\\Items.xlsx");
                
        FileInputStream fis=new FileInputStream(src);
	    
	    XSSFWorkbook wb=new XSSFWorkbook();
	    
	    Sheet sheet1=wb.createSheet("TestCase");
	    //bike name
	    names.add("Bike Name");
		name=driver.findElement(By.xpath("//span[contains(text(),'Honda PCX 125')]")).getText();
	    names.add(name);
	    name=driver.findElement(By.xpath("//span[contains(text(),'Honda CBR300R')]")).getText();
	    names.add(name);
	    
	     //bike price   
	    price.add("Expected Price Starting From");
		rupees=driver.findElement(By.xpath("//span[contains(text(),'85,000')]")).getText();
		price.add(rupees);
		rupees=driver.findElement(By.xpath("//span[contains(text(),'2,00,000')]")).getText();
		price.add(rupees);
		
		//bike date
		date.add("Expacted Date");
		dates=driver.findElement(By.xpath("//span[contains(text(),'January 2021')]")).getText();
		date.add(dates);
		dates=driver.findElement(By.xpath("//span[contains(text(),'February 2021')]")).getText();
		date.add(dates);
	    
		//create row and cell and add value
	    for(int i=0;i<names.size();i++)
	    {
	    	
	    	Row row=sheet1.createRow(i);
	    	Cell cell=row.createCell(0);
	    	cell.setCellValue(names.get(i));
	    	Cell cell1=row.createCell(1);
	    	cell1.setCellValue(price.get(i));
	    	Cell cell2=row.createCell(2);
	    	cell2.setCellValue(date.get(i));
	    }
	    

	    fis.close();
	    
	    FileOutputStream fos = new FileOutputStream(src);

	    //write data in the excel file
	    wb.write(fos);
	    
	    //close output stream
	    fos.close();
	    
	    wb.close();
	    
	    
    }
}*/


import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


public class WriteData1 {

	WebDriver driver;
	WriteData1(WebDriver driver)
	{
		this.driver=driver;
	}
	public void writeExcelData() throws FileNotFoundException, IOException 
    {         
        
        File src=new File("C:\\Users\\AbHiGyAn\\eclipse-workspace\\com.bike.test\\src\\main\\java\\Items.xlsx");
                
        FileInputStream fis=new FileInputStream(src);
	    
	    XSSFWorkbook wb=new XSSFWorkbook();
	    
	    Sheet sheet1=wb.createSheet("TestCase");
	    
	    ArrayList<String> names=new ArrayList<String>();
		
        ArrayList<String> price=new ArrayList<String>();
		
        ArrayList<String> date=new ArrayList<String>();
        names.add("Bike Name");
        price.add("Expected Price Starting From");
        date.add("Expacted Date");
        boolean flag = true;
        int ind=1;
		while(flag)
		{
			try {
			flag = driver.findElement(By.xpath("//*[@id=\"upcoming-bikes\"]/div[1]/div[1]/div[2]/ul/li["+ind+"]")).getClass() != null;
			}catch(NoSuchElementException e) {
				//e.printStackTrace();
				break;
			}
			ind++;	
			
		}
		
		String value;
		for(int j=1; j<ind; j++)
		{
			
			value = driver.findElement(By.xpath("//*[@id=\"upcoming-bikes\"]/div[1]/div[1]/div[2]/ul/li["+j+"]/a/div[2]/span[4]")).getText();
			String out = "";
			for(int k=0; k<value.length(); k++)
			{
				if(value.charAt(k)==',')
				{
					continue;
				}
				else
				{
					out+= value.charAt(k);
				}
			}
			
			double d=Double.parseDouble(out);
			if(d<400000)
			{
				names.add(driver.findElement(By.xpath("//*[@id=\"upcoming-bikes\"]/div[1]/div[1]/div[2]/ul/li["+j+"]/a/div[2]/span[1]")).getText());
				
				date.add(driver.findElement(By.xpath("//*[@id=\"upcoming-bikes\"]/div[1]/div[1]/div[2]/ul/li["+j+"]/a/div[2]/span[2]")).getText());
				
				price.add(value);
			}
		}
	    
	    /*
	    
	    //bike name
	    names.add("Bike Name");
		name=driver.findElement(By.xpath("//span[contains(text(),'Honda PCX 125')]")).getText();
	    
		names.add(name);
	    name=driver.findElement(By.xpath("//span[contains(text(),'Honda CBR300R')]")).getText();
	    names.add(name);
	    
	     //bike price   
	    price.add("Expected Price Starting From");
		rupees=driver.findElement(By.xpath("//span[contains(text(),'85,000')]")).getText();
		price.add(rupees);
		rupees=driver.findElement(By.xpath("//span[contains(text(),'2,00,000')]")).getText();
		price.add(rupees);
		
		//bike date
		date.add("Expacted Date");
		dates=driver.findElement(By.xpath("//span[contains(text(),'January 2021')]")).getText();
		date.add(dates);
		dates=driver.findElement(By.xpath("//span[contains(text(),'February 2021')]")).getText();
		date.add(dates);
		*/
	    
		//create row and cell and add value
	    for(int i=0;i<names.size();i++)
	    {
	    	
	    	Row row=sheet1.createRow(i);
	    	Cell cell=row.createCell(0);
	    	cell.setCellValue(names.get(i));
	    	Cell cell1=row.createCell(1);
	    	cell1.setCellValue(price.get(i));
	    	Cell cell2=row.createCell(2);
	    	cell2.setCellValue(date.get(i));
	    }
	    

	    fis.close();
	    
	    FileOutputStream fos = new FileOutputStream(src);

	    //write data in the excel file
	    wb.write(fos);
	    
	    //close output stream
	    fos.close();
	    
	    wb.close();	    
	    
    }
}
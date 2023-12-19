package com.qa.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicRadioButtons {

	static WebDriver driver;
	private static void selectRadioButton(WebDriver driver,String value) {

		WebElement rButton = driver.findElement(By.xpath("//span[@class='_5k_2 _5dba']/input[preceding-sibling::label[text()='"+value+"']]"));
		System.out.println("Before " + rButton.isSelected());

		if(!(rButton.isSelected())){  // it is not selected
			rButton.click();
		}
		System.out.println("clicking on Value is: "+ value);                                 //Value=Female,Male, Custom

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("After " + rButton.isSelected()); // after it is clicking

	}
	public static void main(String[] args)throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aarthi_P\\Downloads\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@role='button' and  @rel='async']")).click(); //  X-path for "Create Account" 

		selectRadioButton(driver,"Custom");
		selectRadioButton(driver,"Male");
		selectRadioButton(driver,"Female");
		driver.close();
		
//	String style ="async";
//	//String xpath="//img[@decoding=\"" + value +"\"]";
//	String xpat="//figure[@style=\""+style+"\"]";
//	System.out.print(xpat);
//	
////	String Color="Pink";
////	String name="hello world"+Color;
//
//	
	
		
	} }
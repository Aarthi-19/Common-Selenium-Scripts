package com.qa.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicCheckBox {
	static WebDriver driver;
	private static void selectCheckBox(String displayCheckbox) {
		WebElement searchBox =driver.findElement(By.name("field-keywords"));
		searchBox.sendKeys("shoes for men",Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	    WebElement input = driver.findElement(By.xpath("//li[@aria-label='"+ displayCheckbox +"']//input"));
	    
	    WebElement i  =   driver.findElement(By.xpath("//li[@aria-label='"+ displayCheckbox +"']//i"));
		boolean box=input.isSelected();
		System.out.println("Before user action, checkbox is selected "+ box);
		if(!box)
		{
			i.click();
		}
		boolean box2=(driver.findElement(By.xpath("//li[@aria-label='"+ displayCheckbox +"']//input")).isSelected());
		System.out.println("After user action, checkbox is selected "+ box2);
	}
	public static void main(String[] args)throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aarthi_P\\Downloads\\chromedriver-win64\\chromedriver.exe");
	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("c/");
		
		selectCheckBox("ASIAN");

		Thread.sleep(3000);
		selectCheckBox("Campus");
		driver.close();
	}
}

package com.ecom.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CheckOutTest extends ShoppingTest {
	
	
	@Test (dependsOnMethods = {"selectClothes"})
	public void checkOut() {
		System.out.println(" in checkout method");
		try {
			Thread.sleep(3000);
			
			 driver.findElement(By.xpath("//a[contains(@class,'standard-checkout')]")).click();
			driver.findElement(By.xpath("//button[@name='processAddress']")).click();//address click
			driver.findElement(By.xpath("//button[@name='processCarrier']")).click(); // shipping click
	
			//agree with terms 
			driver.findElement(By.xpath("//a[@title='Close']")).click();
			driver.findElement(By.id("cgv")).click();
			
			driver.findElement(By.xpath("//button[@name='processCarrier']")).click(); // shipping click
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

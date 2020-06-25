package com.ecom.testCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.ecom.pageObject.HomePageLogin;
import com.ecom.pageObject.Shopping;

public class ShoppingTest extends LoginTest {



	@Test(dependsOnMethods = {"login"})
	public void selectClothes() {

		Shopping sp = new Shopping(driver);
		
		// can i access the element from page class and perform actions here
		//	action.moveToElement(sp.getWomenBt()).build().perform();
		//	action.moveToElement(sp.getDress()).click().build().perform();

		sp.moveToWomenTab();
		sp.clickDressTab();

		String[] choice = {"Summer","Chiffon"};
		int count = sp.getListSize();

		for(int i=0 ; i<count; i++) {
			String title = sp.getListAttrValue(i, "title");
			System.out.println(title);

			for(int j=0;j<choice.length;j++) {
				if(title.contains(choice[j])) {
					sp.moveToImgContainer(i);
					sp.clickAddToCart(i);
					break;
				}
			} 

		}

		sp.clickCheckOut();
	}


}

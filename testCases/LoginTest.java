package com.ecom.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecom.pageObject.HomePageLogin;

public class LoginTest extends Base {
	
	@Test
	public void login() {
		
		HomePageLogin pg = new HomePageLogin(driver);
		pg.clickSignIn();
		pg.setEmail(uName);
		pg.setPwd(pwd);
		pg.clickLogin();
		if(driver.getTitle().equalsIgnoreCase("My account - My Store")) {
			logger.info(" login succesful");
			System.out.println(" login succesful");
            Assert.assertTrue(true);
		}else {
			logger.info(" login failed");
            Assert.assertTrue(false);
		}
		
	}

}

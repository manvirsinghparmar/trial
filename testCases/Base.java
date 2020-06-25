package com.ecom.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ecom.utility.ReadConfig;

public class Base {
	
	ReadConfig rc = new ReadConfig();

	public String baseUrl = rc.getApplicationURL();
	public String uName=rc.getUserName();
	public String pwd=rc.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		// setting logger
		logger = Logger.getLogger("e-commerce");
		PropertyConfigurator.configure("log4j.properties");

		// System.getProperty("user.dir") or ./ for project path
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",rc.getChromePath());
			driver = new ChromeDriver();
		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",rc.getIePath());
			driver = new InternetExplorerDriver();
		}
		
	
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	 @AfterClass(enabled=false)
	public void tearDown() {
		driver.close();
		driver.quit();
	}


	public void captureScreen(WebDriver eDriver, String tname) throws IOException {

		logger.info("capturing screenshot");
		TakesScreenshot ts = (TakesScreenshot) eDriver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		// System.out.println("src file :"+source.getName());
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");

	}


 
	

}

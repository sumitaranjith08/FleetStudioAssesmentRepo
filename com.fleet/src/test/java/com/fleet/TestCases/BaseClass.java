package com.fleet.TestCases;

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.fleet.Utilities.ReadConfig;


public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	public String baseUrl=readconfig.getApplicationUrl();
	public static WebDriver driver;
	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		logger=Logger.getLogger(getClass());
		PropertyConfigurator.configure("Log4j.properties");
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());
		driver=new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
		System.setProperty("webdriver.ie.driver", readconfig.getiepath());
		driver=new InternetExplorerDriver();
		}
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS)	;
		

	}
	public void setUp() {
	System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
	driver=new ChromeDriver();
	
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(src, target);
		System.out.println("Screenshot taken");
		
	}
	
	
	@AfterClass
	
	public void tearDown() {
		driver.quit();
	}
	
	
	
}


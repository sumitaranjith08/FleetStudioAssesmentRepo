package com.fleet.TestCases;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.SignUp.PageObject.SignupPage;

public class SignupTest extends BaseClass {
	@Test
	public void LoginTest() throws InterruptedException, IOException {
		BasicConfigurator.configure();
	
	logger.info("url is opened");
	SignupPage su=new SignupPage(driver);
	su.firstName("Sumita");
	su.lastName("Gloria");
	su.email("sumisam08@gmail.com");
	su.pwd("abc@12345678");
	su.conpwd("abc@12345678");
	su.toClickterms();
	su.toClickSubmit();
	
	if(driver.getTitle().equalsIgnoreCase("")) {
		Assert.assertTrue(true);
		logger.info("login test is passed");
	}
	else {
		captureScreen(driver, "SignupTest");
		Assert.assertTrue(false);
		logger.info("login test is failed");
	}
}

}

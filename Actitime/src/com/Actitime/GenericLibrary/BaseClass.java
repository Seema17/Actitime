package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.pom.LoginPage;

public class BaseClass {
	public WebDriver driver;
	@BeforeSuite
	public void databaseConnection() {
		Reporter.log("database connected",true);
	}
	@BeforeClass
	public void launchbrowser() {
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.actitime.com");
		Reporter.log("browser launched successfully", true);
	}
	@BeforeMethod
	public void loginToActitime() throws IOException {
		LoginPage lp=new LoginPage(driver);
		FileLibrary f=new FileLibrary();
		String un = f.readDataFromProperty("username");
		lp.getUntx().sendKeys(un);
		String pw = f.readDataFromProperty("password");
		lp.getPwtx().sendKeys(pw);
		lp.getLgbtn().click();
		
		Reporter.log("logged in successfully", true);
		
	}
	@AfterMethod
	public void logoutFromActitime() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("Logged out Successful",true);
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("Browser closed successfully",true);
	}
	@AfterSuite
	public void closeddatabaseConnection() {
		Reporter.log("database disconnect",true);
	}
	

}

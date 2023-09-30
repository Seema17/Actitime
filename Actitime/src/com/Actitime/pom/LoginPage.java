package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//declaration
	@FindBy(id="username")
	private WebElement untx;
	@FindBy(name="pwd")
	private WebElement pwtx;
	@FindBy(xpath="//div[.='Login']")
	private WebElement lgbtn;
	
	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getUntx() {
		return untx;
	}

	public WebElement getPwtx() {
		return pwtx;
	}

	public WebElement getLgbtn() {
		return lgbtn;
	}

		
	}


package com.Actitime.Testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.pom.HomePage;
import com.Actitime.pom.TaskPage;

public class CreateCustomer extends BaseClass{
	@Test
	public void createcustomer() throws EncryptedDocumentException, IOException
	{
		HomePage hp = new HomePage(driver);
		hp.getTasktab().click();
		TaskPage t = new TaskPage(driver);
		t.getAddnew().click();
		t.getNewcustomer().click();
		FileLibrary f = new FileLibrary();
		String name = f.readDataFromExcelSheet("Sheet1", 1, 1);
		t.getCustomername().sendKeys(name);
		String desp = f.readDataFromExcelSheet("Sheet1", 1, 2);
		t.getCustomerdesp().sendKeys(desp);
		t.getCreatebutton().click();
		String Expected = name;
		String Actual = driver.findElement(By.xpath("(//div[.='"+name+"'])[2]")).getText();
		SoftAssert s = new SoftAssert();
		s.assertEquals(Expected, Actual);
		s.assertAll();
	}

}

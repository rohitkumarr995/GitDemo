package EasyMyTrip;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.Homepage;
import Resources.baseFlightBook;

public class calender extends baseFlightBook{
	
	public Homepage hpCal;
	
	@BeforeTest
	public void openBrowser() throws IOException {
		
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void calendertest() throws InterruptedException {
		
		
		hpCal = new Homepage(driver);
		hpCal.invokeCal().click();
		
		while(!hpCal.getMonth().getText().equalsIgnoreCase("NOV 2021")) {
			hpCal.getNext().click();
		}
		
		hpCal.selectedDate().click();
	}
	
	@Test
	public void staticDropDwon1() {
		
		hpCal.getDropDown().click();
		
		int i=1;
		while(hpCal.getAdult().getText().contains("Adult")) {
			
			while(i<2) {
				hpCal.getAdltNext().click();
				break;
			}
			break;

		}
		
		hpCal.submit().click();
		
	}
	
	@Test
	public void staticDropDown2() {
		
		hpCal.getdropDwon2().click();
		
		List<WebElement> clasess = driver.findElements(By.cssSelector(".cont_flt"));
		
		for(WebElement classs : clasess)
		{
			if(classs.getText().equalsIgnoreCase("Prem.Economy"))
			{
				classs.click();
				break;
			}
		}
		
		hpCal.submit2().click();
		
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	

}

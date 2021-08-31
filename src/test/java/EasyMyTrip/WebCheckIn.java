package EasyMyTrip;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.WebCheck;
import Resources.baseFlightBook;

public class WebCheckIn extends baseFlightBook{

	@BeforeTest
	public void openBrowser() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test(dataProvider= "getData")
	public void invokeWebCheckIn(String pnr, String first, String last) {
		
		WebCheck wc = new WebCheck(driver);
		wc.getcheckIn().click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("window.scrollBy(0,1500)");
		wc.getLink().click();
		wc.getPNR().sendKeys(pnr);
		wc.getFirstName().sendKeys(first);
		wc.getlastName().sendKeys(last);
		wc.enableSearch().click();
		
		System.out.println(wc.getDescription().getText());
		System.out.println(wc.getDescription2().getText());
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[1][3];
		data[0][0]="1562546";
		data[0][1]="Rohit";
		data[0][2]="Kumar";
		
		return data;
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}

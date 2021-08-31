package EasyMyTrip;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.Homepage;
import PageObject.TravelBlogPage;
import Resources.baseFlightBook;

public class TravelBlog extends baseFlightBook{
	
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser() throws IOException {
		
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Parameters("BlogTitle")
	@Test
	public void visitTravelBlog(String BlogTitle) {
		
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("window.scrollBy(0,1100)");
		
		Homepage hm = new Homepage(driver);
		hm.getTravelBlog().click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		
		jse.executeScript("window.scrollBy(0,500)");
		
		TravelBlogPage trB = new TravelBlogPage(driver);
		
		Assert.assertEquals(trB.getBlogTitle().getText(), BlogTitle);
		System.out.println("I have resolved travel blog title code");
		System.out.println("I have checked. It's working fine");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}

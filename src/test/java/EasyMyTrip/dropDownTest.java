package EasyMyTrip;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.Homepage;
import Resources.baseFlightBook;

public class dropDownTest extends baseFlightBook {
	
	public WebDriver driver;
	
	@BeforeTest
	public void openBrowser() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Parameters({"depthalfcityName", "fulldeptName", "arrvhalfcityName", "arrfullcityName"})
	@Test
	public void dropDownSuggestions(String hafcitName, String fulldeptName, String arrhafcitName, String arrfullcityName) throws InterruptedException {
		
		Homepage hp = new Homepage(driver);
		hp.departBox().click();
		Thread.sleep(2000);
		hp.departBox().sendKeys(hafcitName);
		Thread.sleep(2000);
		 
		List<WebElement> options = hp.from();
		
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase(fulldeptName))
			{		
				option.click();
				break;
			}
		}
		
		Thread.sleep(2000);
	
		hp.ArrivalBox().sendKeys(arrhafcitName);
		
		Thread.sleep(2000);
		List<WebElement> toOptions = hp.from();
		
		for(WebElement toOption : toOptions) {
			
			if(toOption.getText().equalsIgnoreCase(arrfullcityName))
			{
				toOption.click();
				break;
			}
		}
		
	
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}

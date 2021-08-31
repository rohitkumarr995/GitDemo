package EasyMyTrip;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.FooterHomePage;
import Resources.baseFlightBook;

public class BrokenLink extends baseFlightBook {
	
	@BeforeTest
	public void openBrowser() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void getbrokenlinks() throws MalformedURLException, IOException {
		
		FooterHomePage fh = new FooterHomePage(driver);
		
		List<WebElement> links = fh.getLinks();
		
		System.out.println(fh.getLinks().size());
		
		for(WebElement link : links) 
		{
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int resCode = conn.getResponseCode();
			System.out.println(resCode);
			
			if(resCode>400)
			{
				System.out.println("The links with text "+link.getText()+" is broken, has status code "+ resCode);
			}
			else
			{
				break;
				//System.out.println("All links are working properly");
			}
		}
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}

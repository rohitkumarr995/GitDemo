package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterHomePage {
	
	WebDriver driver;
	
	private By links = By.xpath("//div[@class='ftr_col_1']/ul/li/a");
	
	public FooterHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public List<WebElement> getLinks() {
		
		return driver.findElements(links);
	}

}

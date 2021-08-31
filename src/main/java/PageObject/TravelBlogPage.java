package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelBlogPage {
	
	WebDriver driver;
	
	private By title = By.cssSelector(".homepage_builder_title");
	
	public TravelBlogPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getBlogTitle() {
		
		return driver.findElement(title);
	}

}

package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebCheck {
	WebDriver driver;
	
	private By chkIn = By.cssSelector("a[class='webchksc']");
	private By link = By.xpath("//*[@id='tab-20']/div/p[1]/a");	
	private By pnr = By.id("pnrNumber");
	private By firstName = By.id("firstName");
	private By surname = By.id("lastName");
	private By search = By.id("search");
	private By descr = By.cssSelector(".description");
	private By descr2 = By.xpath("//div[@class='validation-messages']/div[2]/ul/li");
	private By telNum = By.cssSelector("a[href*='4040904090']");
	
	public WebCheck(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement getTelNumber() {
		return driver.findElement(telNum);
	}
	
	public WebElement getDescription() {
		
		return driver.findElement(descr);
	}
	
	public WebElement getDescription2() {
		
		return driver.findElement(descr2);
	}
	
	public WebElement enableSearch() {
		return driver.findElement(search);
	}

	public WebElement getcheckIn() {
		return driver.findElement(chkIn);
	}
	
	public WebElement getLink() {
		return driver.findElement(link);
	}
	
	public WebElement getPNR() {
		return driver.findElement(pnr);
	}
	
	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}
	
	public WebElement getlastName() {
		return driver.findElement(surname);
	}

}

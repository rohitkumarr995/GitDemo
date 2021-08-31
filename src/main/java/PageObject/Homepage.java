package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;


public class Homepage{

	WebDriver driver;
	
	//dropDown
	private By depart = By.cssSelector("#FromSector_show");
	private By suggPlace = By.cssSelector("[class='ct']");
	private By arrival = By.cssSelector("#Editbox13_show");


	public Homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public List<WebElement> from() {
		
		return driver.findElements(suggPlace);
	}

	public WebElement departBox() {
		// TODO Auto-generated method stub
		return driver.findElement(depart);
	}
	

	public WebElement ArrivalBox() {
		// TODO Auto-generated method stub
		return driver.findElement(arrival);
	}
	
	//Calendar
	
	private By returnD = By.cssSelector("#rdatelbl");
	private By rndTrip = By.cssSelector("[class*='click-round']");
	private By next = By.id("img2Nex");
	
	//ccal
	
	private By cal = By.id("ddate");
	private By monthName = By.cssSelector(".month");
	private By selDate = By.id("trd_2_16/11/2021");
	private By dropDown = By.cssSelector(".dropbtn_n9");
	private By people = By.cssSelector(".ttl_col");
	private By adltnxt = By.cssSelector(".plus_box1");
	private By chldNext = By.cssSelector(".plus_boxChd");
	private By infantNext = By.cssSelector(".plus_box1Inf");
	private By ddownDone = By.id("traveLer");
	
	private By dropDwon2 = By.cssSelector(".dropbtn_n10");
	private By dddropDown2 = By.id("tripType");
	
	public WebElement submit2() {
		return driver.findElement(dddropDown2);
	}
	
	public WebElement getdropDwon2() {
		return driver.findElement(dropDwon2);
	}
	
	public WebElement submit() {
		return driver.findElement(ddownDone);
	}
	
	public WebElement getInfant() {
		return driver.findElement(infantNext);
	}
	
	public WebElement getChildNext() {
		return driver.findElement(chldNext);
	}
	
	public WebElement getAdltNext() {
		return driver.findElement(adltnxt);
	}
	
	public WebElement getAdult() {
		return driver.findElement(people);
	}
	
	public WebElement invokeCal() {
		return driver.findElement(cal);
	}
	
	public WebElement getMonth() {
		return driver.findElement(monthName);
	}
	
	public WebElement getNext() {
		return driver.findElement(next);
	}
	
	public WebElement selectedDate() {
		return driver.findElement(selDate);
	}
	
	public WebElement getDropDown() {
		return driver.findElement(dropDown);
	}
	
	
	private By viewAll = By.cssSelector("a[class='view_al']");
	
	public WebElement getTravelBlog() {
		return driver.findElement(viewAll);
	}
	
	
}

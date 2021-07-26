package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightResult_po {

	public WebDriver driver;

	By trip = By.className("multiDropDownVal");
	By from = By.id("fromCity");
	By to = By.id("toCity");
	By departure = By.id("departure");
	By returnDate = By.id("return");
	By travellerAndClass = By.id("travellerAndClass");

	public FlightResult_po(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement trip() {
		return driver.findElement(trip);
	}

	public WebElement from() {
		return driver.findElement(from);
	}

	public WebElement to() {
		return driver.findElement(to);
	}

	public WebElement departure() {
		return driver.findElement(departure);
	}

	public WebElement returnDate() {
		return driver.findElement(returnDate);
	}

	public WebElement travellerAndClass() {
		return driver.findElement(travellerAndClass);
	}
}

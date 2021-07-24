package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage_po {

	public WebDriver driver;

	public LandingPage_po(WebDriver driver) {
		this.driver = driver;
	}

	By login = By.xpath("//li[@data-cy='account']");
	By from = By.cssSelector(".fsw_inner div");
	By to = By.xpath("//label[@for='toCity']/..");
	By fromSearch = By.xpath("//input[@Placeholder='From']");
	By searchSuggestion = By.cssSelector(".react-autosuggest__suggestions-list p");
	By toSearch = By.xpath("//input[@Placeholder='To']");
	By roundTrip = By.xpath("//li[@data-cy='roundTrip']/span");
	By departure = By.xpath("//div[contains(@class,'dates')]");
	By returnDate = By.xpath("//div[contains(@class,'reDates')]");
	By todayDate = By.xpath("//div[@class='DayPicker-Day DayPicker-Day--today']");
	By secondDate = By.xpath("//div[@class='DayPicker-Day']");
	By traveller = By.xpath("//div[@data-cy='flightTraveller']");
	By travellerSelection = By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']/li");
	By travellerOptions = By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']/li"); 

	public WebElement Login() {
		return driver.findElement(login);
	}

	public WebElement From() {
		return driver.findElement(from);
	}

	public WebElement To() {
		return driver.findElement(to);
	}

	public WebElement FromSearch() {
		return driver.findElement(fromSearch);
	}

	public List<WebElement> SearchSuggestion() {
		return driver.findElements(searchSuggestion);
	}

	public WebElement ToSearch() {
		return driver.findElement(toSearch);
	}

	public WebElement RoundTrip() {
		return driver.findElement(roundTrip);
	}

	public WebElement TodayDate() {
		return driver.findElement(todayDate);
	}

	public WebElement SecondDate() {
		return driver.findElement(secondDate);
	}

	public WebElement Departure() {
		return driver.findElement(departure);
	}

	public WebElement Traveller() {
		return driver.findElement(traveller);
	}

	public List<WebElement> TravellerSelection() {
		return driver.findElements(travellerSelection);
	}
}

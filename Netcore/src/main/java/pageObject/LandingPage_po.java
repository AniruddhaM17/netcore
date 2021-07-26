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
	// By todayDate = By.xpath("//div[contains(@class,'today')]");
	By secondDate = By.xpath("//div[contains(@class,'today')]/..//div[2]");
	By traveller = By.xpath("//div[@data-cy='flightTraveller']");
	By travellerSelection = By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']/li");
	By travellerAdult = By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']/li[@data-cy='adults-2']");
	By travellerInfant = By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']/li[@data-cy='infants-1']");
	By travellerChildren = By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']/li[@data-cy='children-1']");
	By pastDate = By.xpath(
			"//div[@class='DayPicker-Day DayPicker-Day--start DayPicker-Day--selected DayPicker-Day--today']/./preceding-sibling::div[1]");
	By popup = By.xpath("//div[@class='autopop__wrap makeFlex column defaultCursor']");
	By businessClass = By.xpath("//ul[@class='guestCounter classSelect font12 darkText']/li[@data-cy='travelClass-2']");
	By applyButton = By.xpath("//button[@data-cy='travellerApplyBtn']");
	By numberOfTraveller = By.xpath("//span[@data-cy='travellerText']/span");
	By travellerClass = By.xpath("//label[@for='travellers']/p[2]");
	By todayDate = By.xpath(
			"//div[@class='DayPicker-Months']/div[1]/div[@class='DayPicker-Body']/div/div[not(contains(@class,'disabled'))]//p[text()=${number}]");
	By search = By.xpath("//a[text()='Search']");

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

	public WebElement travellerAdult() {
		return driver.findElement(travellerAdult);
	}

	public String PastDate() {
		return driver.findElement(pastDate).getAttribute("class");
	}

	public WebElement returnDate() {
		return driver.findElement(returnDate);
	}

	public WebElement popup() {
		return driver.findElement(popup);
	}

	public WebElement travellerInfant() {
		return driver.findElement(travellerInfant);
	}

	public WebElement travellerChildren() {
		return driver.findElement(travellerChildren);
	}

	public WebElement businessClass() {
		return driver.findElement(businessClass);
	}

	public WebElement applyButton() {
		return driver.findElement(applyButton);
	}

	public WebElement numberOfTraveller() {
		return driver.findElement(numberOfTraveller);
	}

	public String travellerClass() {
		return driver.findElement(travellerClass).getText();
	}

	public WebElement search() {
		return driver.findElement(search);
	}
}

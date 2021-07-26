package operations;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pageObject.FlightResult_po;
import pageObject.LandingPage_po;
import utilities.CommonMethods;
import utilities.Wait;

public class Logic extends Base {

	public static LandingPage_po lp;
	public static FlightResult_po fr;
	public static String fromCity = "Mumbai, India";
	public static String toCity = "Delhi, India";
	public static int number = CommonMethods.getOnlyDate();
	public static String count;

	public static void searchFlight() {

		lp = new LandingPage_po(driver);

		if (CommonMethods.checkElement("//div[@class='autopop__wrap makeFlex column defaultCursor']", driver)) {

			lp.Login().click();
		} else
			System.out.println("Popup is not present");
		lp.RoundTrip().click();
		System.out.println("Select Round trip");
		lp.From().click();
		lp.FromSearch().sendKeys("Mum");
		List<WebElement> starts = lp.SearchSuggestion();

		for (WebElement start : starts) {
			if (start.getText().equalsIgnoreCase(fromCity)) {
				start.click();
				break;
			}
		}

		lp.To().click();
		lp.ToSearch().sendKeys("Del");
		List<WebElement> ends = lp.SearchSuggestion();

		for (WebElement end : ends) {
			if (end.getText().equalsIgnoreCase(toCity)) {
				end.click();
				break;
			}
		}

		// int number = CommonMethods.getOnlyDate();
		WebElement todayDate = driver.findElement(By.xpath(
				"//div[@class='DayPicker-Months']/div[1]/div[@class='DayPicker-Body']/div/div[not(contains(@class,'disabled'))]//p[text()="
						+ number + "]"));
		todayDate.click();

		int number1 = number - 1;

		WebElement pastDate = driver.findElement(By.xpath(
				"//div[@class='DayPicker-Months']/div[1]/div[@class='DayPicker-Body']/div/div[(contains(@class,'disabled'))]//p[text()="
						+ number1 + "]/../.."));
		String className = pastDate.getAttribute("class");
		// Wait.expWait(driver, 5, todayDate);
		// lp.TodayDate().click();
		Assert.assertEquals(className, "DayPicker-Day DayPicker-Day--disabled", "Date disabled");
		// Wait.expWait(driver, 5, SecondDate);

		int number2 = number + 1;
		WebElement SecondDate = driver.findElement(By.xpath(
				"//div[@class='DayPicker-Months']/div[1]/div[@class='DayPicker-Body']/div/div[not(contains(@class,'disabled'))]//p[text()="
						+ number2 + "]"));
		SecondDate.click();
		Wait.expWait(driver, 5, lp.returnDate());
		lp.returnDate().click();
		Assert.assertEquals(className, "DayPicker-Day DayPicker-Day--disabled", "Date disabled");
		WebElement SecondDate1 = driver.findElement(By.xpath(
				"//div[@class='DayPicker-Months']/div[1]/div[@class='DayPicker-Body']/div/div[not(contains(@class,'disabled'))]//p[text()="
						+ number2 + "]"));
		Wait.expWait(driver, 5, SecondDate1);
		SecondDate1.click();

		lp.Traveller().click();
		Wait.expWait(driver, 5, lp.travellerAdult());
		lp.travellerAdult().click();
		Wait.expWait(driver, 5, lp.travellerInfant());
		lp.travellerInfant().click();
		Wait.expWait(driver, 5, lp.travellerChildren());
		lp.travellerChildren().click();
		Wait.expWait(driver, 5, lp.businessClass());
		lp.businessClass().click();
		Wait.expWait(driver, 5, lp.applyButton());
		lp.applyButton().click();

		Wait.expWait(driver, 5, lp.numberOfTraveller());
		// System.out.println(lp.numberOfTraveller());
		String[] travellerCount = lp.numberOfTraveller().getAttribute("innerHTML").split("&");
		count = travellerCount[0];
		// Assert.assertEquals(lp.numberOfTraveller().getAttribute("innerHTML"),
		// "4&nbsp;");
		Assert.assertEquals(count, "4");
		Assert.assertEquals(lp.travellerClass(), "Business");

		lp.search().click();
	}

	public static void flightResult() {

		fr = new FlightResult_po(driver);

		Assert.assertEquals(fr.trip().getText(), "Round Trip");
		Assert.assertEquals(fr.from().getAttribute("value"), fromCity);
		Assert.assertEquals(fr.to().getAttribute("value"), toCity);
		String startDate = fr.departure().getAttribute("title");
		// Assert.assertEquals(startDate.contains(number), number);
		String endDate = fr.returnDate().getAttribute("title");
		// Assert.assertEquals(endDate.contains(number), number);
		Assert.assertTrue(fr.travellerAndClass().getAttribute("value").contains(count));
		Assert.assertTrue(fr.travellerAndClass().getAttribute("value").contains("Business"));
	}

}

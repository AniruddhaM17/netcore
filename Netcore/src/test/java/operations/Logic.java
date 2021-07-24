package operations;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pageObject.LandingPage_po;
import utilities.Wait;

public class Logic extends Base {

	public static LandingPage_po lp;

	public static void searchFlight() throws IOException {

		lp = new LandingPage_po(driver);
		lp.Login().click();
		lp.RoundTrip().click();
		System.out.println("Select Round trip");
		lp.From().click();
		lp.FromSearch().sendKeys("Mum");
		List<WebElement> starts = lp.SearchSuggestion();

		for (WebElement start : starts) {
			if (start.getText().equalsIgnoreCase("Mumbai, India")) {
				start.click();
				break;
			}
		}

		lp.To().click();
		lp.ToSearch().sendKeys("Del");
		List<WebElement> ends = lp.SearchSuggestion();

		for (WebElement end : ends) {
			if (end.getText().equalsIgnoreCase("Delhi, India")) {
				end.click();
				break;
			}
		}

		lp.TodayDate().click();
		lp.SecondDate().click();
		
		lp.Traveller().click();
		

	}

}

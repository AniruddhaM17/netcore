package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {

	public static boolean checkElement(String element, WebDriver driver) {

		try {
			driver.findElement(By.xpath(element)).isDisplayed();

		} catch (Exception e) {
			return false;
		}
		return true;

	}

	public static int getOnlyDate() {
		String date = java.time.LocalDate.now().toString();
		String[] parts = date.split("-");
		String day = parts[2];
		// System.out.println(day);
		int day1 = Integer.parseInt(day);
		return day1;
	}

}

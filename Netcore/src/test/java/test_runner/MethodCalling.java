package test_runner;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import operations.Base;
import operations.Hooks;
import operations.Logic;

import pageObject.LandingPage_po;

public class MethodCalling extends Hooks {

	public LandingPage_po lp;

	@Test(priority = 0)
	public void searchFlight() throws IOException {

		Logic.searchFlight();
		System.out.println("Flight details entered successfully");
	}
	
	@Test(priority = 1)
	public void flightSearchResult() throws IOException {

		Logic.flightResult();
		System.out.println("Flight results validated successfully");
	}

}
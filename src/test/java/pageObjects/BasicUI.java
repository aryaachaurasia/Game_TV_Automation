package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicUI {
	
	protected WebDriver driver;
	
	protected BasicUI(WebDriver driver) {
		this.driver=driver;
	}
	
	protected By getLocator(String elementToken) {
		String[] locator = LocatorsReader.getElement(elementToken).toArray(new String[2]);
		return getBy(locator[0].trim(), locator[1].trim());
	}
	
	protected By getLocator(String elementToken, String replacement) {
		String[] locator = LocatorsReader.getElement(elementToken).toArray(new String[2]);
		locator[1] = locator[1].replaceAll("\\$\\{.+\\}", replacement);
		return getBy(locator[0].trim(), locator[1].trim());
	}
	
	protected WebElement element(String elementToken){
		WebElement elem = null;
		By locator = getLocator(elementToken);
		try {
			elem = driver.findElement(locator);
		} catch (TimeoutException excp) {
			throw new NoSuchElementException("Element not found");
		}
		return elem;
	}
	
	protected WebElement element(String elementToken, String replacement) throws NoSuchElementException {
		WebElement elem = null;
		By locator = getLocator(elementToken, replacement);
		try {
			elem=driver.findElement(locator);
		} catch (TimeoutException excp) {
			throw new NoSuchElementException("Element not found");
		}
		return elem;
	}
	
	protected List<WebElement> elements(String elementToken) {
		return driver.findElements(getLocator(elementToken));
	}
	
	protected String getCurrentPageURL() {
		return driver.getCurrentUrl();
	}
	
	private By getBy(String locatorType, String locatorValue) {
		switch (Locators.valueOf(locatorType)) {
		case id:
			return By.id(locatorValue);
		case xpath:
			return By.xpath(locatorValue);
		case css:
			return By.cssSelector(locatorValue);
		case name:
			return By.name(locatorValue);
		case classname:
			return By.className(locatorValue);
		case linktext:
			return By.linkText(locatorValue);
		default:
			return By.id(locatorValue);
		}
	}

}

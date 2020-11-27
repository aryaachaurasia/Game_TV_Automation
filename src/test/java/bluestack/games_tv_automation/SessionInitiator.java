package bluestack.games_tv_automation;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import bluestack.games_tv_keywords.Games_tv_actions;
import utilityClasses.ConfigPropertyReader;
import utilityClasses.RestClient;

public class SessionInitiator {
	private WebDriver driver;
	public Games_tv_actions games_tv_homepage;
	public RestClient restClient;
	
	public SessionInitiator() {
		configureDriver();
		initPage();
	}
	
	public void configureDriver() {
		if(ConfigPropertyReader.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe"); 
			 driver = new ChromeDriver();
		}
		else if(ConfigPropertyReader.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/geckodriver.exe"); 
			 driver = new FirefoxDriver();
		}
		else {
			//implement for other browsers or mobile applications etc
		}
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}
	
	public void launchApplication(String url) {
		deleteAllCookies();
		System.out.println("Launched Application "+url);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void closeBrowserWindow() {
		driver.close();
	}
	
	public void closeBrowserSession() {
		driver.quit();
	}

	
	public void initPage() {
		restClient= new RestClient();
		games_tv_homepage= new  Games_tv_actions(driver);
	}
}

package bluestack.games_tv_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import bluestack.games_tv_keywords.Games_tv_actions;
import utilityClasses.CSVFileWriter;
import utilityClasses.ConfigPropertyReader;
import utilityClasses.RestClient;

//sessionInitiator is like jam between the Action classes and tes classes
//rather than initializing Actions classes in each test class, we will initialize it at one place
//Initialize driver here as per he browser preference defined in Config.properties file

public class SessionInitiator {
	private WebDriver driver;
	public Games_tv_actions games_tv_homepage;
	public RestClient restClient;
	public CSVFileWriter csvFileWriter;
	
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
		csvFileWriter= new CSVFileWriter();
		games_tv_homepage= new  Games_tv_actions(driver);
	}
}

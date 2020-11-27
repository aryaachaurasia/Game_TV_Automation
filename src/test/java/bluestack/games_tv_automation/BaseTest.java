package bluestack.games_tv_automation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	SessionInitiator test;
	
	@BeforeClass
	public void runBeforeClass() {
		System.out.println("Class execution started");
		// add all before class requirement
		setUpBaseConditionsAndData();
	}
	
	public void setUpBaseConditionsAndData() {
		test=new SessionInitiator();
	}
	
	@AfterClass
	public void closeSession() {
		test.closeBrowserSession();
	}

}

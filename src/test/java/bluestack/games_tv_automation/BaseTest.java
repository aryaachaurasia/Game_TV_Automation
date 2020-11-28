package bluestack.games_tv_automation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

//BaseTest will be super class of all tests class.
//It will have all the default BeforeClass method for setting up base conditions and data
//AfterClass to handle closing session/ window etc
//Initialize SessionInitiator object here to be used by all the child test classes
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

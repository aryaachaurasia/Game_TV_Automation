package bluestack.games_tv_keywords;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.BasicUI;
import utilityClasses.RestClient;

//implement all the function/ Actions class here
//test class will call functions from here
//Initialize this class in SessionInitiator class

public class Games_tv_actions extends BasicUI {

	RestClient restClient=new RestClient();
	public Games_tv_actions(WebDriver driver) {
		super(driver);
	}

	public void verifyUserIsOnGamesTVHomePage() {
		String altText=element("heading_gameTV").getAttribute("alt");
		Assert.assertTrue(altText.contains("game.tv"), "[AssertFail] Games TV logo is not shwown");
		System.out.print("[Assert Pass] User is on Game TV homepage");
	}

	protected void scrollDown(WebElement element) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", element);
		System.out.println("Scrolled to element "+element);
	}
	public List<ArrayList<String>> getAllDetailsOfAvailableGames() {
		List<ArrayList<String>> allGamesDetails=new ArrayList<ArrayList<String>>();
		scrollDown(element("heading_availableGames"));
		List<WebElement> elements=elements("list_games");
		int noOfGames=elements.size();
		for(int i=1;i<=noOfGames; i++) {
			element("gameTile", ""+i).click();
			ArrayList<String> gameDetails= getGameDetails(i);
			allGamesDetails.add(gameDetails);
			waitForsec(2);
			navigateToBackPage();
			waitForsec(2);
		}
		return allGamesDetails;
	}

	private ArrayList<String> getGameDetails(int i) {
		ArrayList<String> gameDetails=new ArrayList<String>();
		String gameName=getGameName();
		String gamePageURL=getGamePageURL();
		int gamePageHTTPStatus= getGamePageHTTPStatus(gamePageURL);
		String countTournaments=getTournaments();
		gameDetails.add(i+"");
		gameDetails.add(gameName);
		gameDetails.add(gamePageURL);
		gameDetails.add(gamePageHTTPStatus+"");
		gameDetails.add(countTournaments);
		return gameDetails;
		
	}

	private int getGamePageHTTPStatus(String gamePageURL) {
		return restClient.httpResponseCodeViaGet(gamePageURL);
	}

	private String getGamePageURL() {
		return getCurrentPageURL();
	}

	private String getGameName() {
		String gameName=element("heading_gamesName").getText();
		return gameName.replace("Tournaments", "");
	}

	private String getTournaments() {
		String noOfTournaments=element("count_tournament").getText().replaceAll(",", "");
		System.out.println(noOfTournaments);
		return noOfTournaments;
	}

	private void waitForsec(int sec) {
		try {
			Thread.sleep(sec*1000);
		}
		catch(InterruptedException exp) {
			System.out.println("Wait over condition not pass"+ exp);
		}
	}

	public void navigateToBackPage() {
		driver.navigate().back();
		System.out.println("Step : navigate to back page\n");
	}
	
	
	
	
	
}

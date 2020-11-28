package bluestack.games_tv_automation;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import utilityClasses.CSVFileWriter;

//Games_tv_tests is main test class it will extend Base class
//Execute the test and will write data all data to a csv file

public class Games_tv_tests extends BaseTest{	
	
	@Test(description="Get list of All Games along with other data")
	public void Test_01_Verify_Games_Tiles_And_Get_All_Games_list_Along_With_All_Data() {
		test.launchApplication("https://game.tv");
		test.games_tv_homepage.verifyUserIsOnGamesTVHomePage();
		String headers[]= {"#", "Game Name", "Page URL", "Page Status", "Tournament Count"};
		List<ArrayList<String>> gamesRecords=test.games_tv_homepage.getAllDetailsOfAvailableGames();
		CSVFileWriter.writeAllDataToCSVFile("Games_Tournament_Details.csv", headers, gamesRecords);
	}
}

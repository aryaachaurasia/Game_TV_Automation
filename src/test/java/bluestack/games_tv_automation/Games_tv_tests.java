package bluestack.games_tv_automation;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class Games_tv_tests extends BaseTest{
	
	String filepath;
	
	
	@Test(description="Get list of All Games along with other data")
	public void Test_01_Verify_Games_Tiles_And_Get_All_Games_list_Along_With_All_Data() {
		test.launchApplication("https://game.tv");
		test.games_tv_homepage.verifyUserIsOnGamesTVHomePage();
		List<ArrayList<String>> gamesPack=test.games_tv_homepage.getAllDetailsOfAvailableGames();
		for(ArrayList<String> games: gamesPack) {
			for(String game: games) {
				System.out.print("tournament "+game);
			}
			System.out.println();
		}
		
		
	}
}

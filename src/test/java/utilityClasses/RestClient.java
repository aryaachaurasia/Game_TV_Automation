package utilityClasses;
import io.restassured.RestAssured;

public class RestClient {

	public int httpResponseCodeViaGet(String url) {
		return RestAssured.get(url).statusCode();
	}

	public int httpResponseCodeViaPost(String url) {
		return RestAssured.post(url).statusCode();
	}
}



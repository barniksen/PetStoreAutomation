package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {

	static ResourceBundle getUrl() {
		return ResourceBundle.getBundle("routes");
	}
	
	public static Response createUser(User payload) {
		
		return given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(getUrl().getString("postUrl"));
		
	}
	
	public static Response readUser(String username) {
		
		return given()
				.pathParam("username", username)
			.when()
				.get(getUrl().getString("getUrl"));
		
	}
	
	public static Response updateUser(String username, User payload) {
		
		return given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", username)
			.body(payload)
		.when()
			.put(getUrl().getString("updateUrl"));
		
	}
	
	public static Response deleteUser(String username) {
		
		return given()
				.pathParam("username", username)
			.when()
				.delete(getUrl().getString("deleteUrl"));
		
	}

}

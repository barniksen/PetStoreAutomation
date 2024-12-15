package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	public static Response createUser(User payload) {
		
		return given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.postUrl);
		
	}
	
	public static Response readUser(String username) {
		
		return given()
				.pathParam("username", username)
			.when()
				.get(Routes.getUrl);
		
	}
	
	public static Response updateUser(String username, User payload) {
		
		return given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", username)
			.body(payload)
		.when()
			.put(Routes.updateUrl);
		
	}
	
	public static Response deleteUser(String username) {
		
		return given()
				.pathParam("username", username)
			.when()
				.delete(Routes.deleteUrl);
		
	}

}

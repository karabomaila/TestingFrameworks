package api_tests.user_endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testing.model.User;

public class UserAPI {
    public static String baseURL = "https://petstore.swagger.io/v2/";
    public static Response createUser(User user){
        return RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(user).when().post(baseURL + "user").then().extract().response();
    }

    public static Response getUser(String username){
        return RestAssured.given().pathParam("username", username).when()
                .get(baseURL + "users/{username}").then().extract().response();
    }

    public static Response updateUser(String username, User user){
        return RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .pathParam("username", username)
                .body(user).when().put(baseURL + "user/{username}").then().extract().response();
    }

    public static Response deleteUser(String username){
        return RestAssured.given().pathParam("username", username).when()
                .delete(baseURL + "users/{username}").then().extract().response();
    }
}

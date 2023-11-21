package api_tests;

import io.restassured.RestAssured;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestCases {

    @Test
    public void getAllUsers(){
        RestAssured.given().get("https://reqres.in/api/users?page=2").then().statusCode(200)
                .body("data[4].first_name", equalTo("George"));
    }

    @Test
    public void addUser(){
        HashMap data = new HashMap<>();
        data.put("name", "morpheus");
        data.put("jop", "Leader");

        RestAssured.given().contentType("application/json").accept("application/json").when()
                .body(data)
                .post("https://reqres.in/api/users").then().statusCode(201).log().body();
    }

    @Test
    public void updateUser(){
        HashMap data = new HashMap<>();
        data.put("name", "morpheus");
        data.put("jop", "Teacher");

        RestAssured.given().contentType("application/json").accept("application/json").when()
                .body(data)
                .put("https://reqres.in/api/users/431").then().statusCode(200).log().body();
    }

    @Test
    public void patchUser(){
        HashMap data = new HashMap<>();
        data.put("jop", "Principal");

        RestAssured.given().contentType("application/json").accept("application/json").when()
                .body(data)
                .patch("https://reqres.in/api/users/431").then().statusCode(200).log().body();
    }

    @Test
    public void deleteUser(){
        RestAssured.when()
                .delete("https://reqres.in/api/users/431").then().statusCode(204).log().body();
    }

    @Test
    public void validateSchema(){
        RestAssured.given().get("https://reqres.in/api/users?page=2").then()
                .assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
                .statusCode(200);
    }
}

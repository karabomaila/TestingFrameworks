package stepsdefinition;

import com.google.gson.JsonObject;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

public class Products {
    private String baseURL;
    private Response response;

    private JsonObject jsonObject;

    @Given("that I make a request to the get products endpoint")
    public void that_I_make_a_request_to_the_get_products_endpoint() {
        // Write code here that turns the phrase above into concrete actions
        baseURL = "https://fakestoreapi.com/";
    }

    @When("I send the request to the api")
    public void i_send_the_request_to_the_api() {
        // Write code here that turns the phrase above into concrete actions
        response = RestAssured.given().get(baseURL + "products").then().extract().response();
    }

    @Then("I receive the response code 200 and the products data")
    public void i_receive_the_response_code_and_the_products_data() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Then("verify that the rate of the first product is {double}")
    public void verifyFirstProductRate(double rating) {
        JsonPath jsonPath = response.jsonPath();
        String rate = jsonPath.getJsonObject("rating[0].rate").toString();
        Assert.assertEquals(rating, Double.parseDouble(rate));
    }

    @Given("that I have a new product")
    public void postEndpoint() {
        jsonObject = new JsonObject();
        jsonObject.addProperty("title", "shoes");
        jsonObject.addProperty("price", "");
        jsonObject.addProperty("description", "shoes");
        jsonObject.addProperty("image", "https://shoes.io");
        jsonObject.addProperty("category", "shoes");
    }

    @When("I make a request to the post url")
    public void sendRequestPostUrl() {
        response = RestAssured.given().contentType(ContentType.JSON).body(jsonObject.toString())
                .post(baseURL + "products").then().extract().response();
    }

    @Then("I should receive response code 200")
    public void validateResponseCode() {
        Assert.assertEquals(200, response.getStatusCode());
    }
}

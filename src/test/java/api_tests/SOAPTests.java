package api_tests;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

public class SOAPTests {

    private String baseURL;

    @Before
    public void setBaseURL(){
        baseURL = "http://www.dneonline.com";
    }

    @Test
    public void testSOAP(){
        RestAssured.given().contentType("text/xml").accept("text/xml");
    }
}

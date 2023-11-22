package api_tests.user_endpoints;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.testing.model.User;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTests {
    User user;
    @Before
    public void loadData(){
        user = new User();
        user.setId(3);
        user.setEmail("doe@gmail.com");
        user.setFirstName("Doe");
        user.setLastName("John");
        user.setPassword("333333");
        user.setPhone("08123457");
        user.setUsername("doe.john@mail.com");
    }

    @Test()
    @Order(1)
    public void testCreateUser(){
        Response response = UserAPI.createUser(user);
        response.then().log().all();
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    @Order(2)
    public void testGetUser(){
        Response response = UserAPI.getUser(user.getUsername());
        response.then().log().all();
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    @Order(3)
    public void testUpdateUser(){
        user.setFirstName("Hayden");
        user.setLastName("Lebsack");
        Response response = UserAPI.updateUser(user.getUsername(), user);
        response.then().log().all();
        Assert.assertEquals(200, response.getStatusCode());

        Response response1 = UserAPI.getUser(user.getUsername());
        Assert.assertEquals(200, response1.getStatusCode());
    }

    @Test
    @Order(4)
    public void testDeleteUser(){
        Response response = UserAPI.deleteUser(user.getUsername());
        response.then().log().all();
        Assert.assertEquals(200, response.getStatusCode());
    }

}

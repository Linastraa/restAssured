package homeworks;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HomeWork11 {
    @Test
    public void test() {

        String url = "https://automationexercise.com/api/productsList";
        Response response = given().get(url);
        response.jsonPath().prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        int numberOfWomen = jsonPath.getList("products.category.usertype.findAll { it.usertype == 'Women' }").size();
        System.out.println(numberOfWomen);

        Assert.assertEquals(numberOfWomen, 12);
    }
}

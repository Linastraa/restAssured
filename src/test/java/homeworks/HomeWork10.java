package homeworks;


import base_urls.HomeWork10BaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class HomeWork10 extends HomeWork10BaseUrl {
    @Test
    public void getRequestPojoTest() {
        //spec.pathParams("first", "");
        String url = "https://petstore.swagger.io/v2/pet/findByStatus?status=available";
        Response response = given().get(url);
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        List<Integer> data = jsonPath.getList("data");
        boolean test=(data.size()>100);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertTrue(test);
        softAssert.assertAll();
    }
}

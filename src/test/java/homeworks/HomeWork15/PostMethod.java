package homeworks.HomeWork15;


import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class PostMethod extends BaseUrl {

    @Test
    public void postRequest() {
        spec.pathParams("first", "");

        PlaceHolder placeHolder = new PlaceHolder();
        placeHolder.setFirstName("Test");
        placeHolder.setLastName("User");
        placeHolder.setEmail("test2345@fake.com");
        placeHolder.setPassword("myPassword");


        PlaceHolder expectedData = new PlaceHolder("Test","User","test@fake.com",
                "myPassword");


        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        PlaceHolder actualData = response.as(PlaceHolder.class);
        System.out.println("actualData= "+actualData);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(), 201);
        softAssert.assertEquals(actualData.getFirstName(), expectedData.getFirstName());
        softAssert.assertEquals(actualData.getLastName(), expectedData.getLastName());
        softAssert.assertEquals(actualData.getEmail(), expectedData.getEmail());
        softAssert.assertEquals(actualData.getPassword(), expectedData.getPassword());

        softAssert.assertAll();
    }
}

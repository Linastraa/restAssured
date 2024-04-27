package homeworks;

import base_urls.HomeWork9BaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.JsonPlaceHolderPojo_HomeWork9;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class HomeWork9 extends HomeWork9BaseUrl {
    /*
Write an automation test that will create a 'user' using the "https://petstore.swagger.io/" document
*/

    @Test
    public void postRequestPojoTest() {
        spec.pathParams("first", "");

        //Set the expected data --> With Pojo Class
        JsonPlaceHolderPojo_HomeWork9 expectedData = new JsonPlaceHolderPojo_HomeWork9(9,"Linastra","Sulaiman","Alzahrani","test@gmail.com","Test@1420","+966123456789",0);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion
        JsonPlaceHolderPojo_HomeWork9 actualDa = response.as(JsonPlaceHolderPojo_HomeWork9.class);
        System.out.println("actualDa = " + actualDa);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualDa.getId(), expectedData.getId());
        assertEquals(actualDa.getUsername(), expectedData.getUsername());
        assertEquals(actualDa.getFirstName(), expectedData.getFirstName());
        assertEquals(actualDa.getLastName(), expectedData.getLastName());
        assertEquals(actualDa.getEmail(), expectedData.getEmail());
        assertEquals(actualDa.getPassword(), expectedData.getPassword());
        assertEquals(actualDa.getPhone(), expectedData.getPhone());
        assertEquals(actualDa.getUserStatus(), expectedData.getUserStatus());

    }
}

package homeworks.HomeWork9;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class HomeWork9 extends BaseUrl {
    /*
Write an automation test that will create a 'user' using the "https://petstore.swagger.io/" document
*/

    @Test
    public void postRequest() {
        spec.pathParams("first", "");

        PlaceHolder placeHolder = new PlaceHolder();
        placeHolder.setId(9);
        placeHolder.setUsername("Linastra");
        placeHolder.setFirstName("Sulaiman");
        placeHolder.setLastName("Alzahrani");
        placeHolder.setEmail("test@gmail.com");
        placeHolder.setPassword("Test@1420");
        placeHolder.setPhone("+966123456789");
        placeHolder.setUserStatus(6);

        //saving the parameters with the name expectedData to post it into the server
        PlaceHolder expectedData = new PlaceHolder(9,"Linastra","Sulaiman","Alzahrani","test@gmail.com","test@gmail.com","+966123456789",6);

        //posing the parameters
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //getting the parameters after posting it to do assertions
        PlaceHolder actualDa = response.as(PlaceHolder.class);
        System.out.println("actualDa = " + actualDa);

        //assertions
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(actualDa.getId(), expectedData.getId());
        softAssert.assertEquals(actualDa.getUsername(), expectedData.getUsername());
        softAssert.assertEquals(actualDa.getFirstName(), expectedData.getFirstName());
        softAssert.assertEquals(actualDa.getLastName(), expectedData.getLastName());
        softAssert.assertEquals(actualDa.getEmail(), expectedData.getEmail());
        softAssert.assertEquals(actualDa.getPassword(), expectedData.getPassword());
        softAssert.assertEquals(actualDa.getPhone(), expectedData.getPhone());
        softAssert.assertEquals(actualDa.getUserStatus(), expectedData.getUserStatus());
        softAssert.assertAll();

    }
}

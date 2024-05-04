package homeworks.HomeWork13;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class PostMethod extends BaseUrl{

/** Write an automation test that will create a 'user' then read, update and delete the created user
    using the "https://petstore.swagger.io/" document. (Create a classes for each request.) **/

    @Test
    public void postRequest() {
        spec.pathParams("first", "");

        PlaceHolder placeholder = new PlaceHolder();
        placeholder.setId(9);
        placeholder.setUsername("Linastra");
        placeholder.setFirstName("Sulaiman");
        placeholder.setLastName("Alzahrani");
        placeholder.setEmail("test@gamil.com");
        placeholder.setPassword("12344321");
        placeholder.setPhone("+966123456789");
        placeholder.setUserStatus(4);

        //saving the parameters with the name expectedData to post it into the server
        PlaceHolder expectedData = new PlaceHolder(9,"Linastra","Sulaiman","Alzahrani","test@gamil.com","12344321","+966123456789",4);

        //posing the parameters
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //getting the parameters after posting it to do assertions
        PlaceHolder actualData = response.as(PlaceHolder.class);
        System.out.println("actualData = " + actualData);

        //assertions
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(actualData.getId(), expectedData.getId());
        softAssert.assertEquals(actualData.getUsername(), expectedData.getUsername());
        softAssert.assertEquals(actualData.getFirstName(), expectedData.getFirstName());
        softAssert.assertEquals(actualData.getLastName(), expectedData.getLastName());
        softAssert.assertEquals(actualData.getEmail(), expectedData.getEmail());
        softAssert.assertEquals(actualData.getPassword(), expectedData.getPassword());
        softAssert.assertEquals(actualData.getPhone(), expectedData.getPhone());
        softAssert.assertEquals(actualData.getUserStatus(), expectedData.getUserStatus());
        softAssert.assertAll();
    }
}

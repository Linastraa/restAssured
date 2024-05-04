package homeworks.HomeWork16;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class PutMethod extends BaseUrl{
    @Test
    public void postRequest() {
        spec.pathParams("first", "");

        PlaceHolder placeHolder = new PlaceHolder();
        placeHolder.setFirstName("Amy");
        placeHolder.setLastName("Miller");
        placeHolder.setBirthdate("1992-02-02");
        placeHolder.setEmail("amiller@fake.com");
        placeHolder.setPhone("8005554242");
        placeHolder.setStreet1("1 Main St.");
        placeHolder.setStreet2("Apartment A");
        placeHolder.setCity("Anytown");
        placeHolder.setStateProvince("KS");
        placeHolder.setPostalCode("12345");
        placeHolder.setCountry("Canada");

        PlaceHolder expectedData = new PlaceHolder("Amy","Miller","1992-02-02",
                "amiller@fake.com","8005554242", "1 Main St.","Apartment A",
                "Anytown","KS","12345","Canada");


        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        PlaceHolder actualData = response.as(PlaceHolder.class);
        System.out.println("actualData= "+actualData);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(), 201);
        softAssert.assertEquals(actualData.getFirstName(), expectedData.getFirstName());
        softAssert.assertEquals(actualData.getLastName(), expectedData.getLastName());
        softAssert.assertEquals(actualData.getBirthdate(), expectedData.getBirthdate());
        softAssert.assertEquals(actualData.getEmail(), expectedData.getEmail());
        softAssert.assertEquals(actualData.getPhone(), expectedData.getPhone());
        softAssert.assertEquals(actualData.getStreet1(), expectedData.getStreet1());
        softAssert.assertEquals(actualData.getStreet2(), expectedData.getStreet2());
        softAssert.assertEquals(actualData.getCity(), expectedData.getCity());
        softAssert.assertEquals(actualData.getStateProvince(), expectedData.getStateProvince());
        softAssert.assertEquals(actualData.getPostalCode(), expectedData.getPostalCode());
        softAssert.assertEquals(actualData.getCountry(), expectedData.getCountry());
        softAssert.assertAll();
    }
}

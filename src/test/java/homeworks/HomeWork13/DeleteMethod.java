package homeworks.HomeWork13;

import homeworks.HomeWork13.PlaceHolder;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class DeleteMethod extends BaseUrl{

    @Test
    public void deleteRequest(){
        spec.pathParams("first", "Linastra");

        PlaceHolder expectedData = new PlaceHolder();

        Response response = given(spec).delete("{first}");//First create a data and delete it. Do not delete some else's data.
        response.prettyPrint();

        PlaceHolder actualData = response.as(PlaceHolder.class);
        System.out.println("actualDa = " + actualData);

        //assertions
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(response.contentType(), "unknown");
        softAssert.assertEquals(actualData, expectedData);
    }
}
